package com.mda.server.domain.evalDetail;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CollectionId;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class EvalDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer evalDetailID;

    @Column(nullable = false)
    private String evalDetailAge;

    @Column(nullable = false)
    private String evalDetailRating;

    @Column(nullable = false)
    private String evalDetailGender;

    @Builder
    public EvalDetail(int evalDetailID, String evalDetailAge, String evalDetailGender, String evalDetailRating){
        this.evalDetailID=evalDetailID;
        this.evalDetailAge=evalDetailAge;
        this.evalDetailGender=evalDetailGender;
        this.evalDetailRating=evalDetailRating;
    }
}
