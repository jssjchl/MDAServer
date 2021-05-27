package com.mda.server.web.dto;

import com.mda.server.domain.schedule.Schedule;
import lombok.Getter;

@Getter
public class locFin {

    private Integer schId;
    private String schName;
    private String schPlaceName;
    private String schPlaceArea;
    private String schWIthUserName;

    public locFin(Schedule entity){
        this.schId=entity.getScheduleId();
        this.schName=entity.getScheduleName();
        this.schPlaceName=entity.getSchedulePlaceArea();
        this.schPlaceArea=entity.getSchedulePlaceName();
        this.schWIthUserName=entity.getScheduleWithUserName();
    }

}
