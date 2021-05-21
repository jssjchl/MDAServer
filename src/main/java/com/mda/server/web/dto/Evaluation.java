package com.mda.server.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Evaluation {
    private Integer evalRating;
    private String evalUserId;

    public Evaluation(){
        this.evalRating=getEvalRating();
        this.evalUserId=getEvalUserId();
    }
}
