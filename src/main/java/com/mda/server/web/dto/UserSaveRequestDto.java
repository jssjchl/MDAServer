package com.mda.server.web.dto;

import com.mda.server.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserSaveRequestDto {
    private String userId;
    private Integer userAge;
    private String userGender;
    private String userName;
    private String userPwd;



    @Builder
    public UserSaveRequestDto(String userId, Integer userAge, String userGender, String userName, String userPwd){
        this.userId = userId;
        this.userAge = userAge;
        this.userName = userName;
        this.userGender = userGender;
        this.userPwd = userPwd;
    }

    public User toEntity(){
        return User.builder()
                .userAge(userAge)
                .userId(userId)
                .userGender(userGender)
                .userName(userName)
                .userPwd(userPwd)
                .build();
    }

}
