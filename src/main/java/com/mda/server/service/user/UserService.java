package com.mda.server.service.user;

import com.mda.server.domain.user.User;
import com.mda.server.domain.user.UserRepository;
import com.mda.server.web.dto.UserResponseDto;
import com.mda.server.web.dto.UserSaveRequestDto;
import com.mda.server.web.dto.UserEnter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    @Transactional
    public List<User> getUserList() {
        return (List<User>) userRepository.findAll();
    }

    @Transactional
    public User getUser(Integer id){
        return userRepository.getOne(id);
    }

    @Transactional
    public User save(UserSaveRequestDto user){

        return userRepository.save(user.toEntity());
    }

    public UserResponseDto findById(Integer id){
        User entity = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("이게뭐냐"));
        return new UserResponseDto(entity);
    }

    public UserEnter findId(Integer id){
        userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("오류"));
        return new UserEnter();
    }
}
