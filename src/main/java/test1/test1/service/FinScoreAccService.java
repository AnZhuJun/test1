package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test1.test1.bean.FinScoreAcc;
import test1.test1.bean.FinalScore;
import test1.test1.bean.MidScoreAcc;
import test1.test1.dao.FinScoreAccDao;
import test1.test1.dao.TeacherDao;

import java.util.List;

@Service
public class FinScoreAccService {
    @Autowired
    FinScoreAccDao finScoreAccDao;

    @Autowired
    TeacherDao teacherDao;

    public List<FinScoreAcc> findAllByUsername(String username){
        return finScoreAccDao.findAllByTeacherid(teacherDao.findByUsername(username).getTeacherid());
    }

    public List<FinScoreAcc> findByTeacherid(int id){
        return finScoreAccDao.findAllByTeacherid(id);
    }

    public FinScoreAcc getById(int id){
        return finScoreAccDao.findById(id).orElse(new FinScoreAcc(-1,-1,-1,-1,-1,-1,-1));
    }

    public FinScoreAcc addFinalScoreAcc(FinScoreAcc finScoreAcc){
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
