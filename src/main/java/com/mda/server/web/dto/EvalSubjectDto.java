package com.mda.server.web.dto;

import com.mda.server.domain.evalSubject.EvalSubject;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EvalSubjectDto {
    private int evalSubId;
    private String evalSubType;


    @Builder
    public EvalSubjectDto(int evalSubId, String evalSubType){
        this.evalSubId=evalSubId;
        this.evalSubType=evalSubType;
    }
    public EvalSubject toEntity(){
        return EvalSubject.builder()
                .evalSubId(evalSubId)
                .eval_Sub_Type(evalSubType)
                .build();
    }
}