package com.mda.server.web;
import com.mda.server.domain.schedule.Schedule;
import com.mda.server.domain.schedule.ScheduleRepository;
import com.mda.server.service.Location.LocationService;
import com.mda.server.web.dto.*;
import org.hibernate.annotations.SQLInsert;
import org.springframework.beans.factory.annotation.Autowired;
import com.mda.server.domain.place.Place;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class LocationController{
    private @Autowired
    LocationService locationService;
    LocInitSet locSet = new LocInitSet();
    int userEnterCnt = 0;
    UserEnter u1 = new UserEnter();
    ArrayList<UserEnter> userEnterList = new ArrayList<>();
    infoList infoList = new infoList();

    @PostMapping(value = "/userEnter")
    public UserEnter userEnter(HttpServletRequest request){
        UserEnter ue  = new UserEnter();
        ue.setUserId(request.getParameter("userId"));
        ue.setUserLatitude(request.getParameter("userLatitude"));
        ue.setUserLongtitude(request.getParameter("userLongtitude"));
        userEnterCnt ++;
        if(userEnterCnt > 3){
            userEnterList.clear();
            userEnterCnt = 1;
        }
        userEnterList.add(ue);
        return ue;

    }

    @GetMapping(value = "/userEnterList")
    public ArrayList<UserEnter> userEnterList(HttpServletRequest request){
        return userEnterList;

    }


    @RequestMapping(value = "/locationInitSet", method= RequestMethod.POST) //place 뽑을때 참고할 Data
    public LocInitSet locInitSet(HttpServletRequest request) {
        locSet.setSchName(request.getParameter("schName"));
        locSet.setSchAge(request.getParameter("schAge"));
        locSet.setSchGender(request.getParameter("schGender"));
        locSet.setSchPeople(request.getParameter("schPeople"));
        locSet.setSchType(request.getParameter("schType"));
        locSet.setSchPlaceCate(request.getParameter("schPlaceCate"));

        System.out.println(locSet.getSchName() + "/" + locSet.getSchAge() + "/" + locSet.getSchType() + "/" + locSet.getSchGender() + "/" + locSet.getSchPeople() + "/" +
                locSet.getSchPlaceCate());
        return locSet;
    }


    @GetMapping(value = "/midAndPlace")
    public midAndPlace getMidAndPlace(HttpServletRequest request) throws IOException {
        midAndPlace map = new midAndPlace();
/*
        //test용
        double latitude1 = 37.504198; //user1위도
        double latitude2 = 37.501025; //user2위도
      //  double la titude3 = Double.parseDouble(request.getParameter("latitude3")); //user3위도
        double longitude1 = 127.047967; //user1경도
        double longitude2 = 127.037701; //user2경도
       // double longitude3 = Double.parseDouble(request.getParameter("longitude3")); //user3경도*/


        double latitude1 = Double.parseDouble(request.getParameter("latitude1"));
        double latitude2 = Double.parseDouble(request.getParameter("latitude2"));
        double longitude1 = Double.parseDouble(request.getParameter("longitude1"));
        double longitude2 = Double.parseDouble(request.getParameter("longitude2"));

        String UserName1 = "koo"; //user1이름 (HOST)
        String UserName2 = "lee"; //user2이름
        String UserName3 = "kim"; //user2이름

        String midLat = "";
        String midLong = "";
        String stnNm = ""; //최종 중간위치 역 이름


        //1. 중간 위도경도 구하기

        double dLon = Math.toRadians(longitude2 - longitude1);

        //convert to radians
        latitude1 = Math.toRadians(latitude1);
        latitude2 = Math.toRadians(latitude2);
        longitude1 = Math.toRadians(longitude1);

        double Bx = Math.cos(latitude2) * Math.cos(dLon);
        double By = Math.cos(latitude2) * Math.sin(dLon);
        double tempMidLat = Math.atan2(Math.sin(latitude1) + Math.sin(latitude2), Math.sqrt((Math.cos(latitude1) + Bx) * (Math.cos(latitude1) + Bx) + By * By));
        double tempMidLong = longitude1 + Math.atan2(By, Math.cos(latitude1) + Bx);
        tempMidLat = Math.toDegrees(tempMidLat);
        tempMidLong = Math.toDegrees(tempMidLong);

        //2. API사용해서 가까운역으로 위치 셋팅

        // ODsay 인증키
        String apiKey = "9if76bfpjJjxcws6twPhkPfKHbQecu3JLLgD23UpjpQ";

        // 파싱해온 데이터
        String rst = "";

        try {

            URL url = new URL("https://api.odsay.com/v1/api/pointSearch?lang=0&x=126.987179&y=37.568217&radius=500&stationClass=2&apiKey="+apiKey);
            BufferedReader bf;
            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            rst = bf.readLine();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject)jsonParser.parse(rst);
            JSONObject result = (JSONObject)jsonObject.get("result"); //resut Data
            JSONArray station = (JSONArray)result.get("station"); //반경 내 station정보
            JSONObject stationInfo = null; //최종 선정된 역 정보
            System.out.println("1 : " + station);


            int stationSz = 0; //근처 역 3개로 제한
            if(station.size() > 3){
                stationSz = 3;
            }else{
                stationSz = station.size();
            }

            System.out.println("2 : " + stationSz);

            double[] distance = new double[stationSz]; //중간위치에서 역까지의 거리계산후 배열에 넣어줌
            for(int i=0; i<stationSz; i++){
                stationInfo = (JSONObject)station.get(i);
                double x = (double) stationInfo.get("x"); //역의 경도
                double y = (double) stationInfo.get("y"); // 역의 위도
                System.out.println("tempMidLat2 " + tempMidLat);
                System.out.println("tempMidLong2" + tempMidLong);
                distance[i] = distance(tempMidLat, tempMidLong, x, y, "meter");
                System.out.println("3 - " + i + distance[i]);
            }


            double min = 1000;
            for(int i=0; i<stationSz; i++) { //중간위치에서 가장 가까운역 찾기 (배열사이즈가 1일경우 대비해 min값 반경거리로 설정)
                if(distance[i] < min) stationInfo = (JSONObject)station.get(i);
                System.out.println("4 : " + stationInfo);
            }

            midLat = stationInfo.get("x").toString(); //최종역의 경도
            midLong = stationInfo.get("y").toString(); //최종역의 위도
            stnNm = stationInfo.get("stationName").toString(); //최종역의 이름
            System.out.println("5 : " + midLat +"||"+ midLong);

            //최종위치 위도경도 리턴할 객체에 셋팅
            map.setMidLat(midLat);
            map.setMidLong(midLong);
        }catch(Exception e) {
            e.printStackTrace();
        }

        //3. locInitSet 정보 기반으로 place 찾기

        List<Place> placeList = new ArrayList<Place>();
        placeList = locationService.getPlaceDetailInfo(locSet, stnNm);
        System.out.println("5 : " + placeList);
        placeList.get(0).getPlaceId();
        //4. 값 셋팅해서 보내주기

        double latitude3 = Double.parseDouble(request.getParameter("latitude3")); //user3위도
        // placeList.get()

        map.setLatitude1(userEnterList.get(0).getUserLatitude());
        map.setLatitude2(userEnterList.get(1).getUserLatitude());
        map.setLatitude3(userEnterList.get(2).getUserLatitude());
        map.setLongitude1(userEnterList.get(0).getUserLongtitude());
        map.setLongitude2(userEnterList.get(1).getUserLongtitude());
        map.setLongitude3(userEnterList.get(2).getUserLongtitude());
        map.setUserId1(userEnterList.get(0).getUserId());
        map.setUserId2(userEnterList.get(1).getUserId());
        map.setUserId3(userEnterList.get(2).getUserId());
        infoList.setPlaceId1(placeList.get(0).getPlaceId());
        infoList.setPlaceId2(placeList.get(1).getPlaceId());
        infoList.setPlaceId3(placeList.get(2).getPlaceId());
        infoList.setPlaceName1(placeList.get(0).getPlaceName());
        infoList.setPlaceName2(placeList.get(1).getPlaceName());
        infoList.setPlaceName3(placeList.get(2).getPlaceName());
        infoList.setPlaceArea1(placeList.get(0).getPlaceArea());
        infoList.setPlaceArea2(placeList.get(1).getPlaceArea());
        infoList.setPlaceArea3(placeList.get(2).getPlaceArea());
        infoList.setPlaceType1(placeList.get(0).getPlaceType());
        infoList.setPlaceType2(placeList.get(1).getPlaceType());
        infoList.setPlaceType3(placeList.get(2).getPlaceType());

        return map;

    }

    @GetMapping(value = "/infoList")
    public infoList infoList(HttpServletRequest request) throws IOException {
        return infoList;
    }




    private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {

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

    //최종스케쥴 저장
    @RequestMapping(value = "/schDT", method= RequestMethod.POST) //place 뽑을때 참고할 Data
    public schDT saveSchDT(HttpServletRequest request) {
        String result = "";
        Schedule sd = new Schedule();
        schDT cs = new schDT();
        int schId = 0;
        // placeid 가지고 place정보(name,Area) 조회해서 넣어줘야됨
        //userId로 name값 가져와야함
        //

            for(int i=0; i<userEnterList.size(); i++){
                sd.setSchedulePlaceName("tempPlace"); //임시값
                sd.setScheduleDate(request.getParameter("schDate"));
                sd.setScheduleName(locSet.getSchName());
                sd.setSchedulePlaceId(request.getParameter("schPlaceId"));
                sd.setScheduleUserId(userEnterList.get(i).getUserId());
                sd.setScheduleUserName("kim"); //임시값
                sd.setScheduleTime(request.getParameter("schTime"));
                sd.setScheduleWithUserId("1#2"); //임시값
                sd.setScheduleWithUserName("kim#koo"); //임시값
                sd.setSchedulePeopleNum(locSet.getSchPeople());
                sd.setSchedulePlaceArea("서울역"); //임시값
                schId = locationService.saveSchedule(sd);
            }
            cs.setPlaceId(schId);

        return cs;
    }

}
