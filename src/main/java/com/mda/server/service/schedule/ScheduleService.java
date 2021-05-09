package com.mda.server.service.schedule;

import com.mda.server.domain.schedule.Schedule;
import com.mda.server.domain.schedule.ScheduleRepository;
import com.mda.server.domain.user.User;
import com.mda.server.web.dto.ScheduleDto;
import com.mda.server.web.dto.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    public List<Schedule> getScheduleList(){
        return (List<Schedule>) scheduleRepository.findAll();
    }

    @Transactional
    public Schedule save(ScheduleDto schedule){

        return scheduleRepository.save(schedule.toEntity());
    }
}