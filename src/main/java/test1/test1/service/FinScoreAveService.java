package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test1.test1.bean.FinScoreAcc;
import test1.test1.bean.FinScoreAve;
import test1.test1.dao.FinScoreAveDao;
import test1.test1.dao.TeacherDao;

import java.util.List;

@Service
public class FinScoreAveService {
    @Autowired
    FinScoreAveDao finScoreAveDao;

    @Autowired
    TeacherDao teacherDao;

    public List<FinScoreAve> findAllByUsername(String username){
        return finScoreAveDao.findAllByTeacherid(teacherDao.findByUsername(username).getTeacherid());
    }

    public List<FinScoreAve> findByTeacherid(int id){
        return finScoreAveDao.findAllByTeacherid(id);
    }

    public FinScoreAve getById(int id){
        return finScoreAveDao.findById(id).orElse(new FinScoreAve(-1,-1,-1,-1,-1,-1,-1));
    }

    public FinScoreAve addFinScoreAve(FinScoreAve finScoreAve){
        return finScoreAveDao.save(finScoreAve);
    }

    public FinScoreAve deleteById(int id){
        FinScoreAve finScoreAve = getById(id);
        if(finScoreAve.getFsavid() > -1){
            finScoreAveDao.deleteById(id);
        }
        return finScoreAve;
    }
}
