package com.mda.server.web.dto;

import com.mda.server.domain.schedule.Schedule;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationFinalSelectFragmentDto {

    private String scheduleDate;
    private String scheduleTime;
    private String schedulePlaceName;

    public LocationFinalSelectFragmentDto(){
        this.scheduleDate=getScheduleDate();
        this.scheduleTime=getScheduleTime();
        this.schedulePlaceName=getSchedulePlaceName();

    }

}
