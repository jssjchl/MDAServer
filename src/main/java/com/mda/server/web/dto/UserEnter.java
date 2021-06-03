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
    private double userLongitude;

    @Builder
    public UserEnter(String userId, double userLatitude, double userLongitude) {
        this.userId = userId;
        this.userLatitude = userLatitude;
        this.userLongitude = userLongitude;
    }

    public UserEnter toEntity(){
        return UserEnter.builder()
                .userId(userId)
                .userLatitude(userLatitude)
                .userLongitude(userLongitude)
                .build();
    }



}
