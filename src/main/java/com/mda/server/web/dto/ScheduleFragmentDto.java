package com.mda.server.web.dto;

import com.mda.server.domain.schedule.Schedule;
import lombok.Getter;

@Getter
public class ScheduleFragmentDto {
    private Integer scheduleId;
    private String scheduleName;
    private String schedulePlaceName;

    public ScheduleFragmentDto(Schedule entity) {
        this.scheduleId=entity.getScheduleId();
        this.schedulePlaceName=entity.getSchedulePlaceName();
        this.scheduleName=entity.getScheduleName();
    }

}
