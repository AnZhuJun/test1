package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import test1.test1.bean.MidScore;
import test1.test1.bean.PsScore;
import test1.test1.bean.PsScoreAve;
import test1.test1.dao.PsScoreDao;
import test1.test1.dao.TeacherDao;

import java.util.List;

@Service
public class PsScoreService {
    @Autowired
    PsScoreDao psScoreDao;

    @Autowired
    TeacherDao teacherDao;

    public Page<PsScore> findAllByUsername(Pageable pageable, String username){
        return psScoreDao.findAllByTeacherid(pageable,teacherDao.findByUsername(username).getTeacherid());
    }

    public List<PsScore> findByIdName(int teacherid,String name){
        return psScoreDao.findAllByTeacheridAndName(teacherid, name);
    }

    public List<PsScore> findByTeacherid(int id){
        return psScoreDao.findAllByTeacherid(id);
    }

    public PsScore getById(int id){
        return psScoreDao.findById(id).orElse(new PsScore(-1,"null","null","null",-1,-1,-1,-1,"null",-1,-1,-1));
    }

    public PsScore addPsScore(PsScore psScore){
        return psScoreDao.save(psScore);
    }

    public PsScore deleteById(int id){
        PsScore psScore = getById(id);
        if(psScore.getPsscoreid() > -1){
            psScoreDao.deleteById(id);
        }
        return psScore;
    }
}
