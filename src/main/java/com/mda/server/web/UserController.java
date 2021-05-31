package com.mda.server.web;

import com.mda.server.domain.schedule.ScheduleRepository;
import com.mda.server.domain.user.User;
import com.mda.server.service.user.UserService;
import com.mda.server.web.dto.UserResponseDto;
import com.mda.server.web.dto.UserSaveRequestDto;
import com.mda.server.web.dto.voteStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    @Autowired
    UserService userService;
    UserSaveRequestDto user = new UserSaveRequestDto();
    ArrayList<voteStatus> voteStatusList = new ArrayList<>();
    int userVoteCnt = 0;

    @PostMapping("/test1")
    public User getUser(HttpServletRequest request){
        user.setUserId(Integer.valueOf(request.getParameter("id")));
        user.setUserPwd(request.getParameter("pwd"));
        return userService.save(user);
    }

    @GetMapping("/test2")
    public UserSaveRequestDto test(){
        return user;
    }

    @GetMapping("/test5/{id}")
    public UserResponseDto findById (@PathVariable Integer id){
        return userService.findById(id);
    }

    @PostMapping("/voteUser")
    public voteStatus userVote(HttpServletRequest request){
        voteStatus voteStatus = new voteStatus();
        List<User> userList = new ArrayList<>();
        Integer userId = Integer.parseInt(request.getParameter("voteUserId"));
        userList = userService.getUserInfo(userId);
        voteStatus.setPVotedUser(request.getParameter("voteUserId"));
        voteStatus.setPlacePname(request.getParameter("votePlaceId"));
        voteStatus.setPId(Integer.parseInt(request.getParameter("votePlaceId")));

        if (userVoteCnt > 3){
            voteStatusList.clear();
            userVoteCnt = 1;
        }
        voteStatusList.add(voteStatus);
        return voteStatus;
    }

    @PostMapping("/voteUserList")
    public ArrayList<voteStatus> userVoteList(HttpServletRequest request){
        return voteStatusList;
    }


}

