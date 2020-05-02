package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import test1.test1.bean.FinalScore;
import test1.test1.bean.MidScore;
import test1.test1.dao.MidScoreDao;
import test1.test1.dao.TeacherDao;

import java.util.List;

@Service
public class MidScoreService {
    @Autowired
    MidScoreDao midScoreDao;

    @Autowired
    TeacherDao teacherDao;

    public Page<MidScore> findAllByUsername(Pageable pageable, String username){
        return midScoreDao.findAllByTeacherid(pageable,teacherDao.findByUsername(username).getTeacherid());
    }

    public List<MidScore> findByIdName(int teacherid,String name){
        return midScoreDao.findAllByTeacheridAndName(teacherid, name);
    }

    public List<MidScore> findByTeacherid(int id){
        return midScoreDao.findAllByTeacherid(id);
    }

    public MidScore getById(int id){
        return midScoreDao.findById(id).orElse(new MidScore(-1,"null","null","null",-1,-1,-1,-1,"null",-1,-1,-1,-1));
    }

    public MidScore addMidScore(MidScore midScore){
        return midScoreDao.save(midScore);
    }

    public MidScore deleteById(int id){
        MidScore midScore = getById(id);
        if(midScore.getMidscoreid() > -1){
            midScoreDao.deleteById(id);
        }
        return midScore;
    }
}
