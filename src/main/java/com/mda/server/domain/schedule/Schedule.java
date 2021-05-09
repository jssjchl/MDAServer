package com.mda.server.domain.schedule;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto Increment
    @Column(nullable = false)
    private Integer scheduleId;

    //new
    @Column(nullable = false)
    private String age;

    @Column
    private String gender;

    @Column
    private Integer count;

    @Column
    private String mood;
    //

    @Column
    private String scheduleName;

    @Column
    private String schedulePlaceName;

    @Column
    private String schedulePlaceId;

    @Column
    private String scheduleUserId;

    @Column
    private String scheduleUserName;

    @Column
    private String scheduleDate;

    @Column
    private String scheduleTime;

    //여러개인 것들은 한꺼번에 묶어서 데이터화
    @Column
    private String scheduleWithUserId;

    @Column
    private String scheduleWithUserName;

    @Builder
    public Schedule(int scheduleId, String age, String scheduleDate, String scheduleName,
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
}
