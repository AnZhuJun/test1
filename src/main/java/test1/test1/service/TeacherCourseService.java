package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test1.test1.bean.Student;
import test1.test1.bean.TeacherCourse;
import test1.test1.dao.TeacherCourseDao;

import java.util.List;

@Service
public class TeacherCourseService {
    @Autowired
    TeacherCourseDao teacherCourseDao;

    public List<TeacherCourse> findAll(){
        return teacherCourseDao.findAll();
    }

    public TeacherCourse getById(int id){
        return teacherCourseDao.findById(id).orElse(new TeacherCourse(-1,-1,-1));
    }

    public TeacherCourse addTeacherCourse(TeacherCourse teacherCourse){
        return teacherCourseDao.save(teacherCourse);
    }

    public TeacherCourse deleteById(int id){
        TeacherCourse teacherCourse = getById(id);
        if (teacherCourse.getTcid() > -1) {
            teacherCourseDao.deleteById(id);
        }
        return teacherCourse;
    }
}
