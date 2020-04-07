package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test1.test1.bean.FinScoreAcc;
import test1.test1.bean.MidScoreAcc;
import test1.test1.dao.FinScoreAccDao;

import java.util.List;

@Service
public class FinScoreAccService {
    @Autowired
    FinScoreAccDao finScoreAccDao;

    public List<FinScoreAcc> findAll(){
        return finScoreAccDao.findAll();
    }

    public FinScoreAcc getById(int id){
        return finScoreAccDao.findById(id).orElse(new FinScoreAcc(-1,-1,-1,-1,-1,-1,-1));
    }

    public FinScoreAcc addFinScoreAcc(FinScoreAcc finScoreAcc){
        return finScoreAccDao.save(finScoreAcc);
    }

    public FinScoreAcc deleteById(int id){
        FinScoreAcc finScoreAcc = getById(id);
        if(finScoreAcc.getFsaid() > -1){
            finScoreAccDao.deleteById(id);
        }
        return finScoreAcc;
    }
}
