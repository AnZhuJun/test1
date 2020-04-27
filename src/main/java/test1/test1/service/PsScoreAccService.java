package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<PsScoreAcc> findAllByUsername(Pageable pageable, String username){
        return psScoreAccDao.findAllByTeacherid(pageable,teacherDao.findByUsername(username).getTeacherid());
    }

    public List<PsScoreAcc> findById(int teacherid,int courseid){
        return psScoreAccDao.findAllByTeacheridAndCourseid(teacherid, courseid);
    }

    public List<PsScoreAcc> findByTeacherid(int id){
        return psScoreAccDao.findByTeacherid(id);
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
