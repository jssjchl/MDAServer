package com.mda.server.service.user;

import com.mda.server.domain.place.Place;
import com.mda.server.domain.user.QUser;
import com.mda.server.domain.user.User;
import com.mda.server.domain.user.UserRepository;
import com.mda.server.web.dto.UserResponseDto;
import com.mda.server.web.dto.UserSaveRequestDto;
import com.mda.server.web.dto.UserEnter;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("userService")
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
    public User getUser(int id){
        return userRepository.getOne(id);
    }

    @Transactional
    public User save(UserSaveRequestDto user){

        return userRepository.save(user.toEntity());
    }

    public UserResponseDto findById(int id){
        User entity = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("이게뭐냐"));
        return new UserResponseDto(entity);
    }

    public UserEnter findId(int id){
        userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("오류"));
        return new UserEnter();
    }

    public List<User> getUserInfo(int userId){
        QUser user = QUser.user;
        List<User> userList = new ArrayList<>();

        userList.addAll(from(user).fetch());

        return userList;
    }

    public List<User> getUserInfo2(String userNm) throws UnsupportedEncodingException {
        QUser user = QUser.user;

        //userList.addAll(from(user).fetch());

        /*userList.addAll(from(user).where(user.userName.eq(userNm))
                .groupBy(user.userId)
                .select(Projections.bean(User.class, user.userId, user.userName))
                .fetch());*/
        JPQLQuery<User> query = null;
        query = from(user);
        List<User> list = query.fetch();
        if(list != null){
            for(int i=0; i<list.size(); i++){
                System.out.println(list.get(i));
            }
        }





        //userList.addAll(from(user).where(user.userName.eq("sim")).fetch());
        //System.out.println("userList : " + userList.get(0).getUserId());
        //JPQLQuery<User> query = from(user).where(user.userName.eq(userNm));
       // userMap.put("totalCount", query.fetchCount());
        // userMap.put("data", query.fetchResults().getResults());


        return list;
    }


}
