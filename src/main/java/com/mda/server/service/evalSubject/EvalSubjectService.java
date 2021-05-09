package com.mda.server.service.evalSubject;

import com.mda.server.domain.evalSubject.EvalSubectRepository;
import com.mda.server.domain.evalSubject.EvalSubject;
import com.mda.server.web.dto.EvalSubjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EvalSubjectService {

    @Autowired
    EvalSubectRepository evalSubectRepository;

    public List<EvalSubject> getEvalSubjectList(){ return (List<EvalSubject>) evalSubectRepository.findAll();}

    @Transactional
    public EvalSubject save(EvalSubjectDto evalSubject){
        return evalSubectRepository.save(evalSubject.toEntity());
    }
}
