package com.mda.server.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SchDt {

    private String scheduleTime;
    private String scheduleDate;

    public SchDt(){
        this.scheduleDate=getScheduleTime();
        this.scheduleTime=getScheduleTime();
    }
}
