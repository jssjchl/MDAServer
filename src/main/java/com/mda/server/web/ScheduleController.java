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
    private ScheduleDto scheduleDto = new ScheduleDto();
    @Autowired
    ScheduleService scheduleService;
    LocInitSet locSet = new LocInitSet();


    @GetMapping("schedule")
    public List<Schedule> getAllSchedules() {
        return scheduleService.getScheduleList();
    }

    //ScheduleDetailFragment
    @GetMapping(value= "/schDetail/{schId}")
    public ScheduleDto schDetail (@PathVariable int schId){
        return scheduleService.schDetail(schId);
    }
    //locFin
    @GetMapping(value= "/locationFin/{schId}")
    public locFin locFin(@PathVariable int schId){
            return scheduleService.locFin(schId);
    }

    @GetMapping("/getSchedule/{userId}")
    public ScheduleList getSchedules(@PathVariable String userId){
        ScheduleList s = new ScheduleList();
        ArrayList<ScheduleDto> schArr = new ArrayList<>();
        List<Schedule> tempSchArr = new ArrayList<>();
        tempSchArr = scheduleService.getSchedules(userId);
        for(int i=0; i<tempSchArr.size(); i++){
            ScheduleDto sDto = new ScheduleDto();
            sDto.setSchid(tempSchArr.get(i).getScheduleId());
            sDto.setSchName(tempSchArr.get(i).getScheduleName());
            sDto.setSchPlaceId(tempSchArr.get(i).getSchedulePlaceId());
            sDto.setSchUserId(tempSchArr.get(i).getScheduleUserId());
            sDto.setSchUserName(tempSchArr.get(i).getScheduleUserName());
            sDto.setSchDate(tempSchArr.get(i).getScheduleDate());
            sDto.setSchTime(tempSchArr.get(i).getScheduleTime());
            sDto.setSchWithUserId(tempSchArr.get(i).getScheduleWithUserId());
            sDto.setSchWithUserName(tempSchArr.get(i).getScheduleWithUserName());
            sDto.setSchPlaceName(tempSchArr.get(i).getSchedulePlaceName());
            sDto.setSchPeopleNum(tempSchArr.get(i).getSchedulePeopleNum());
            sDto.setSchPlaceArea(tempSchArr.get(i).getSchedulePlaceArea());
            System.out.println("sDto : "+ sDto);
            schArr.add(sDto);
            System.out.println("schArr : "+ schArr);
        }
        s.setUserid(userId);
        s.setList(schArr);

        return s;
    }

    //CalendarFragment
    @GetMapping(value= "/getCalendarFragment")
    public schDT getCalendarFragment (HttpServletRequest request){
        return scheduleService.schDT(Integer.valueOf(request.getParameter("schID")));
    }




}
