package com.mda.server.web;
import com.mda.server.domain.evalSubject.EvalSubectRepository;
import com.mda.server.domain.evalSubject.EvalSubject;
import com.mda.server.domain.schedule.Schedule;
import com.mda.server.domain.user.User;
import com.mda.server.service.Location.LocationService;
import com.mda.server.service.evalSubject.EvalSubjectService;
import com.mda.server.service.place.PlaceService;
import com.mda.server.service.schedule.ScheduleService;
import com.mda.server.service.user.UserService;
import com.mda.server.web.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.mda.server.domain.place.Place;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
public class LocationController{
    private @Autowired LocationService locationService;

    @Autowired
    private UserService userService;

    @Autowired
    private PlaceService placeService;

    @Autowired
    private EvalSubjectService evalSubjectService;

    LocInitSet locSet = new LocInitSet();
    infoList infoList = new infoList();
    ArrayList<UserEnter> userEnterList = new ArrayList<>();
    int userEnterCnt = 0;


    /**
     * @Class Name : LocationController.java
     * @title : userEnter
     * @param : userId, userLatitude, userLongtitude : Http
     * @returnType : UserEnter
     * @since 2021.  05
     * @dscription : 사용자의 위도경도 받아 userEnterList에 add후 UserEnter객체로 return, userEnterCnt가 3이상일경우 userEnterList를 초기화한다.
     *
     * << 개정이력(Modification Information) >>
     *  수정일           수정자        수정내용
     * ---------------------------------------------------
     * 2021. 05.                    최초생성
     * 2021. 06. 01                 테스트완료
     */


    @PostMapping(value = "/userEnter")
    public UserEnter userEnter(HttpServletRequest request){
        UserEnter ue  = new UserEnter();
        ue.setUserId(request.getParameter("userId"));
        ue.setUserLatitude(Double.parseDouble(request.getParameter("userLatitude")));
        ue.setUserLongitude(Double.parseDouble(request.getParameter("userLongitude")));

        userEnterCnt ++;
        if(userEnterCnt > 3){
            userEnterList.clear();
            userEnterCnt = 1;
        }
        userEnterList.add(ue);
        return ue;
    }


    /**
     * @Class Name : LocationController.java
     * @title : userEnterList
     * @param :
     * @returnType : ArrayList<UserEnter>
     * @since 2021.  05
     * @dscription : url호출시 userEnterList를 return한다.
     *
     * << 개정이력(Modification Information) >>
     *  수정일           수정자        수정내용
     * ---------------------------------------------------
     * 2021. 05.                    최초생성
     * 2021. 06. 01                 테스트완료
     */

    @GetMapping(value = "/userEnterList")
    public ArrayList<UserEnter> userEnterList(HttpServletRequest request){
        return userEnterList;
    }


    /**
     * @Class Name : LocationController.java
     * @title : locInitSet
     * @param : schName, schAge, schGender, schpeople, schType, schPlaceCate : http
     * @returnType : LocInitSet
     * @since 2021.  05
     * @dscription : 최초 약속 설정시 약속정보를 받아 LocInitSet객체에 저장한다.
     *
     * << 개정이력(Modification Information) >>
     *  수정일           수정자        수정내용
     * ---------------------------------------------------
     * 2021. 05.                    최초생성
     * 2021. 06. 01                 테스트완료
     */

    @RequestMapping(value = "/locationInitSet", method= RequestMethod.POST)
    public LocInitSet locInitSet(HttpServletRequest request) {
        locSet.setSchName(request.getParameter("schName"));
        locSet.setSchAge(request.getParameter("schAge"));
        locSet.setSchGender(request.getParameter("schGender"));
        locSet.setSchPeople(request.getParameter("schPeople"));
        locSet.setSchType(request.getParameter("schType"));
        locSet.setSchPlaceCate(request.getParameter("schPlaceCate"));

        return locSet;
    }

    @GetMapping("/locationInitSet")
    public LocInitSet loc(){
        return locSet;
    }


    /**
     * @Class Name : LocationController.java
     * @title : getMidAndPlace
     * @param : latitude123, longitude123, userName123, userId123 : http
     * @returnType : midAndPlace
     * @since 2021.  05
     * @dscription :  1. 각 User들의 위도,경도 받아서 중간위도,경도를 구한다
     *                2. 중간위치 값으로 반경(1000m)내에있는 역 3개중 가장 거리가(미터기준)가까운 역의 위,경도로 중간위치 재셋팅한다
     *                3. locSet객체값 참조하여 place정보를 가져온다
     *                4. 각user들의 위도경도, 최종 중간위도경도를 midAndPlace에셋팅, place정보를 infoList에셋팅 후,  midAndPlace를 return한다
     *                 
     *
     * << 개정이력(Modification Information) >>
     *  수정일           수정자        수정내용
     * ---------------------------------------------------
     * 2021. 05.                    최초생성
     * 2021. 06. 01                 테스트완료
     */

    @GetMapping(value = "/midAndPlace")
    public midAndPlace getMidAndPlace(HttpServletRequest request) throws IOException {
        midAndPlace map = new midAndPlace();
        double midLat = 0; //중간위치 위도
        double midLong = 0; //중간위치 경도
        String stnNm = ""; //최종 중간위치 역 이름
        
//        double latitude1 = Double.parseDouble(request.getParameter("latitude1"));
//        double latitude2 = Double.parseDouble(request.getParameter("latitude2"));
//        double latitude3 = Double.parseDouble(request.getParameter("latitude3"));
//        double longitude1 = Double.parseDouble(request.getParameter("longitude1"));
//        double longitude2 = Double.parseDouble(request.getParameter("longitude2"));
//        double longitude3 = Double.parseDouble(request.getParameter("longitude3"));
//        int userId1 = Integer.parseInt(request.getParameter("userId1"));
//        int userId2 = Integer.parseInt(request.getParameter("userId2"));
//        int userId3 = Integer.parseInt(request.getParameter("userId3"));
//        String userName1 = request.getParameter("userName1");
//        String userName2 = request.getParameter("userName2");
//        String userName3 = request.getParameter("userName3");

        double latitude1 = 37.66657228807503;
        double longitude1 = 126.76327377041474;
        double latitude2 = 37.648984;
        double longitude2 =  126.774089;
        double latitude3 = 37.671873;
        double longitude3 = 126.785645;

        //가라코드...
        UserEnter ue1 = new UserEnter("1",latitude1, longitude1);
        UserEnter ue2 = new UserEnter("2",latitude2, longitude2);
        UserEnter ue3 = new UserEnter("3",latitude3, longitude3);
        userEnterList.add(ue1);userEnterList.add(ue2);userEnterList.add(ue3);


        //1. 유저들 간의 중간 위도경도 구하기
//        midLat = (latitude1+latitude2+latitude3) /3;
//        midLong = (longitude1+longitude2+longitude3)/3;
        midLat = 37.659627;
        midLong = 126.773459;

        //2. API사용해서 반경내의 역중 가장 가까운역으로 중간위치 재셋팅
        String apiKey = "9if76bfpjJjxcws6twPhkPfKHbQecu3JLLgD23UpjpQ";// ODsay 인증키
        String rst = "";// 파싱해온 데이터
        try {
            URL url = new URL("https://api.odsay.com/v1/api/pointSearch?lang=0&x=126.987179&y=37.568217&radius=500&stationClass=2&apiKey="+apiKey);
            BufferedReader bf;
            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            rst = bf.readLine();
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject)jsonParser.parse(rst);
            JSONObject result = (JSONObject)jsonObject.get("result");
            JSONArray station = (JSONArray)result.get("station"); //반경내 역정보
            JSONObject stationInfo = null; //최종 선정된 역정보가 들어갈 변수

            int stationSz = 0; //근처 역 3개로 제한
            if(station.size() > 3){
                stationSz = 3;
            }else{
                stationSz = station.size();
            }


            double[] distance = new double[stationSz]; 
            for(int i=0; i<stationSz; i++){
                stationInfo = (JSONObject)station.get(i);
                double tempStnLat = (double) stationInfo.get("y"); //반경내역의 위도
                double tempStnLong = (double) stationInfo.get("x"); // 반경내역의 경도
                System.out.println("tempStnLat " + tempStnLat);
                System.out.println("tempStnLong" + tempStnLong);
                distance[i] = distance(midLat, midLong, tempStnLat, tempStnLong); //중간위치와 반경내역까지의 거리계산후 배열에 넣어줌
                System.out.println("3 - " + i + distance[i]);
            }

            double min = 500;
            for(int i=0; i<stationSz; i++) { //중간위치에서 가장 가까운역 찾기 (배열사이즈가 1일경우 대비해 min값 반경거리로 설정)
                if(distance[i] < min) {
                    min = distance[i];
                    stationInfo = (JSONObject)station.get(i);
                }
            }

            midLat = (double) stationInfo.get("y"); //최종 중간위치로 결정된 역의 위도
            midLong = (double) stationInfo.get("x"); //최종 중간위치로 결정된 역의 경도
            stnNm = stationInfo.get("stationName").toString(); //최종 중간위치로 결정된 역의 이름
        }catch(Exception e) {
            e.printStackTrace();
        }

        //3. locInitSet 정보 기반으로 place 찾기
        List<Place> placeList = new ArrayList<Place>();
        placeList = locationService.getPlaceDetailInfo(locSet, stnNm);
        placeList.get(0).getPlaceId();

        //4. midAndplace, infolist 객체셋팅후 midAndplace return
        map.setMidLat(midLat);
        map.setMidLong(midLong);
        map.setLatitude1(userEnterList.get(0).getUserLatitude());
        map.setLatitude2(userEnterList.get(1).getUserLatitude());
        map.setLatitude3(userEnterList.get(2).getUserLatitude());
        map.setLongitude1(userEnterList.get(0).getUserLongitude());
        map.setLongitude2(userEnterList.get(1).getUserLongitude());
        map.setLongitude3(userEnterList.get(2).getUserLongitude());
        map.setUserId1(Integer.parseInt(userEnterList.get(0).getUserId()));
        map.setUserId2(Integer.parseInt(userEnterList.get(1).getUserId()));
        map.setUserId3(Integer.parseInt(userEnterList.get(2).getUserId()));
        map.setUserName1("koo");
        map.setUserName2("sim");
        map.setUserName3("you");

//        map.setUserName1(request.getParameter("userName1"));
//        map.setUserName2(request.getParameter("userName2"));
//        map.setUserName3(request.getParameter("userName3"));
        //가라
//        map.setLatitude1(latitude1);map.setLatitude2(latitude2);map.setLatitude3(latitude3);
//        map.setLongitude1(longitude1);map.setLongitude2(longitude2);map.setLongitude3(longitude3);
//        map.setUserId1("0");map.setUserId2("1");map.setUserId3("2");
//        map.setUserName1("Alice");
//        map.setUserName2("Bob");
//        map.setUserName3("Charlie");


        infoList.setPlaceId1(placeList.get(0).getPlaceId());
        infoList.setPlaceId2(placeList.get(1).getPlaceId());
        infoList.setPlaceId3(placeList.get(2).getPlaceId());
        infoList.setPlaceName1(placeList.get(0).getPlaceName());
        infoList.setPlaceName2(placeList.get(1).getPlaceName());
        infoList.setPlaceName3(placeList.get(2).getPlaceName());
        infoList.setPlaceArea1(placeList.get(0).getPlaceArea());
        infoList.setPlaceArea2(placeList.get(1).getPlaceArea());
        infoList.setPlaceArea3(placeList.get(2).getPlaceArea());
        String pType1 = placeList.get(0).getPlaceType();
        String pType2 = placeList.get(1).getPlaceType();
        String pType3 = placeList.get(2).getPlaceType();
        String[]pTypeArray1 = pType1.split(",");
        String[]pTypeArray2 = pType2.split(",");
        String[]pTypeArray3 = pType3.split(",");
        String pTypeText1 = "";
        String pTypeText2 = "";
        String pTypeText3 = "";
        EvalSubjectDto eval = new EvalSubjectDto();
        for(int i=0; i<pTypeArray1.length; i++){
            eval = evalSubjectService.findById(Integer.parseInt(pTypeArray1[i]));
            String tempPtype1 = eval.getEvalSubType();
            pTypeText1 += " #"+ tempPtype1;
        }
        for(int i=0; i<pTypeArray2.length; i++){
            eval = evalSubjectService.findById(Integer.parseInt(pTypeArray2[i]));
            String tempPtype2 = eval.getEvalSubType();
            pTypeText2 += " #"+ tempPtype2;
        }
        for(int i=0; i<pTypeArray3.length; i++){
            eval = evalSubjectService.findById(Integer.parseInt(pTypeArray3[i]));
            String tempPtype3 = eval.getEvalSubType();
            pTypeText3 += " #"+ tempPtype3;
        }
        infoList.setPlaceType1(pTypeText1);
        infoList.setPlaceType2(pTypeText2);
        infoList.setPlaceType3(pTypeText3);
        return map;
    }


    /**
     * @Class Name : LocationController.java
     * @title : infoList
     * @param :
     * @returnType : infoList
     * @since 2021.  05
     * @dscription : url호출시 /midAndPlace에서 셋팅된 infoList(place정보)를 return한다.
     *
     * << 개정이력(Modification Information) >>
     *  수정일           수정자        수정내용
     * ---------------------------------------------------
     * 2021. 05.                    최초생성
     * 2021. 06. 01                 테스트완료
     */
    
    @GetMapping(value = "/infoList")
    public infoList infoList(HttpServletRequest request) throws IOException {
        return infoList;
    }


    /**
     * @Class Name : LocationController.java
     * @title : saveSchDT
     * @param : schDate, schTime, placeId : http
     * @returnType : schDT
     * @since 2021.  05
     * @dscription : locaSet, userEnterList 객체값과 파라미터 참조하여 Schedule테이블에 각각 user의 최종 스케쥴을 insert한다
     *
     * << 개정이력(Modification Information) >>
     *  수정일           수정자        수정내용
     * ---------------------------------------------------
     * 2021. 05.                    최초생성
     * 2021. 06. 01                 테스트완료
     */

   /*
    @RequestMapping(value = "/schDT", method= RequestMethod.POST)
    public schDT saveSchDT(HttpServletRequest request) {
        Schedule sd = new Schedule();
        schDT cs = new schDT();
        String name = "";
        int schId = 0;

        System.out.println(request.getParameter("placeId")+" / "
                +request.getParameter("schDate")+" / "
                +request.getParameter("schTime"));
        int pid = Integer.parseInt(request.getParameter("placeId"));
        PlaceDto placeDto = new PlaceDto();
        placeDto = placeService.findById(pid);

        //스케쥴이 인원수만큼 들어가게 되는데, 공통으로 들어갈 수 있는 것들은 한꺼번에 저장해주자
        sd.setSchedulePlaceId(request.getParameter("placeId")); //parameter값 셋팅
        sd.setSchedulePlaceName(placeDto.getPlaceName()); // placeId로 가져오기
        sd.setScheduleName(locSet.getSchName()); //locSet에서 가져오기
        sd.setScheduleDate(request.getParameter("schDate")); //parameter값 셋팅
        sd.setScheduleTime(request.getParameter("schTime")); //parameter값 참조
        //scheduleUserName이면 주최자를 말하는건가??
        sd.setScheduleUserName("kim"); //userId로 가져오기 이것도 for문으로 해야됨
        sd.setSchedulePeopleNum(locSet.getSchPeople()); //locSet값 참조
        sd.setSchedulePlaceArea("서울역"); //placeId로 가져오기

//        UserResponseDto u = new UserResponseDto();
//        u = userService.findById(1);

        //따로 유동적으로 들어가야하는 것들
        for(int i=0; i<userEnterList.size(); i++){ //userEnterList에 있는 길이만큼 돌려서 각각 userId로 인서트

            sd.setScheduleUserId(userEnterList.get(i).getUserId()); //userEnterList에 있는 애들 각각 저장
            UserResponseDto user = new UserResponseDto();
            int uid = Integer.parseInt(userEnterList.get(i).getUserId());
            user = userService.findById(uid);
            name += (user.getUserName()+", ");
            sd.setScheduleWithUserName(name);
            sd.setScheduleWithUserId("1#2"); //어떻게할지생각해보자


            schId = locationService.saveSchedule(sd); //저장하고 id값 반환
        }
        cs.setPlaceId(schId);
        cs.setSchDate(request.getParameter("schDate"));
        cs.setSchTime(request.getParameter("schTime"));


        return cs;
    }
    */


    @RequestMapping(value = "/schDT", method= RequestMethod.POST)
    public schDT saveSchDT(HttpServletRequest request) {
        Schedule sd = new Schedule();
        schDT cs = new schDT();
        int pid = Integer.parseInt(request.getParameter("placeId"));
        PlaceDto placeDto = new PlaceDto();
        placeDto = placeService.findById(pid);
        ArrayList<Schedule> scList = new ArrayList<>();
        int schId = 0;

        UserEnter ue1 = new UserEnter("1",1212, 1212);
        UserEnter ue2 = new UserEnter("2",1212, 1212);
        UserEnter ue3 = new UserEnter("3",1212, 1212);
        userEnterList.add(ue1);userEnterList.add(ue2);userEnterList.add(ue3);

        //스케쥴이 인원수만큼 들어가게 되는데, 공통으로 들어갈 수 있는 것들은 한꺼번에 저장해주자


        //따로 유동적으로 들어가야하는 것들
        for(int i=0; i<userEnterList.size(); i++){ //userEnterList에 있는 길이만큼 돌려서 각각 userId로 인서트
            int uId = Integer.parseInt(userEnterList.get(i).getUserId());
            UserResponseDto userDto = new UserResponseDto();
            userDto = userService.findById(uId); //uId로 조회한 User데이터
            String withUserId = "";
            String withUserName = "";

            sd.setSchedulePlaceId(request.getParameter("placeId")); //parameter값 셋팅
            sd.setSchedulePlaceName(placeDto.getPlaceName()); // placeId로 가져오기
            sd.setSchedulePlaceArea(placeDto.getPlaceArea()); //placeId로 가져오기
            sd.setScheduleName(locSet.getSchName()); //locSet에서 가져오기
            sd.setScheduleDate(request.getParameter("schDate")); //parameter값 셋팅
            sd.setScheduleTime(request.getParameter("schTime")); //parameter값 참조
            sd.setSchedulePeopleNum(locSet.getSchPeople()); //locSet값 참조
            sd.setScheduleUserId(String.valueOf(uId)); //userEnterList에 있는 애들 각각 저장
            sd.setScheduleUserName(userDto.getUserName());
            withUserId += (userDto.getUserId()+"# ");
            withUserName += (userDto.getUserName()+", ");
            sd.setScheduleWithUserName(withUserName); //수정해야할듯
            sd.setScheduleWithUserId(withUserId); //수정해야할듯
            scList.add(sd);
        }
        for(int i=0; i< scList.size(); i++){
            schId = locationService.saveSchedule(scList.get(i)); //저장하고 id값 반환
        }

        return cs;
    }



    /**
     * @Class Name : LocationController.java
     * @title : distance
     * @param : lat1, lon1, lat2, lon2
     * @returnType : double
     * @since 2021.  05
     * @dscription : parameter로 위도경도값을 받아 두 지점사이의 거리를계산하여 반환한다(미터기준)
     *
     * << 개정이력(Modification Information) >>
     *  수정일           수정자        수정내용
     * ---------------------------------------------------
     * 2021. 05.                    최초생성
     * 2021. 06. 01                 테스트완료
     */

    private static double distance(double lat1, double lon1, double lat2, double lon2) {

        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));

        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1609.344;

        return (dist);
    }

    // This function converts decimal degrees to radians
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    // This function converts radians to decimal degrees
    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }

}
