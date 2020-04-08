package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test1.test1.bean.CourseAim;
import test1.test1.dao.CourseAimDao;
import test1.test1.dao.TeacherDao;

import java.util.List;

@Service
public class CourseAimService {
    @Autowired
    CourseAimDao courseAimDao;

    @Autowired
    TeacherDao teacherDao;

    public List<CourseAim> findAll(String id){
        return courseAimDao.findAllByTeacherid(teacherDao.findByUsername(id).getTeacherid());
    }

    public List<CourseAim> findByTeacherid(int id){
        return courseAimDao.findAllByTeacherid(id);
    }

    public CourseAim getById(int id){
        return courseAimDao.findById(id).orElse(new CourseAim(-1,-1,-1,"null"));
    }

    public CourseAim addAim(CourseAim courseAim){
        return courseAimDao.save(courseAim);
    }

    public CourseAim deleteById(int id){
        CourseAim courseAim = getById(id);
        if (courseAim.getAimid() > -1) {
            courseAimDao.deleteById(id);
        }
        return courseAim;
    }

}
