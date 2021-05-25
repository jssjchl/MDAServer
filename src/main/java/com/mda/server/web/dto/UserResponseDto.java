package com.mda.server.web.dto;

import com.mda.server.domain.user.User;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private String userId;
    private Integer userAge;
    private String userGender;
    private String userName;
    private String userPwd;


    public UserResponseDto(User entity) {
        this.userId = entity.getUserId();
        this.userAge = entity.getUserAge();
        this.userGender = entity.getUserGender();
        this.userName = entity.getUserName();
        this.userPwd = entity.getUserPwd();
    }

}


