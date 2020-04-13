package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test1.test1.bean.Examways;
import test1.test1.bean.PsScoreWays;
import test1.test1.dao.PsScoreWaysDao;
import test1.test1.dao.TeacherDao;

import java.util.List;

@Service
public class PsScoreWaysService {
    @Autowired
    PsScoreWaysDao psScoreWaysDao;

    @Autowired
    TeacherDao teacherDao;

    public List<PsScoreWays> findAllByUsername(String username){
        return psScoreWaysDao.findAllByTeacherid(teacherDao.findByUsername(username).getTeacherid());
    }

    public List<PsScoreWays> findByTeacherid(int id){
        return psScoreWaysDao.findAllByTeacherid(id);
    }

    public PsScoreWays getById(int id){
        return psScoreWaysDao.findById(id).orElse(new PsScoreWays(-1,-1,-1,"null","null","null","null"));
    }

    public PsScoreWays addPsScoreWays(PsScoreWays psScoreWays){
        return psScoreWaysDao.save(psScoreWays);
    }

    public PsScoreWays deleteById(int id){
        PsScoreWays psScoreWays = getById(id);
        if(psScoreWays.getPsswid() > -1){
            psScoreWaysDao.deleteById(id);
        }
        return psScoreWays;
    }
}
