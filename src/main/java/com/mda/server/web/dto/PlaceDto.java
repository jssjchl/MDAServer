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
    private int placeId;
    private String placeArea;
    private String placeDescription;
    private String placeImg_Url;
    private String placeName;
    private String placeType;

    @Builder
    public PlaceDto(int placeId, String placeArea, String placeDescription,
                 String placeImg_Url, String placeName, String placeType) {

        this.placeId = placeId;
        this.placeArea = placeArea;
        this.placeDescription = placeDescription;
        this.placeImg_Url = placeImg_Url;
        this.placeName = placeName;
        this.placeType = placeType;
    }
        public Place toEntity() {
            return Place.builder()
                    .placeId(placeId)
                    .placeArea(placeArea)
                    .placeDescription(placeDescription)
                    .placeName(placeName)
                    .placeImg_Url(placeImg_Url)
                    .placeType(placeType)
                    .build();
    }
}

