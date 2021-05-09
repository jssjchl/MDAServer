package com.mda.server.web;

import com.mda.server.domain.schedule.Schedule;
import com.mda.server.service.schedule.ScheduleService;
import com.mda.server.web.dto.ScheduleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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

    @PostMapping("/startSession")
    public Schedule startSchedule(HttpServletRequest request){
        scheduleDto.setScheduleName(request.getParameter("name"));
        scheduleDto.setAge(request.getParameter("age"));
        return scheduleService.save(scheduleDto);
    }

    @GetMapping("/startSession")
    public ScheduleDto getSchedule(){
        return scheduleDto;
    }
}
