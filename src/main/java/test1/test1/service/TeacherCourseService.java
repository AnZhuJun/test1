package test1.test1.service;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import test1.test1.bean.Student;
import test1.test1.bean.TeacherCourse;
import test1.test1.dao.CourseDao;
import test1.test1.dao.TeacherCourseDao;
import test1.test1.dao.TeacherDao;

import java.util.List;

@Service
public class TeacherCourseService {
    @Autowired
    TeacherCourseDao teacherCourseDao;

    @Autowired
    CourseDao courseDao;

    @Autowired
    TeacherDao teacherDao;
    public List<TeacherCourse> findAll(){
        return teacherCourseDao.findAll();
    }

    public List<TeacherCourse> findAllByTeacherid(int teacherid){
        return teacherCourseDao.findAllByTeacherid(teacherid);
    }

    public Page<TeacherCourse> findAll(Pageable pageable){
        return teacherCourseDao.findAll(pageable);
    }

    public Page<TeacherCourse> findById(Pageable pageable,String usename){

        return teacherCourseDao.findAllByTeacherid(pageable,teacherDao.findByUsername(usename).getTeacherid());
    }

    public TeacherCourse getById(int id){
        return teacherCourseDao.findById(id).orElse(new TeacherCourse(-1,-1,-1,"null",-1));
    }

    public TeacherCourse addTeacherCourse(TeacherCourse teacherCourse){
        teacherCourse.setCoursename(courseDao.findByCourseid(teacherCourse.getCourseid()).getCoursename());
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
