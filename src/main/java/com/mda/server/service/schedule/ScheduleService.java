package com.mda.server.service.schedule;

import com.mda.server.domain.place.Place;
import com.mda.server.domain.schedule.Schedule;
import com.mda.server.domain.schedule.ScheduleRepository;
import com.mda.server.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    public List<Schedule> getScheduleList(){
        return (List<Schedule>) scheduleRepository.findAll();
    }

    public CalendarFragmentDto CalendarFragment(Integer id) {
        Schedule entity = scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("이게뭐냐"));
        return new CalendarFragmentDto(entity);
    }

    public ScheduleFragmentDto ScheduleFragment(Integer id) {
        Schedule entity = scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("이게뭐냐"));
        return new ScheduleFragmentDto(entity);
    }

    public ScheduleDetailFragmentDto ScheduleDetailFragment(Integer id) {
        Schedule entity = scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("이게뭐냐"));
        return new ScheduleDetailFragmentDto(entity);
    }

    public LocationFinishFragment LocationFinishFragment(Integer id) {
        Schedule entity = scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("이게뭐냐"));
        return new LocationFinishFragment(entity);
    }

    @Transactional
    public Schedule saveLocationSetting(ScheduleDto schedule) {
        return scheduleRepository.save(schedule.toEntity());
    }

}