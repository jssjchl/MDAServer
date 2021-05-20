package com.mda.server.web.dto;

import com.mda.server.domain.schedule.Schedule;
import lombok.Getter;

@Getter
public class LocationFinishFragment {

    private Integer scheduleId;
    private String scheduleName;
    private String schedulePlaceName;
    private String scheduleWithUserName;

    public LocationFinishFragment(Schedule entity){
        this.scheduleId=getScheduleId();
        this.scheduleName=getScheduleName();
        this.schedulePlaceName=getSchedulePlaceName();
        this.scheduleWithUserName=getScheduleWithUserName();
    }

}
