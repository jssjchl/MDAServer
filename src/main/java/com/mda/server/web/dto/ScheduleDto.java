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
    private int scheduleId;
    private String age;
    private String mood;
    private String gender;
    private String scheduleName;
    private String schedulePlaceId;
    private String scheduleUserId;
    private String scheduleUserName;
    private String scheduleDate;
    private String scheduleTime;
    private String scheduleWithUserId;
    private String scheduleWithUserName;

    @Builder
    public ScheduleDto(int scheduleId,String age, String scheduleDate, String scheduleName,
                       String schedulePlaceId, String scheduleUserId,
                       String scheduleUserName, String scheduleTime,
                       String scheduleWithUserId, String scheduleWithUserName
                       ){
        this.age = age;
        this.scheduleDate = scheduleDate;
        this.scheduleId = scheduleId;
        this.scheduleName = scheduleName;
        this.schedulePlaceId = schedulePlaceId;
        this.scheduleUserName = scheduleUserName;
        this.scheduleUserId = scheduleUserId;
        this.scheduleWithUserId = scheduleWithUserId;
        this.scheduleWithUserName = scheduleWithUserName;
    }

    public Schedule toEntity(){
        return Schedule.builder()
                .age(age)
                .scheduleDate(scheduleDate)
                .scheduleId(scheduleId)
                .scheduleName(scheduleName)
                .scheduleTime(scheduleTime)
                .schedulePlaceId(schedulePlaceId)
                .scheduleWithUserId(scheduleWithUserId)
                .scheduleWithUserName(scheduleWithUserName)
                .scheduleUserId(scheduleUserId)
                .build();
    }
}
