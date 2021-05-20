package com.mda.server.web.dto;

import com.mda.server.domain.schedule.Schedule;
import lombok.Getter;

@Getter
public class ScheduleFragmentDto {
    private Integer scheduleId;
    private String scheduleName;
    private String scheduleArea;
    private String schedulePeopleNum;

    public ScheduleFragmentDto(Schedule entity) {
        this.scheduleId=entity.getScheduleId();
        this.scheduleArea=entity.getSchedulePlaceArea();
        this.scheduleName=entity.getScheduleName();
        this.schedulePeopleNum=entity.getSchedulePeopleNum();
    }

}
