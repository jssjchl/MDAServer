package com.mda.server.web.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class ScheduleList {
    private int userid;
    private ArrayList<ScheduleDto> list;
}