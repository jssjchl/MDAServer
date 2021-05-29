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
    private String scheduleName;
    private String schedulePlaceId;
    private String scheduleUserId;
    private String scheduleUserName;
    private String scheduleDate;
    private String scheduleTime;
    private String scheduleWithUserId;
    private String scheduleWithUserName;
    private String schedulePlaceName;
    private String schedulePeopleNum;
    private String schedulePlaceArea;

    public ScheduleDto(Schedule entity) {
        this.scheduleDate = entity.getScheduleDate();
        this.schedulePlaceName = entity.getSchedulePlaceName();
        this.scheduleName = entity.getScheduleName();
        this.scheduleTime = entity.getScheduleTime();
        this.scheduleWithUserName = entity.getScheduleWithUserName();
        this.schedulePlaceArea=entity.getSchedulePlaceArea();
    }

    @Builder
    public ScheduleDto(Integer schid, String scheduleDate, String scheduleName,
                       String schedulePlaceId, String scheduleUserId,
                       String scheduleUserName, String scheduleTime,
                       String scheduleWithUserId, String scheduleWithUserName, String schedulePlaceName,
                       String schedulePeopleNum, String schedulePlaceArea
                       ){
        this.scheduleDate = scheduleDate;
        this.schid = schid;
        this.schedulePlaceName = schedulePlaceName;
        this.scheduleName = scheduleName;
        this.schedulePlaceId = schedulePlaceId;
        this.scheduleUserName = scheduleUserName;
        this.scheduleTime = scheduleTime;
        this.scheduleUserId = scheduleUserId;
        this.scheduleWithUserId = scheduleWithUserId;
        this.scheduleWithUserName = scheduleWithUserName;
        this.schedulePeopleNum=schedulePeopleNum;
        this.schedulePlaceArea=schedulePlaceArea;
    }

    public Schedule toEntity(){
        return Schedule.builder()
                .scheduleDate(scheduleDate)
                .scheduleId(schid)
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
