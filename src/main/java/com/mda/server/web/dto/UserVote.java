package com.mda.server.web.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class UserVote {

    private String placename1;
    private String placename2;
    private String placename3;

    private String username1;
    private String username2;
    private String username3;

    private ArrayList<UserVote> list;

}
