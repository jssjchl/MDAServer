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

    public EvalSubjectDto findById(int id){
        EvalSubject entity = evalSubectRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("이게뭐냐"));
        return new EvalSubjectDto(entity);
    }

    @Transactional
    public EvalSubject save(EvalSubjectDto evalSubject){
        return evalSubectRepository.save(evalSubject.toEntity());
    }
}
