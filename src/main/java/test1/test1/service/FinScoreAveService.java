package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test1.test1.bean.FinScoreAve;
import test1.test1.dao.FinScoreAveDao;

import java.util.List;

@Service
public class FinScoreAveService {
    @Autowired
    FinScoreAveDao finScoreAveDao;

    public List<FinScoreAve> findAll(){
        return finScoreAveDao.findAll();
    }

    public FinScoreAve getById(int id){
        return finScoreAveDao.findById(id).orElse(new FinScoreAve(-1,-1,-1,-1,-1,-1,-1));
    }

    public FinScoreAve addFinScoreAve(FinScoreAve finScoreAve){
        return finScoreAveDao.save(finScoreAve);
    }

    public FinScoreAve deleteById(int id){
        FinScoreAve finScoreAve = getById(id);
        if(finScoreAve.getFsaid() > -1){
            finScoreAveDao.deleteById(id);
        }
        return finScoreAve;
    }
}
