package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test1.test1.bean.PsScoreAcc;
import test1.test1.bean.PsScoreAve;
import test1.test1.dao.PsScoreAveDao;

import java.util.List;

@Service
public class PsScoreAveService {
    @Autowired
    PsScoreAveDao psScoreAveDao;

    public List<PsScoreAve> findAll(){
        return psScoreAveDao.findAll();
    }

    public PsScoreAve getById(int id){
        return psScoreAveDao.findById(id).orElse(new PsScoreAve(-1,-1,-1,-1,-1));
    }

    public PsScoreAve addPsScoreAve(PsScoreAve psScoreAve){
        return psScoreAveDao.save(psScoreAve);
    }

    public PsScoreAve deleteById(int id){
        PsScoreAve psScoreAve = getById(id);
        if(psScoreAve.getPsavid() > -1){
            psScoreAveDao.deleteById(id);
        }
        return psScoreAve;
    }
}
