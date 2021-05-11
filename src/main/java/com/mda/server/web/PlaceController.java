package com.mda.server.web;


import com.mda.server.domain.place.Place;
import com.mda.server.service.place.PlaceService;
import com.mda.server.web.dto.PlaceResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlaceController {


    @Autowired
    PlaceService placeService;

    @GetMapping("place/placeList")
    public List<Place> getAllPlace() {return placeService.getPlaceList(); }

    @GetMapping("/getplaceDetail/{id}")
    public PlaceResponseDto findById (@PathVariable Integer id){
        return placeService.findById(id);
    }



}