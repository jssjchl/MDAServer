package com.mda.server.domain.schedule;

import lombok.*;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;

@Entity
@Table(name = "schedule")
@Getter
@NoArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto Increment
    @Column(name = "SCHEDULE_ID", nullable = false)
    private Integer scheduleId;

    @Column(name = "SCHEDULE_NAME", nullable = false)
    private String scheduleName;

    @Column(name = "SCHEDULE_PLACE_NAME", nullable = false)
    private String schedulePlaceName;

    @Column(name = "SCHEDULE_PLACE_ID", nullable = false)
    private String schedulePlaceId;

    @Column(name = "SCHEDULE_USER_ID", nullable = false)
    private String scheduleUserId;

    @Column(name = "SCHEDULE_USER_NAME", nullable = false)
    private String scheduleUserName;

    @Column(name = "SCHEDULE_DATE", nullable = false)
    private String scheduleDate;

    @Column(name = "SCHEDULE_TIME", nullable = false)
    private String scheduleTime;

    @Column(name = "SCHEDULE_PLACE_AREA", nullable = false)
    private String schedulePlaceArea;

    @Column(name = "SCHEDULE_PEOPLE_NUM", nullable = false)
    private String schedulePeopleNum;

    @Column(name = "SCHEDULE_WITH_USER_ID", nullable = false)
    private String scheduleWithUserId;

    @Column(name = "SCHEDULE_WITH_USER_NAME", nullable = false)
    private String scheduleWithUserName;

    @Builder
    public Schedule(Integer scheduleId, String schedulePlaceName, String scheduleDate, String scheduleName,
                    String schedulePlaceId, String scheduleUserId,
                    String scheduleUserName, String scheduleTime,
                    String scheduleWithUserId, String scheduleWithUserName, String schedulePeopleNum,
                    String schedulePlaceArea

    ) {
        this.scheduleDate = scheduleDate;
        this.scheduleId = scheduleId;
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
}
