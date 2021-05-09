package com.mda.server.web.dto;

import com.mda.server.domain.evalDetail.EvalDetail;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
public class EvalDetailDto {
    private int evalDetailId;
    private String evalDetailAge;
    private String evalDetailRating;
    private String evalDetailGender;

    @Builder
    public EvalDetailDto(int evalDetailID, String evalDetailAge, String evalDetailGender, String evalDetailRating){
        this.evalDetailId =evalDetailID;
        this.evalDetailAge=evalDetailAge;
        this.evalDetailGender=evalDetailGender;
        this.evalDetailRating=evalDetailRating;
    }

    public EvalDetail toEntity() {
        return EvalDetail.builder()
                .evalDetailID(evalDetailId)
                .evalDetailAge(evalDetailAge)
                .evalDetailRating(evalDetailRating)
                .evalDetailGender(evalDetailGender)
                .build();
    }
}
