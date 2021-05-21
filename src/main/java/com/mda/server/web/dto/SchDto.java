package com.mda.server.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SchDto {

    private String scheduleTime;
    private String scheduleDate;

    public SchDto(){
        this.scheduleDate=getScheduleTime();
        this.scheduleTime=getScheduleTime();
    }
}
