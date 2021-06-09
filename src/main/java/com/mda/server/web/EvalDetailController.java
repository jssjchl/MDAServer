package com.mda.server.web;

import com.mda.server.domain.evalDetail.EvalDetail;
import com.mda.server.domain.evalDetail.EvalDetailRepository;
import com.mda.server.domain.schedule.Schedule;
import com.mda.server.domain.schedule.ScheduleRepository;
import com.mda.server.domain.user.User;
import com.mda.server.domain.user.UserRepository;
import com.mda.server.service.evalDetail.EvalDetailService;
import com.mda.server.service.place.PlaceService;
import com.mda.server.service.schedule.ScheduleService;
import com.mda.server.service.user.UserService;
import com.mda.server.web.dto.EvalDetailDto;
import com.mda.server.web.dto.PlaceDto;
import com.mda.server.web.dto.ScheduleDto;
import com.mda.server.web.dto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EvalDetailController {


    @Autowired
    EvalDetailRepository evalDetailRepository;
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    EvalDetailService evalDetailService;
    @Autowired
    ScheduleService scheduleService;
    @Autowired
    PlaceService placeService;

    ArrayList<EvalDetailDto> evalDetailDtoArrayList = new ArrayList<>();


    /*평가점수 저장
    * schId값으로 해당스케쥴의 type찾은후 conditionEval 값으로 모두 셋팅해줌
    */





}
