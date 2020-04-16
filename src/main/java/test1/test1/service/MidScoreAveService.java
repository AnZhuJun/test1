package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test1.test1.bean.FinScoreAcc;
import test1.test1.bean.FinScoreAve;
import test1.test1.bean.MidScoreAve;
import test1.test1.dao.MidScoreAccDao;
import test1.test1.dao.MidScoreAveDao;
import test1.test1.dao.TeacherDao;

import java.util.List;

@Service
public class MidScoreAveService {
    @Autowired
    MidScoreAveDao midScoreAveDao;

    @Autowired
    TeacherDao teacherDao;

    public List<MidScoreAve> findAllByUsername(String username){
        return midScoreAveDao.findAllByTeacherid(teacherDao.findByUsername(username).getTeacherid());
    }

    public List<MidScoreAve> findByTeacherid(int id){
        return midScoreAveDao.findAllByTeacherid(id);
    }

    public MidScoreAve getById(int id){
        return midScoreAveDao.findById(id).orElse(new MidScoreAve(-1,-1,-1,-1,-1,-1,-1));
    }

    public MidScoreAve addMidScoreAve(MidScoreAve midScoreAve){
        return midScoreAveDao.save(midScoreAve);
    }

    public MidScoreAve deleteById(int id){
        MidScoreAve midScoreAve = getById(id);
        if(midScoreAve.getMsavid() > -1){
            midScoreAveDao.deleteById(id);
        }
        return midScoreAve;
    }
}
