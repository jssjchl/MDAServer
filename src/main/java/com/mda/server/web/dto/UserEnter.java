package com.mda.server.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserEnter {
    /*
    private String userId1;
    private String userId2;
    private String userId3;
    private String userLatitude1;
    private String userLatitude2;
    private String userLatitude3;
    private String userLongitude1;
    private String userLongitude2;
    private String userLongitude3;
    */

    private String userId;
    private String userLatitude;
    private String userLongtitude;

    @Builder
    public UserEnter(String userId, String userLatitude, String userLongtitude) {
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
