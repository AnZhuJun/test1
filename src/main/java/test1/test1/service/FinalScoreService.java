package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import test1.test1.bean.ExamScoreWays;
import test1.test1.bean.FinScoreAcc;
import test1.test1.bean.FinalScore;
import test1.test1.dao.FinalScoreDao;
import test1.test1.dao.TeacherDao;

import java.util.List;

@Service
public class FinalScoreService {
    @Autowired
    FinalScoreDao finalScoreDao;

    @Autowired
    TeacherDao teacherDao;

    public Page<FinalScore> findAllByUsername(Pageable pageable, String username){
        return finalScoreDao.findAllByTeacherid(pageable,teacherDao.findByUsername(username).getTeacherid());
    }

    public List<FinalScore> findById(int teacherid,String name){
        return finalScoreDao.findAllByTeacheridAndName(teacherid, name);
    }

    public List<FinalScore> findByTeacherid(int id){
        return finalScoreDao.findAllByTeacherid(id);
    }

    public FinalScore getById(int id){
        return finalScoreDao.findById(id).orElse(new FinalScore(-1,"null","null","null",-1,-1,-1,-1,-1,"null",-1,-1,-1,-1));
    }

    public FinalScore addFinalScore(FinalScore finalScore){
        return finalScoreDao.save(finalScore);
    }

    public FinalScore deleteById(int id){
        FinalScore finalScore = getById(id);
        if(finalScore.getFinalscoreid() > -1){
            finalScoreDao.deleteById(id);
        }
        return finalScore;
    }
}
