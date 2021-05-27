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
    @GetMapping(value= "/getScheduleDetailFragment")
    public ScheduleDetailFragmentDto getScheduleDetailFragment (HttpServletRequest request){
        return scheduleService.ScheduleDetailFragment(Integer.valueOf(request.getParameter("scheduleId")));
    }
    //locFin
    @GetMapping(value= "/locationFin/{schId}")
    public locFin locFin(@PathVariable int schId){
            return scheduleService.locFin(schId);
    }

    @GetMapping("/getSchedule/{userId}")
    public ScheduleList getSchedules(@PathVariable int userId){
        ScheduleList s = new ScheduleList();
        ArrayList<ScheduleDto> schArr = new ArrayList<>();
        ArrayList<Schedule> tempSchArr = new ArrayList<>();
        tempSchArr = scheduleService.getSchedules(userId);
        for(int i=0; i<tempSchArr.size(); i++){
            ScheduleDto sDto = new ScheduleDto();
            sDto.setScheduleId(tempSchArr.get(i).getScheduleId());
            sDto.setScheduleName(tempSchArr.get(i).getScheduleName());
            schArr.add(sDto);
        }
        s.setUserid(userId);
        s.setList(schArr);

        return s;
    }

    //CalendarFragment
    @GetMapping(value= "/getCalendarFragment")
    public CalendarFragmentDto getCalendarFragment (HttpServletRequest request){
        return scheduleService.CalendarFragment(Integer.valueOf(request.getParameter("scheduleId")));
    }

    //ScheduleTimeDate
    /*
    SchDto td=new SchDto();
    @PostMapping(value = "/schDT")
    public SchDto getschDT(HttpServletRequest request){
        td.setScheduleDate(request.getParameter("scheduleDate"));
        td.setScheduleTime(request.getParameter("scheduleTime"));
        return td;
    }



    @GetMapping(value = "/showSchDT")
    public SchDto ShowSchDT(){
        return td;
    }
    */
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
