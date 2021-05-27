package com.mda.server.web.dto;

import com.mda.server.domain.place.Place;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceResponseDto {
    private Integer placeId;
    private String placeType;
    private String placeName;
    private String placeArea;
    private String placeImgUrl;
    private String placeCate;

    public PlaceResponseDto(Place entity){
        this.placeId = entity.getPlaceId();
        this.placeType =entity.getPlaceType();
        this.placeName =entity.getPlaceName();
        this.placeArea =entity.getPlaceArea();
        this.placeImgUrl = entity.getPlaceImgUrl();
        this.placeCate =entity.getPlaceCategory();
    }


}