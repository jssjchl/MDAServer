package com.mda.server.service.evalDetail;

import com.mda.server.domain.evalDetail.EvalDetail;
import com.mda.server.domain.evalDetail.EvalDetailRepository;
import com.mda.server.web.dto.EvalDetailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EvalDetailService {

    @Autowired
    EvalDetailRepository evalDetailRepository;

    public List<EvalDetail> getEvalList() {return (List<EvalDetail>) evalDetailRepository.findAll(); }

    @Transactional
    public EvalDetail save(EvalDetailDto evalDetail){
        return evalDetailRepository.save(evalDetail.toEntity());
    }

}
