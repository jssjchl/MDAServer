package com.mda.server.web.dto;

import com.mda.server.domain.evalDetail.EvalDetail;
import com.mda.server.domain.schedule.Schedule;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class UserVote {

    private String pVotedUser;
    private String placePname;

    @Builder
    public UserVote(String pVotedUser, String placePname) {
        this.pVotedUser = pVotedUser;
        this.placePname = placePname;
    }

    public UserVote toEntity(){
        return UserVote.builder()
                .pVotedUser(pVotedUser)
                .placePname(placePname)
                .build();
    }

}
