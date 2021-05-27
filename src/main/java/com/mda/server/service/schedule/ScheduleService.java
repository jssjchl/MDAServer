package com.mda.server.service.schedule;

import com.mda.server.domain.schedule.QSchedule;
import com.mda.server.domain.schedule.Schedule;
import com.mda.server.domain.schedule.ScheduleRepository;
import com.mda.server.web.dto.*;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service("scheduleService")
public class ScheduleService extends QuerydslRepositorySupport {

    public ScheduleService() {
        super(Schedule.class);
    }

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

    public locFin locFin(Integer id) {
        Schedule entity = scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("이게뭐냐"));
        return new locFin(entity);
    }

    public List<Schedule> getSchedules(String userId){
        QSchedule schedule = QSchedule.schedule;
        List<Schedule> schList = new ArrayList<>();
        //schList.addAll(from(schedule).where(schedule.scheduleUserId.eq(userId)).fetch()); //이거..조건을 넣으면 조회가안된다 알아보기
        schList.addAll(from(schedule).fetch());
        return schList;
    }

    @Transactional
    public Schedule saveLocationSetting(ScheduleDto schedule) {
        return scheduleRepository.save(schedule.toEntity());
    }

}