package com.mda.server.web;

import com.mda.server.domain.user.User;
import com.mda.server.service.user.UserService;
import com.mda.server.web.dto.UserResponseDto;
import com.mda.server.web.dto.voteStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    ArrayList<voteStatus> voteStatusList = new ArrayList<>();
    int userVoteCnt = 0;


    /**
     * @Class Name : UserController.java
     * @title : userVote
     * @param : voteUserName, votePlaceId, voteUserId : Http
     * @returnType : voteStatus
     * @since 2021.  05
     * @dscription : 투표한 사용자의 정보를 받아 voteStatus객체에 셋팅후 voteStatusList에 add한다.
     *
     * << 개정이력(Modification Information) >>
     *  수정일           수정자        수정내용
     * ---------------------------------------------------
     * 2021. 05.                    최초생성
     * 2021. 06. 01                 테스트완료
     */

    @PostMapping("/userVote")
    public voteStatus userVote(HttpServletRequest request){
        voteStatus vs = new voteStatus();
//        int uid = Integer.parseInt(request.getParameter("voteUserName"));
//        UserResponseDto user = new UserResponseDto();
//        user = userService.findById(uid);
//        String name = "";
//        name = user.getUserName();

        vs.setPVotedUserName(request.getParameter("pVotedUserName"));
        vs.setPlacePname(request.getParameter("placePname"));
        vs.setPId(Integer.parseInt(request.getParameter("pId")));

        for(int i=0; i<voteStatusList.size(); i++){
            if(voteStatusList.get(i).getPlacePname().equals(vs.getPlacePname())){
                String name = voteStatusList.get(i).getPVotedUserName()+", "+vs.getPVotedUserName();
                voteStatusList.get(i).setPVotedUserName(name);
                userVoteCnt++;
                return vs;
            }
        }


        System.out.println(vs.getPVotedUserName() + "/" + vs.getPlacePname() + "/" + vs.getPId());

        userVoteCnt ++;
        if (userVoteCnt > 3){
            voteStatusList = new ArrayList<>();
            userVoteCnt = 1;
        }
        voteStatusList.add(vs);
        return vs;
    }


    /**
     * @Class Name : UserController.java
     * @title : userVoteList
     * @param :
     * @returnType : ArrayList<voteStatus>
     * @since 2021.  05
     * @dscription : voteStatusList를 return한다
     *
     * << 개정이력(Modification Information) >>
     *  수정일           수정자        수정내용
     * ---------------------------------------------------
     * 2021. 05.                    최초생성
     * 2021. 06. 01                 테스트완료
     */

    @GetMapping("/voteUserList")
    public List<voteStatus> userVoteList(){
        for (int i = 0; i < voteStatusList.size(); i++) {
            System.out.println(voteStatusList.get(i).getPVotedUserName()+"/"+voteStatusList.get(i).getPlacePname());
        }

        return voteStatusList;
    }


}

