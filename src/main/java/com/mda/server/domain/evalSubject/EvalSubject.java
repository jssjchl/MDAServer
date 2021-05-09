package com.mda.server.domain.evalSubject;

import com.sun.istack.Nullable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class EvalSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer evalSubId;

    @Column(nullable = false)
    private String eval_Sub_Type;

    @Builder
    public EvalSubject(int evalSubId, String eval_Sub_Type){
        this.evalSubId=evalSubId;
        this.eval_Sub_Type=eval_Sub_Type;
    }

}
