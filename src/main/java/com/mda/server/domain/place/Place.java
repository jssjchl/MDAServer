package com.mda.server.domain.place;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer placeId;

    @Column(nullable = false)
    private String placeArea;

    @Column(nullable = false)
    private String placeDescription;

    @Column(nullable = false)
    private String placeImg_Url;

    @Column(nullable = false)
    private String placeName;

    @Column(nullable = false)
    private String placeType;

    @Builder
    public Place(int placeId, String placeArea, String placeDescription,
                 String placeImg_Url, String placeName, String placeType){

        this.placeId=placeId;
        this.placeArea=placeArea;
        this.placeDescription=placeDescription;
        this.placeImg_Url=placeImg_Url;
        this.placeName=placeName;
        this.placeType=placeType;
    }
}
