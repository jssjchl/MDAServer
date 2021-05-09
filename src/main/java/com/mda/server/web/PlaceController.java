package com.mda.server.web;


import com.mda.server.domain.place.Place;
import com.mda.server.service.place.PlaceService;
import com.mda.server.web.dto.PlaceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlaceController {

    private PlaceDto placeDto = new PlaceDto();
    @Autowired
    PlaceService placeService;

    @GetMapping("place/placeList")
    public List<Place> getAllPlace() {return placeService.getPlaceList(); }





}
