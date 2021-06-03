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
    private Integer scheduleId;
    private String scheduleName;
    private String schedulePlaceName;
    private String schedulePlaceId;
    private String scheduleUserId;
    private String scheduleUserName;
    private String scheduleDate;
    private String scheduleTime;
    private String schedulePlaceArea;
    private String schedulePeopleNum;
    private String scheduleWithUserId;
    private String scheduleWithUserName;

    public ScheduleDto(Schedule entity) {
        this.scheduleDate = entity.getScheduleDate();
        this.schedulePlaceName = entity.getSchedulePlaceName();
        this.scheduleName = entity.getScheduleName();
        this.scheduleTime = entity.getScheduleTime();
        this.scheduleWithUserName = entity.getScheduleWithUserName();
        this.schedulePlaceArea=entity.getSchedulePlaceArea();
    }

    @Builder
    public ScheduleDto(Integer schid, String schDate, String schName,
                       String schPlaceId, String schUserId,
                       String schUserName, String schTime,
                       String schWithUserId, String schWithUserName, String schPlaceName,
                       String schPeopleNum, String schPlaceArea
    ){
        this.scheduleDate = schDate;
        this.scheduleId = schid;
        this.schedulePlaceName = schPlaceName;
        this.scheduleName = schName;
        this.schedulePlaceId = schPlaceId;
        this.scheduleUserName = schUserName;
        this.scheduleTime = schTime;
        this.scheduleUserId = schUserId;
        this.scheduleWithUserId = schWithUserId;
        this.scheduleWithUserName = schWithUserName;
        this.schedulePeopleNum=schPeopleNum;
        this.schedulePlaceArea=schPlaceArea;
    }

    public Schedule toEntity(){
        return Schedule.builder()
                .scheduleDate(scheduleDate)
                .scheduleId(scheduleId)
                .scheduleName(scheduleName)
                .scheduleTime(scheduleTime)
                .schedulePlaceId(schedulePlaceId)
                .scheduleWithUserId(scheduleWithUserId)
                .scheduleWithUserName(scheduleWithUserName)
                .scheduleUserId(scheduleUserId)
                .scheduleUserName(scheduleUserName)
                .schedulePeopleNum(schedulePeopleNum)
                .schedulePlaceName(schedulePlaceName)
                .schedulePlaceArea(schedulePlaceArea)
                .build();
    }
}
