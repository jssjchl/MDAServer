package com.mda.server.domain.schedule;

import com.mda.server.web.dto.ScheduleDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    List<Schedule> findByScheduleUserId(String id);

}
