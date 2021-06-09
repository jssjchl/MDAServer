package com.mda.server.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocInitSet {
    String schName;
    String schAge;
    String schGender;
    String schPeople;
    String schType;
    String schPlaceCate;

    @Override
    public String toString() {
        return "LocInitSet{" +
                "schName='" + schName + '\'' +
                ", schAge='" + schAge + '\'' +
                ", schGender='" + schGender + '\'' +
                ", schPeople='" + schPeople + '\'' +
                ", schType='" + schType + '\'' +
                ", schPlaceCate='" + schPlaceCate + '\'' +
                '}';
    }
}