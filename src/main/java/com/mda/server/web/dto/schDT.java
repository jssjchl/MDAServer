package com.mda.server.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class schDT {
    private int placeId;
    private String scheduleTime;
    private String scheduleDate;

    public schDT(){
        this.scheduleDate=getScheduleTime();
        this.scheduleTime=getScheduleTime();
        this.placeId=getPlaceId();
    }
}
