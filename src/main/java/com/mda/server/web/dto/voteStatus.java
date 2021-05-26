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
public class voteStatus {

    private String pVotedUser;
    private String placePname;
    private int pId;

    @Builder
    public voteStatus(String pVotedUser, String placePname, int pId) {
        this.pVotedUser = pVotedUser;
        this.placePname = placePname;
        this.pId = pId;
    }

    public voteStatus toEntity(){
        return voteStatus.builder()
                .pVotedUser(pVotedUser)
                .placePname(placePname)
                .pId(pId)
                .build();
    }

}
