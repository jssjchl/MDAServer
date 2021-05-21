package com.mda.server.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVote {

    private Integer votePlaceId;
    private Integer voteUserId;

    public UserVote(){
        this.votePlaceId=getVoteUserId();
        this.voteUserId=getVoteUserId();
    }
}
