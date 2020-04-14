package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test1.test1.bean.FinScoreAcc;
import test1.test1.bean.MidScoreAcc;
import test1.test1.bean.Paper;
import test1.test1.dao.MidScoreAccDao;
import test1.test1.dao.TeacherDao;

import java.util.List;

@Service
public class MidScoreAccService {
    @Autowired
    MidScoreAccDao midScoreAccDao;

    @Autowired
    TeacherDao teacherDao;

    public List<MidScoreAcc> findAllByUsername(String username){
        return midScoreAccDao.findAllByTeacherid(teacherDao.findByUsername(username).getTeacherid());
    }

    public List<MidScoreAcc> findByTeacherid(int id){
        return midScoreAccDao.findAllByTeacherid(id);
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
