package com.mda.server.domain.user;

import lombok.*;
import javax.persistence.*;


@Entity
@Table(name="user")

@NoArgsConstructor
public class User {
    @Id
    @Column(name="USER_ID",nullable = false)
    private int userId;

    @Column(name="USER_AGE",nullable = false)
    private Integer userAge;

    @Column(name="USER_GENDER",nullable = false)
    private String userGender;

    @Column(name="USER_NAME",nullable = false)
    private String userName;

    @Column(name="USER_PWD",nullable = false)
    private String userPwd;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }



    @Builder
    public User(int userId, Integer userAge, String userGender, String userName, String userPwd){
        this.userId = userId;
        this.userAge = userAge;
        this.userName = userName;
        this.userGender = userGender;
        this.userPwd = userPwd;
    }
}
