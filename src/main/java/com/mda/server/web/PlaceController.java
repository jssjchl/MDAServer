package com.mda.server.web;


import com.mda.server.service.place.PlaceService;
import com.mda.server.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
public class PlaceController {

    @Autowired
    PlaceService placeService;
    LocInitSet st = new LocInitSet();

    //placeId 값 받아서 place상세정보 return
    @GetMapping(value= "/placeDetail/{placeId}")
    public PlaceDto findById (@PathVariable int placeId){
        return placeService.findById(placeId);
    }


}