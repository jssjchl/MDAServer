package com.mda.server.web.dto;

import com.mda.server.domain.schedule.Schedule;
import lombok.Getter;

@Getter
public class ScheduleDetailFragmentDto {
    private Integer scheduleId;
    private String scheduleName;
    private String schedulePlaceName;
    private String scheduleDate;
    private String scheduleTime;
    private String schedulePlaceArea;
    private String scheduleWithUserName;

    public ScheduleDetailFragmentDto(Schedule entity){
        this.scheduleId=entity.getScheduleId();
        this.scheduleDate=entity.getScheduleDate();
        this.scheduleName=entity.getScheduleName();
        this.scheduleTime=entity.getScheduleTime();
        this.schedulePlaceName=entity.getSchedulePlaceName();
        this.schedulePlaceArea=entity.getSchedulePlaceArea();
        this.scheduleWithUserName=entity.getScheduleWithUserName();
    }
}
