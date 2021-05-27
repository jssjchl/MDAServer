package com.mda.server.web.dto;

import com.mda.server.domain.schedule.Schedule;
import lombok.Getter;

@Getter
public class CalendarFragmentDto {
    private Integer schID;
    private String schDate;
    private String schTime;

    public CalendarFragmentDto(Schedule entity) {
        this.schID=entity.getScheduleId();
        this.schDate=entity.getScheduleDate();
        this.schTime=entity.getScheduleTime();
    }
}
