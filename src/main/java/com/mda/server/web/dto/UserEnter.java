package com.mda.server.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserEnter {


    private String userId;
    private double userLatitude;
    private double userLongtitude;

    @Builder
    public UserEnter(String userId, double userLatitude, double userLongtitude) {
        this.userId = userId;
        this.userLatitude = userLatitude;
        this.userLongtitude = userLongtitude;
    }

    public UserEnter toEntity(){
        return UserEnter.builder()
                .userId(userId)
                .userLatitude(userLatitude)
                .userLongtitude(userLongtitude)
                .build();
    }



}
