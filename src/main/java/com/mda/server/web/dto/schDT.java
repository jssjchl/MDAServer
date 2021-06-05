package com.mda.server.web.dto;

import com.mda.server.domain.schedule.Schedule;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class schDT {
    private String placeId;
    private String schTime;
    private String schDate;

    public schDT(){
        this.schDate=getSchDate();
        this.schTime=getSchTime();
        this.placeId=getPlaceId();
    }

    public schDT(Schedule entity) {
    }
}
