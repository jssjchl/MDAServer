package com.mda.server.web;

import com.mda.server.domain.schedule.Schedule;
import com.mda.server.service.schedule.ScheduleService;
import com.mda.server.web.dto.CalendarFragmentDto;
import com.mda.server.web.dto.ScheduleDetailFragmentDto;
import com.mda.server.web.dto.ScheduleDto;
import com.mda.server.web.dto.ScheduleFragmentDto;
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

    @GetMapping("schedule/selectList")
    public List<Schedule> getAllSchedules(){
        return scheduleService.getScheduleList();
    }

    @GetMapping("/getCalendarFragment/{id}")
    public CalendarFragmentDto getCalendarFragment(@PathVariable Integer id){
        return scheduleService.CalendarFragment(id);
    }
    @GetMapping("/getScheduleFragment/{id}")
    public ScheduleFragmentDto getScheduleFragment(@PathVariable Integer id){
        return scheduleService.ScheduleFragment(id);
    }
    @GetMapping("/getScheduleDetailFragment/{id}")
    public ScheduleDetailFragmentDto getScheduleDetailFragment(@PathVariable Integer id){
        return scheduleService.ScheduleDetailFragment(id);
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
