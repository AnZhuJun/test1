package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test1.test1.bean.PsScoreAcc;
import test1.test1.bean.PsScoreWays;
import test1.test1.dao.PsScoreAccDao;

import java.util.List;

@Service
public class PsScoreAccService {
    @Autowired
    PsScoreAccDao psScoreAccDao;

    public List<PsScoreAcc> findAll(){
        return psScoreAccDao.findAll();
    }

    public PsScoreAcc getById(int id){
        return psScoreAccDao.findById(id).orElse(new PsScoreAcc(-1,-1,-1,-1,-1));
    }

    public PsScoreAcc addPsScoreAcc(PsScoreAcc psScoreAcc){
        return psScoreAccDao.save(psScoreAcc);
    }

    public PsScoreAcc deleteById(int id){
        PsScoreAcc psScoreAcc = getById(id);
        if(psScoreAcc.getPsaid() > -1){
            psScoreAccDao.deleteById(id);
        }
        return psScoreAcc;
    }
}
