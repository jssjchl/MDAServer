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

    /**
     * @Class Name : PlaceController.java
     * @title
     * @param : placeId, @PathVariable
     * @returnType : placeDto
     * @since 2021.  05
     * @dscription : placeId값 받아서 place상세정보 return
     *
     * << 개정이력(Modification Information) >>
     *  수정일           수정자        수정내용
     * ---------------------------------------------------
     * 2021. 05.                    최초생성
     * 2021. 06. 01                 테스트완료
     */

    @GetMapping(value= "/placeDetail/{placeId}")
    public PlaceDto findById (@PathVariable int placeId){
        return placeService.findById(placeId);
    }


}