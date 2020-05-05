package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import test1.test1.bean.CourseAim;
import test1.test1.bean.MidScore;
import test1.test1.dao.CourseAimDao;
import test1.test1.dao.TeacherDao;

import java.util.List;

@Service
public class CourseAimService {
    @Autowired
    CourseAimDao courseAimDao;

    @Autowired
    TeacherDao teacherDao;

    public Page<CourseAim> findAllByUsername(Pageable pageable,String username){
        return courseAimDao.findAllByTeacherid(pageable,teacherDao.findByUsername(username).getTeacherid());
    }

    public List<CourseAim> findById(int teacherid, int courseid){
        return courseAimDao.findAllByTeacheridAndCourseid(teacherid, courseid);
    }

    public List<CourseAim> findAll(String id){
        return courseAimDao.findAllByTeacherid(teacherDao.findByUsername(id).getTeacherid());
    }

    public CourseAim findByTCid(int teacherid,int courseid){
        return courseAimDao.findByTeacheridAndCourseid(teacherid, courseid);
    }

    public List<CourseAim> findByTeacherid(int id){
        return courseAimDao.findAllByTeacherid(id);
    }

    public CourseAim getById(int id){
        return courseAimDao.findById(id).orElse(new CourseAim(-1,-1,-1,"null","null"));
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
