package com.mda.server.web;

import com.mda.server.domain.schedule.Schedule;
import com.mda.server.service.schedule.ScheduleService;
import com.mda.server.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

    @GetMapping(value="/rdsTest")
    public  List<Schedule> name(){
        return scheduleService.getScheduleList();
    }


    /**
     * @Class Name : ScheduleController.java
     * @title : schDetail
     * @param : schId : @PathVariable
     * @returnType : ScheduleDto
     * @since 2021.  05
     * @dscription : schId 참조하여 Schedule 상세데이터를 리턴한다
     *
     * << 개정이력(Modification Information) >>
     *  수정일           수정자        수정내용
     * ---------------------------------------------------
     * 2021. 05.                    최초생성
     * 2021. 06. 01                 테스트완료
     */

    @GetMapping(value= "/schDetail/{schId}")
    public ScheduleDto schDetail (@PathVariable int schId){
        return scheduleService.schDetail(schId);
    }


    /**
     * @Class Name : ScheduleController.java
     * @title : locFin
     * @param : schId : @PathVariable
     * @returnType : locFin
     * @since 2021.  05
     * @dscription : schId 참조하여 Schedule 상세데이터를 리턴한다
     *
     * << 개정이력(Modification Information) >>
     *  수정일           수정자        수정내용
     * ---------------------------------------------------
     * 2021. 05.                    최초생성
     * 2021. 06. 01                 테스트완료
     */


    @GetMapping(value= "/locationFin/{schId}")
    public locFin locFin(@PathVariable int schId){
            return scheduleService.locFin(schId);
    }


    /**
     * @Class Name : ScheduleController.java
     * @title : getSchedules
     * @param : userId : @PathVariable
     * @returnType : ScheduleList
     * @since 2021.  05
     * @dscription : userId 참조하여 해당 user의 Schedule목록을 return한다
     *
     * << 개정이력(Modification Information) >>
     *  수정일           수정자        수정내용
     * ---------------------------------------------------
     * 2021. 05.                    최초생성
     * 2021. 06. 01                 테스트완료
     */

    @GetMapping("/getSchedule/{userId}")
    public ScheduleList getSchedules(@PathVariable String userId) {
        ScheduleList s = new ScheduleList();
        ArrayList<ScheduleDto> schArr = new ArrayList<>();
        List<Schedule> tempSchArr = new ArrayList<>();
        tempSchArr = scheduleService.getSchedules(userId);
        for (int i = 0; i < tempSchArr.size(); i++) {
            ScheduleDto sDto = new ScheduleDto();
            sDto.setScheduleId(tempSchArr.get(i).getScheduleId());
            sDto.setScheduleName(tempSchArr.get(i).getScheduleName());
            sDto.setSchedulePlaceId(tempSchArr.get(i).getSchedulePlaceId());
            sDto.setScheduleUserId(tempSchArr.get(i).getScheduleUserId());
            sDto.setScheduleUserName(tempSchArr.get(i).getScheduleUserName());
            sDto.setScheduleDate(tempSchArr.get(i).getScheduleDate());
            sDto.setScheduleTime(tempSchArr.get(i).getScheduleTime());
            sDto.setScheduleWithUserId(tempSchArr.get(i).getScheduleWithUserId());
            sDto.setScheduleWithUserName(tempSchArr.get(i).getScheduleWithUserName());
            sDto.setSchedulePlaceName(tempSchArr.get(i).getSchedulePlaceName());
            sDto.setSchedulePeopleNum(tempSchArr.get(i).getSchedulePeopleNum());
            sDto.setSchedulePlaceArea(tempSchArr.get(i).getSchedulePlaceArea());
            schArr.add(sDto);
            schArr.add(sDto);
        }
        s.setUserid(Integer.parseInt(userId));
        s.setList(schArr);

        return s;
    }


    /**
     * @Class Name : ScheduleController.java
     * @title : getCalendarFragment
     * @param : schId : @PathVariable
     * @returnType : schDT
     * @since 2021.  05
     * @dscription : schId 참조하여 데이터 조회후 schDT타입으로 return한다.
     *
     * << 개정이력(Modification Information) >>
     *  수정일           수정자        수정내용
     * ---------------------------------------------------
     * 2021. 05.                    최초생성
     * 2021. 06. 01                 테스트완료
     */

    @GetMapping(value= "/CalendarFragment/{schId}")
    public schDT getCalendarFragment (@PathVariable int schId){
        return scheduleService.schDT(schId);
    }

}
