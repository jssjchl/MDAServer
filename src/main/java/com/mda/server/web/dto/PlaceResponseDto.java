package com.mda.server.web.dto;

import com.mda.server.domain.place.Place;
import lombok.Getter;

@Getter
public class PlaceResponseDto {
    private Integer placeId;
    private String placeType;
    private String placeName;
    private String placeArea;
    private String placeDescription;
    private String placeImgUrl;
    private String placeCategory;

    public PlaceResponseDto(Place entity){
        this.placeId = entity.getPlaceId();
        this.placeType = entity.getPlaceType();
        this.placeName = entity.getPlaceName();
        this.placeArea = entity.getPlaceArea();
        this.placeDescription = entity.getPlaceDescription();
        this.placeImgUrl = entity.getPlaceImgUrl();
        this.placeCategory = entity.getPlaceCategory();
    }
}
