package com.mda.server.web;


import com.mda.server.domain.place.Place;
import com.mda.server.service.place.PlaceService;
import com.mda.server.web.dto.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


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