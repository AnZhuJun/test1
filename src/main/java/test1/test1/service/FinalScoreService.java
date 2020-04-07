package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test1.test1.bean.FinScoreAcc;
import test1.test1.bean.FinalScore;
import test1.test1.dao.FinalScoreDao;

import java.util.List;

@Service
public class FinalScoreService {
    @Autowired
    FinalScoreDao finalScoreDao;

    public List<FinalScore> findAll(){
        return finalScoreDao.findAll();
    }

    public FinalScore getById(int id){
        return finalScoreDao.findById(id).orElse(new FinalScore(-1,"null","null","null",-1,-1,-1,-1,-1,"null",-1,-1,-1,-1));
    }

    public FinalScore addFinScore(FinalScore finScoreAcc){
        return finalScoreDao.save(finScoreAcc);
    }

    public FinalScore deleteById(int id){
        FinalScore finalScore = getById(id);
        if(finalScore.getFinalscoreid() > -1){
            finalScoreDao.deleteById(id);
        }
        return finalScore;
    }
}
