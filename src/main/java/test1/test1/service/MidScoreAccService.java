package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test1.test1.bean.MidScoreAcc;
import test1.test1.bean.Paper;
import test1.test1.dao.MidScoreAccDao;

import java.util.List;

@Service
public class MidScoreAccService {
    @Autowired
    MidScoreAccDao midScoreAccDao;

    public List<MidScoreAcc> findAll(){
        return midScoreAccDao.findAll();
    }

    public MidScoreAcc getById(int id){
        return midScoreAccDao.findById(id).orElse(new MidScoreAcc(-1,-1,-1,-1,-1,-1,-1));
    }

    public MidScoreAcc addMidScoreAcc(MidScoreAcc midScoreAcc){
        return midScoreAccDao.save(midScoreAcc);
    }

    public MidScoreAcc deleteById(int id){
        MidScoreAcc midScoreAcc = getById(id);
        if(midScoreAcc.getMsaid() > -1){
            midScoreAccDao.deleteById(id);
        }
        return midScoreAcc;
    }
}
