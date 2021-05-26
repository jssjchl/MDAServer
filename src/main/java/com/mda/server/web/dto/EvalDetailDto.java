package com.mda.server.web.dto;

import com.mda.server.domain.evalDetail.EvalDetail;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EvalDetailDto {
    private Integer evalDetailId;
    private String evalDetailGender;
    private String evalDetailAge;
    private String evalDetailRating;
    private Integer placeId;
    private Integer evalSubId;


    @Builder
    public EvalDetailDto(Integer evalDetailId, String evalDetailGender,  String evalDetailAge, String evalDetailRating
                        ,Integer placeId, Integer evalSubId){
        this.evalDetailId =evalDetailId;
        this.evalDetailGender=evalDetailGender;
        this.evalDetailAge=evalDetailAge;
        this.evalDetailRating=evalDetailRating;
        this.placeId=placeId;
        this.evalSubId=evalSubId;
    }

    public EvalDetail toEntity() {
        return EvalDetail.builder()
                .evalDetailId(evalDetailId)
                .evalDetailGender(evalDetailGender)
                .evalDetailAge(evalDetailAge)
                .evalDetailRating(evalDetailRating)
                .placeId(placeId)
                .evalSubId(evalSubId)
                .build();
    }
}
