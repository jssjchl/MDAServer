package com.mda.server.web;


import com.mda.server.domain.place.Place;
import com.mda.server.service.place.PlaceService;
import com.mda.server.web.dto.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
public class PlaceController {

    @Autowired
    PlaceService placeService;
    // .../web/dto/LocInitSet.java로 따로 파일로 클래스 뺐습니다.
    LocInitSet st = new LocInitSet();

    //PlACEDETAIL
    @GetMapping(value= "/getPlaceDetail")
    public PlaceResponseDto findById (HttpServletRequest request){
        return placeService.findById(Integer.valueOf(request.getParameter("placeId")));
    }

    //바로 위에서 입력받은 값들을 확인하기 위해서 만든 컨트롤러
    //@GetMapping("/locationInitSet")
   // public LocInitSet showLocInitSet(){
     //   return st;
   // }


    //장소디테일을 서버에서 보내는 테스트를 위해 만든 컨트롤러
    @GetMapping("/placeDetail")
    public PlaceDto placeDetail(){
        //테스트용으로 만들어서 설정한건데, 실제코드를 사용할때는 db에서 객체로 가져오던가 해서 리턴해줘야할듯?
        PlaceDto placeDetail = new PlaceDto();
        placeDetail.setPlaceArea("경기도 고양시 일산서구");
        placeDetail.setPlaceCategory("카페");
        placeDetail.setPlaceDescription("이건 대충 테스트를 위한 장소 디테일입니다. 와라라라라라라라라라랄라ㅏ랄");
        placeDetail.setPlaceImgUrl("대충 사진URL");
        placeDetail.setPlaceName("스타벅스");

        return placeDetail;
    }


    @GetMapping("getSchedules")
    public ScheduleList getSchedules(){
        ScheduleList s = new ScheduleList();
        s.setUserid(0);
        ArrayList<ScheduleDto> arr = new ArrayList<>();
        ScheduleDto dto = new ScheduleDto();
        dto.setScheduleName("테스트용1");
        ScheduleDto dto2 = new ScheduleDto();
        dto2.setScheduleName("테스트용2");
        arr.add(dto);arr.add(dto2);
        s.setList(arr);
        return s;
    }

    /*
    @GetMapping("/test/param")
    //@RequestParam을 사용하게되면 API에서 넘긴 name이랑 amount 값을 가져와서 String name과 int amount에 넣어주는 과정을 거치게됨
    public String test(@RequestParam("schName") String schName, @RequestParam("schAge") String schAge,
                          @RequestParam("schGender") String schGender, @RequestParam("schPeople") String schPeople,
                          @RequestParam("schType") String schType, @RequestParam("schPlaceCate") String schPlaceCate){


        return "값제대로 왔나용 : " + schName+schAge+schGender+schPeople+schType+schPlaceCate;
    }


    @GetMapping("place/placeList")
    public List<Place> getAllPlace() {return placeService.getPlaceList(); }

    @GetMapping("/getplaceDetail/{id}")
    public PlaceResponseDto findById (@PathVariable Integer id){
        return placeService.findById(id);
    }

    */




    //location setting 수정중
    /*
    @RequestMapping(value="/getMidLocAndPlace", method=RequestMethod.GET) //위도 경도 double값으로 받을수 있는지 체크
    public Object getMidLocAndPlace(@RequestParam String schName, @RequestParam String schAge, @RequestParam String schGender,
                                    @RequestParam String schPeople, @RequestParam String schType, @RequestParam String schPlaceCate,
                                  @RequestParam String latitude1, @RequestParam String latitude2, @RequestParam String latitude3,
                                  @RequestParam String longitude1, @RequestParam String longitude2, @RequestParam String longitude3,
                                  @RequestParam String userName1, @RequestParam String userName2, @RequestParam String userName3) {



        // 미터(Meter) 단위
        double distanceMeter =
                distance(37.504198, 127.047967, 37.501025, 127.037701, "meter");

        // 킬로미터(Kilo Meter) 단위
        double distanceKiloMeter =
                distance(37.504198, 127.047967, 37.501025, 127.037701, "kilometer");
        return null;
    }

   /*
    @RequestMapping(value="/getMidLocAndPlace2", method=RequestMethod.GET) //파라미터 Map으로 받을경우
    public List getMidLocAndPlace2(@RequestParam Map<String, Object> paramMap) { //위도 경도 double값으로 받을수 있는지 체크

        double distanceMile =
                distance(37.504198, 127.047967, 37.501025, 127.037701, "");

        // 미터(Meter) 단위
        double distanceMeter =
                distance(37.504198, 127.047967, 37.501025, 127.037701, "meter");

        // 킬로미터(Kilo Meter) 단위
        double distanceKiloMeter =
                distance(37.504198, 127.047967, 37.501025, 127.037701, "kilometer");

        return service.getMemberList();
    }
    */

    /**
     *
     *
     * @param lat1 지점 1 위도
     * @param lon1 지점 1 경도
     * @param lat2 지점 2 위도
     * @param lon2 지점 2 경도
     * @param unit 거리 표출단위
     * @return

    private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {

    double theta = lon1 - lon2;
    double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));

    dist = Math.acos(dist);
    dist = rad2deg(dist);
    dist = dist * 60 * 1.1515;

    if (unit == "kilometer") {
    dist = dist * 1.609344;
    } else if(unit == "meter"){
    dist = dist * 1609.344;
    }

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
     */

}