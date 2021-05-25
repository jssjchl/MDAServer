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

    @Column(nullable = false)
    private String eval_Sub_Category;

    @Builder
    public EvalSubject(int evalSubId, String eval_Sub_Type, String eval_Sub_Category){
        this.evalSubId=evalSubId;
        this.eval_Sub_Type=eval_Sub_Type;
        this.eval_Sub_Category=eval_Sub_Category;
    }
}
