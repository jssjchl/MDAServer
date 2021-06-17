package com.mda.server.web;


import com.mda.server.service.evalSubject.EvalSubjectService;
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

    @Autowired
    EvalSubjectService evalSubjectService;

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
        PlaceDto p = new PlaceDto();
        p = placeService.findById(placeId);
        String tmp[] = p.getPlaceType().split(",");
        int t[] = new int[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            t[i] = Integer.parseInt(tmp[i]);
        }
        String type="";
        for (int i = 0; i < t.length; i++) {
            type += ("#"+evalSubjectService.findById(t[i]).getEvalSubType()+" ");
        }
        p.setPlaceType(type);
        return p;
    }


}