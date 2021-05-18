package com.mda.server.web;

import com.mda.server.domain.evalDetail.EvalDetail;
import com.mda.server.domain.evalDetail.EvalDetailRepository;
import com.mda.server.domain.place.Place;
import com.mda.server.domain.place.PlaceRepository;
import com.mda.server.web.dto.PlaceDto;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class EvalDetailController {


    @Autowired
    EvalDetailRepository evalDetailRepository;



}
