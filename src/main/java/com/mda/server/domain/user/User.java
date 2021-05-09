package com.mda.server.domain.user;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id
    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private Integer userAge;

    @Column(nullable = false)
    private String userGender;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userPwd;

    @Builder
    public User(String userId, Integer userAge, String userGender, String userName, String userPwd){
        this.userId = userId;
        this.userAge = userAge;
        this.userName = userName;
        this.userGender = userGender;
        this.userPwd = userPwd;
    }
}
