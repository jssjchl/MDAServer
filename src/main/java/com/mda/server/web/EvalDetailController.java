package com.mda.server.web;

import com.mda.server.domain.evalDetail.EvalDetail;
import com.mda.server.domain.evalDetail.EvalDetailRepository;
import com.mda.server.service.evalDetail.EvalDetailService;
import com.mda.server.web.dto.EvalDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
@RestController
public class EvalDetailController {


    @Autowired
    EvalDetailRepository evalDetailRepository;
    EvalDetailService evalDetailService;

    ArrayList<EvalDetailDto> evalDetailDtoArrayList = new ArrayList<>();


    @PostMapping(value = "/rating")
    public EvalDetail saveRating(HttpServletRequest request) {
        EvalDetailDto rt = new EvalDetailDto();
        rt.setEvalDetailId(Integer.valueOf(request.getParameter("evalDetailId")));
        rt.setEvalDetailAge(request.getParameter("evalDetailAge"));
        rt.setEvalDetailGender(request.getParameter("evalDetailGender"));
        rt.setEvalDetailRating(request.getParameter("evalDetailRating"));
        rt.setEvalSubId(Integer.valueOf(request.getParameter("evalSubId")));
        rt.setPlaceId(Integer.valueOf(request.getParameter("placeId")));
        
        return evalDetailService.save(rt);
    }
}
