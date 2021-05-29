package com.mda.server.service.user;

import com.mda.server.domain.user.QUser;
import com.mda.server.domain.user.User;
import com.mda.server.domain.user.UserRepository;
import com.mda.server.web.dto.UserResponseDto;
import com.mda.server.web.dto.UserSaveRequestDto;
import com.mda.server.web.dto.UserEnter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserService extends QuerydslRepositorySupport {
    public UserService(){
        super(User.class);
    }
    private @Autowired UserRepository userRepository;

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

    public List<User> getUserInfo(Integer userId){
        QUser user = QUser.user;
        List<User> userList = new ArrayList<>();

        userList.addAll(from(user).where(user.userId.eq(userId)).fetch());

        return userList;
    }


}
