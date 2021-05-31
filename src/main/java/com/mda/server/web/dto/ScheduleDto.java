package com.mda.server.web.dto;

import com.mda.server.domain.schedule.Schedule;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ScheduleDto {
    private Integer schid;
    private String schName;
    private String schPlaceId;
    private String schUserId;
    private String schUserName;
    private String schDate;
    private String schTime;
    private String schWithUserId;
    private String schWithUserName;
    private String schPlaceName;
    private String schPeopleNum;
    private String schPlaceArea;

    public ScheduleDto(Schedule entity) {
        this.schDate = entity.getScheduleDate();
        this.schPlaceName = entity.getSchedulePlaceName();
        this.schName = entity.getScheduleName();
        this.schTime = entity.getScheduleTime();
        this.schWithUserName = entity.getScheduleWithUserName();
        this.schPlaceArea=entity.getSchedulePlaceArea();
    }

    @Builder
    public ScheduleDto(Integer schid, String schDate, String schName,
                       String schPlaceId, String schUserId,
                       String schUserName, String schTime,
                       String schWithUserId, String schWithUserName, String schPlaceName,
                       String schPeopleNum, String schPlaceArea
    ){
        this.schDate = schDate;
        this.schid = schid;
        this.schPlaceName = schPlaceName;
        this.schName = schName;
        this.schPlaceId = schPlaceId;
        this.schUserName = schUserName;
        this.schTime = schTime;
        this.schUserId = schUserId;
        this.schWithUserId = schWithUserId;
        this.schWithUserName = schWithUserName;
        this.schPeopleNum=schPeopleNum;
        this.schPlaceArea=schPlaceArea;
    }

    public Schedule toEntity(){
        return Schedule.builder()
                .scheduleDate(schDate)
                .scheduleId(schid)
                .scheduleName(schName)
                .scheduleTime(schTime)
                .schedulePlaceId(schPlaceId)
                .scheduleWithUserId(schWithUserId)
                .scheduleWithUserName(schWithUserName)
                .scheduleUserId(schUserId)
                .scheduleUserName(schUserName)
                .schedulePeopleNum(schPeopleNum)
                .schedulePlaceName(schPlaceName)
                .schedulePlaceArea(schPlaceArea)
                .build();
    }
}
