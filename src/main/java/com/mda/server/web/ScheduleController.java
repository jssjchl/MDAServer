package com.mda.server.web;

import com.mda.server.domain.schedule.Schedule;
import com.mda.server.service.schedule.ScheduleService;
import com.mda.server.web.dto.CalendarFragmentDto;
import com.mda.server.web.dto.ScheduleDetailFragmentDto;
import com.mda.server.web.dto.ScheduleDto;
import com.mda.server.web.dto.ScheduleFragmentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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



}
