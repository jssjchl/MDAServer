package com.mda.server.domain.evalDetail;

import com.mda.server.web.dto.EvalDetailDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class EvalDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="EVAL_DETAIL_ID", nullable = false)
    private Integer evalDetailId;

    @Column(name="EVAL_DETAIL_GENDER",nullable = false)
    private String evalDetailGender;

    @Column(name="EVAL_DETAIL_AGE",nullable = false)
    private String evalDetailAge;

    @Column(name="EVAL_DETAIL_RATINGS",nullable = false)
    private String evalDetailRatings;

    @Column(name="PLACE_ID",nullable = false)
    private Integer placeId;

    @Column(name="EVAL_SUB_ID",nullable = false)
    private Integer evalSubId;



    @Builder
    public EvalDetail(Integer evalDetailId, String evalDetailGender, String evalDetailAge, String evalDetailRatings, Integer placeId, Integer evalSubId){
        this.evalDetailId=evalDetailId;
        this.evalDetailGender=evalDetailGender;
        this.evalDetailAge=evalDetailAge;
        this.evalDetailRatings=evalDetailRatings;
        this.placeId=placeId;
        this.evalSubId=evalSubId;
    }
}
