package com.mda.server.web;

import com.mda.server.domain.schedule.Schedule;
import com.mda.server.service.schedule.ScheduleService;
import com.mda.server.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private ScheduleDto scheduleDto = new ScheduleDto();
    @Autowired
    ScheduleService scheduleService;

    @GetMapping("schedule")
    public List<Schedule> getAllSchedules() {
        return scheduleService.getScheduleList();
    }

    //ScheduleFragment
    @GetMapping(value= "/getScheduleFragment")
    public ScheduleFragmentDto getScheduleFragment (HttpServletRequest request){
        return scheduleService.ScheduleFragment(Integer.valueOf(request.getParameter("scheduleId")));
    }
    //ScheduleDetailFragment
    @GetMapping(value= "/getScheduleDetailFragment")
    public ScheduleDetailFragmentDto getScheduleDetailFragment (HttpServletRequest request){
        return scheduleService.ScheduleDetailFragment(Integer.valueOf(request.getParameter("scheduleId")));
    }
    //LocationFinishFragment
    @GetMapping(value= "/getLocationFinishFragment")
    public LocationFinishFragment getLocationFinishFragment (HttpServletRequest request){
        return scheduleService.LocationFinishFragment(Integer.valueOf(request.getParameter("scheduleId")));
    }
    //CalendarFragment
    @GetMapping(value= "/getCalendarFragment")
    public CalendarFragmentDto getCalendarFragment (HttpServletRequest request){
        return scheduleService.CalendarFragment(Integer.valueOf(request.getParameter("scheduleId")));
    }


    /*
    @RequestMapping(value="/saveLocationSetting")
    public String saveLocationSetting(@RequestParam Map<String, Object> paramMap, HttpServletRequest request) {
        String result = "";
        try {
            scheduleService.saveLocationSetting(paramMap);
            result = "success";
        } catch (IndexOutOfBoundsException e) {
            result = "fail";
        } catch (Exception e) {
            result = "fail";
        }

        return result;
    }

*/


}
