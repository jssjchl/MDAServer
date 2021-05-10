package com.mda.server.domain.place;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="place")
@Getter
@NoArgsConstructor

public class Place {
    @Id
    @Column(name="PLACE_ID", nullable = false)
    private Integer placeId;

    @Column(name="PLACE_TYPE", nullable = false)
    private String placeType;

    @Column(name="PLACE_NAME", nullable = false)
    private String placeName;

    @Column(name="PLACE_AREA", nullable = false)
    private String placeArea;

    @Column(name="PLACE_DESCRIPTION", nullable = false)
    private String placeDescription;

    @Column(name="PLACE_IMG_URL", nullable = false)
    private String placeImgUrl;

    @Column(name="PLACE_CATEGORY",nullable = false)
    private String placeCategory;



    @Builder
    public Place(Integer placeId, String placeType, String placeName, String placeArea, String placeDescription,
                 String placeImgUrl, String placeCategory ){
        this.placeId=placeId;
        this.placeType=placeType;
        this.placeName=placeName;
        this.placeArea=placeArea;
        this.placeDescription=placeDescription;
        this.placeImgUrl=placeImgUrl;
        this.placeCategory=placeCategory;


    }
}
