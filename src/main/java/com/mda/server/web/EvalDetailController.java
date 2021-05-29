package com.mda.server.web;

import com.mda.server.domain.evalDetail.EvalDetail;
import com.mda.server.domain.evalDetail.EvalDetailRepository;
import com.mda.server.domain.schedule.Schedule;
import com.mda.server.domain.schedule.ScheduleRepository;
import com.mda.server.domain.user.User;
import com.mda.server.domain.user.UserRepository;
import com.mda.server.service.evalDetail.EvalDetailService;
import com.mda.server.web.dto.EvalDetailDto;
import com.mda.server.web.dto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
@RestController
public class EvalDetailController {


    @Autowired
    EvalDetailRepository evalDetailRepository;
    UserRepository userRepository;
    ScheduleRepository scheduleRepository;
    EvalDetailService evalDetailService;
    ArrayList<EvalDetailDto> evalDetailDtoArrayList = new ArrayList<>();


    /*평가점수 저장
    * schId값으로 해당스케쥴의 type찾은후 conditionEval 값으로 모두 셋팅해줌
    */


    /*
    @RequestMapping(value = "/rating", method= RequestMethod.POST)
    public int saveRating(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        int schId = Integer.parseInt(request.getParameter("schId"));
        String conditionEval = request.getParameter("conditionEval");
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User오류나욤"));
        User sch = ScheduleRepository.findById(schId).orElseThrow(() -> new IllegalArgumentException("sch오류나욤"));



        EvalDetailDto evalDto = new EvalDetailDto();
        evalDto.setEvalDetailGender();
        evalDto.setEvalDetailAge();
        evalDto.setEvalDetailRating(conditionEval);
        evalDto.setPlaceId(placeid);
        evalDto.setEvalSubId();
        return 1;
    }
    */




//    //최종스케쥴 저장
//    @RequestMapping(value = "/rating", method= RequestMethod.POST) //place 뽑을때 참고할 Data
//    public int saveRating(HttpServletRequest request) {
//        int userId = Integer.parseInt(request.getParameter("userId"));
//        int schId = Integer.parseInt(request.getParameter("schId"));
//        String conditionEval = request.getParameter("conditionEval");
//        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User오류나욤"));
//        User sch = ScheduleRepository.findById(schId).orElseThrow(() -> new IllegalArgumentException("sch오류나욤"));
//
//
//
//        EvalDetailDto evalDto = new EvalDetailDto();
//        evalDto.setEvalDetailGender();
//        evalDto.setEvalDetailAge();
//        evalDto.setEvalDetailRating(conditionEval);
//        evalDto.setPlaceId(placeid);
//        evalDto.setEvalSubId();
//        return 1;
//    }

}
