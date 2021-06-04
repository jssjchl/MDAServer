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

    private String pVotedUserName;
    private String placePname;
    private String pId;

    @Builder
    public voteStatus(String pVotedUserName, String placePname, String pId) {
        this.pVotedUserName = pVotedUserName;
        this.placePname = placePname;
        this.pId = pId;
    }

    public voteStatus toEntity(){
        return voteStatus.builder()
                .pVotedUserName(pVotedUserName)
                .placePname(placePname)
                .pId(pId)
                .build();
    }

}
