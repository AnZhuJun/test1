package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import test1.test1.bean.PsScoreAcc;
import test1.test1.bean.PsScoreAve;
import test1.test1.dao.PsScoreAveDao;
import test1.test1.dao.TeacherDao;

import java.util.List;

@Service
public class PsScoreAveService {
    @Autowired
    PsScoreAveDao psScoreAveDao;

    @Autowired
    TeacherDao teacherDao;

    public Page<PsScoreAve> findAllByUsername(Pageable pageable, String username){
        return psScoreAveDao.findAllByTeacherid(pageable,teacherDao.findByUsername(username).getTeacherid());
    }

    public List<PsScoreAve> findById(int teacherid,int courseid){
        return psScoreAveDao.findAllByTeacheridAndCourseid(teacherid, courseid);
    }

    public List<PsScoreAve> findByTeacherid(int id){
        return psScoreAveDao.findAllByTeacherid(id);
    }

    public PsScoreAve getById(int id){
        return psScoreAveDao.findById(id).orElse(new PsScoreAve(-1,-1,-1,-1,-1));
    }

    public PsScoreAve addPsScoreAve(PsScoreAve psScoreAcc){
        return psScoreAveDao.save(psScoreAcc);
    }

    public PsScoreAve deleteById(int id){
        PsScoreAve psScoreAve = getById(id);
        if(psScoreAve.getPsavid() > -1){
            psScoreAveDao.deleteById(id);
        }
        return psScoreAve;
    }
}
