package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test1.test1.bean.FinScoreAcc;
import test1.test1.bean.MidScoreAve;
import test1.test1.dao.MidScoreAccDao;
import test1.test1.dao.MidScoreAveDao;

import java.util.List;

@Service
public class MidScoreAveService {
    @Autowired
    MidScoreAveDao midScoreAveDao;

    public List<MidScoreAve> findAll(){
        return midScoreAveDao.findAll();
    }

    public MidScoreAve getById(int id){
        return midScoreAveDao.findById(id).orElse(new MidScoreAve(-1,-1,-1,-1,-1,-1,-1));
    }

    public MidScoreAve addMidScoreAve(MidScoreAve midScoreAve){
        return midScoreAveDao.save(midScoreAve);
    }

    public MidScoreAve deleteById(int id){
        MidScoreAve midScoreAve = getById(id);
        if(midScoreAve.getMsaid() > -1){
            midScoreAveDao.deleteById(id);
        }
        return midScoreAve;
    }
}
