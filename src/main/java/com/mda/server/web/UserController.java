package com.mda.server.web;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mda.server.domain.user.User;
import com.mda.server.service.user.UserService;
import com.mda.server.web.dto.UserResponseDto;
import com.mda.server.web.dto.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class UserController {
    @Autowired
    UserService userService;
    UserSaveRequestDto user = new UserSaveRequestDto();

    @PostMapping("/test1")
    public User getUser(HttpServletRequest request){

        user.setUserId(request.getParameter("id"));
        user.setUserPwd(request.getParameter("pwd"));
        return userService.save(user);
    }

    @GetMapping("/test2")
    public UserSaveRequestDto test(){
        return user;
    }

    @GetMapping("/test5/{id}")
    public UserResponseDto findById (@PathVariable String id){
        return userService.findById(id);
    }


}

