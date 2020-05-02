package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test1.test1.bean.Analyse;
import test1.test1.bean.Course;
import test1.test1.bean.Examways;
import test1.test1.dao.*;

@Service
public class AnalyseService {
    @Autowired
    AnalyseDao analyseDao;

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    CourseDao courseDao;

    @Autowired
    CourseAimDao courseAimDao;

    @Autowired
    ClassDao classDao;

    @Autowired
    ExamwaysDao examwaysDao;

    public Analyse create(Analyse analyse){

        return analyseDao.save(analyse);
    }
}
