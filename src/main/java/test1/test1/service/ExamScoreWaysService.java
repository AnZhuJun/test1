package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import test1.test1.bean.ExamScoreWays;
import test1.test1.bean.Examways;
import test1.test1.dao.ExamScoreWaysDao;
import test1.test1.dao.TeacherDao;

import java.util.List;

@Service
public class ExamScoreWaysService {
    @Autowired
    ExamScoreWaysDao examScoreWaysDao;

    @Autowired
    TeacherDao teacherDao;

    public Page<ExamScoreWays> findAllByUsername(Pageable pageable, String username){
        return examScoreWaysDao.findAllByTeacherid(pageable,teacherDao.findByUsername(username).getTeacherid());
    }

    public ExamScoreWays findById(int teacherid,int scorewayid){
        return examScoreWaysDao.findAllByTeacheridAndScorewayid(teacherid,scorewayid);
    }

    public List<ExamScoreWays> findByTeacherid(int id){
        return examScoreWaysDao.findAllByTeacherid(id);
    }

    public ExamScoreWays getById(int id){
        return examScoreWaysDao.findById(id).orElse(new ExamScoreWays(-1,-1,-1,"null","null","null","null"));
    }

    public ExamScoreWays addExamScoreWays(ExamScoreWays examScoreWays){
        return examScoreWaysDao.save(examScoreWays);
    }

    public ExamScoreWays deleteById(int id){
        ExamScoreWays examScoreWays = getById(id);
        if(examScoreWays.getScorewayid() > -1){
            examScoreWaysDao.deleteById(id);
        }
        return examScoreWays;
    }
}
