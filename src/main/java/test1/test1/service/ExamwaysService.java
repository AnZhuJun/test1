package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import test1.test1.bean.Examways;
import test1.test1.dao.ExamwaysDao;
import test1.test1.dao.TeacherDao;

import java.util.List;

@Service
public class ExamwaysService {
    @Autowired
    ExamwaysDao examwaysDao;

    @Autowired
    TeacherDao teacherDao;

    public Page<Examways> findAllByUsername(Pageable pageable, String username){
        return examwaysDao.findAllByTeacherid(pageable,teacherDao.findByUsername(username).getTeacherid());
    }

    public Examways findById(int teacherid,int examwaysid){
        return examwaysDao.findAllByTeacheridAndAndExamwaysid(teacherid, examwaysid);
    }

    public List<Examways> findByTeacherid(int id){
        return examwaysDao.findAllByTeacherid(id);
    }

    public Examways getById(int id){
        return examwaysDao.findById(id).orElse(new Examways(-1,-1,-1,-1,-1,-1,"null"));
    }

    public Examways addExamways(Examways examways){
        return examwaysDao.save(examways);
    }

    public Examways deleteById(int id){
        Examways examways = getById(id);
        if(examways.getExamwaysid() > -1){
            examwaysDao.deleteById(id);
        }
        return examways;
    }
}
