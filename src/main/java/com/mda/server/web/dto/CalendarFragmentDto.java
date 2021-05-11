package com.mda.server.web.dto;

import com.mda.server.domain.schedule.Schedule;
import lombok.Getter;

@Getter
public class CalendarFragmentDto {
    private Integer scheduleId;
    private String scheduleDate;
    private String scheduleTime;

    public CalendarFragmentDto(Schedule entity) {
        this.scheduleId=entity.getScheduleId();
        this.scheduleDate=entity.getScheduleDate();
        this.scheduleTime=entity.getScheduleTime();
    }
}
