package com.mda.server.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class userEnter {
    private String userId;
    private String userLatitude;
    private String userLongitude;
}
