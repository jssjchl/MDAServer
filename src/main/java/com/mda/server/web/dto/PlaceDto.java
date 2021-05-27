package com.mda.server.web.dto;

import com.mda.server.domain.place.Place;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PlaceDto {
    private Integer placeId;
    private String placeType;
    private String placeName;
    private String placeArea;
    private String placeDescription;
    private String placeImgUrl;
    private String placeCategory;

    @Builder
    public PlaceDto(Place entity) {

        this.placeId = entity.getPlaceId();
        this.placeType = entity.getPlaceType();
        this.placeName = entity.getPlaceName();
        this.placeArea = entity.getPlaceArea();
        this.placeDescription = entity.getPlaceDescription();
        this.placeImgUrl = entity.getPlaceImgUrl();
        this.placeCategory = entity.getPlaceCategory();

    }
    public Place toEntity() {
        return Place.builder()
                .placeId(placeId)
                .placeType(placeType)
                .placeName(placeName)
                .placeArea(placeArea)
                .placeDescription(placeDescription)
                .placeImgUrl(placeImgUrl)
                .placeCategory(placeCategory)
                .build();
    }
}
