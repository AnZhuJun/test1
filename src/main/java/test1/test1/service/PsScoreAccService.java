package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test1.test1.bean.FinScoreAcc;
import test1.test1.bean.PsScoreAcc;
import test1.test1.bean.PsScoreWays;
import test1.test1.dao.PsScoreAccDao;
import test1.test1.dao.TeacherDao;

import java.util.List;

@Service
public class PsScoreAccService {
    @Autowired
    PsScoreAccDao psScoreAccDao;

    @Autowired
    TeacherDao teacherDao;

    public List<PsScoreAcc> findAllByUsername(String username){
        return psScoreAccDao.findAllByTeacherid(teacherDao.findByUsername(username).getTeacherid());
    }

    public List<PsScoreAcc> findByTeacherid(int id){
        return psScoreAccDao.findAllByTeacherid(id);
    }

    public PsScoreAcc getById(int id){
        return psScoreAccDao.findById(id).orElse(new PsScoreAcc(-1,-1,-1,-1,-1));
    }

    public PsScoreAcc addPsScoreAcc(PsScoreAcc psScoreAcc){
        return psScoreAccDao.save(psScoreAcc);
    }

    public PsScoreAcc deleteById(int id){
        PsScoreAcc psScoreAcc = getById(id);
        if(psScoreAcc.getPsaid() > -1){
            psScoreAccDao.deleteById(id);
        }
        return psScoreAcc;
    }
}
