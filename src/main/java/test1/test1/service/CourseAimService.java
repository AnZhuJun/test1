package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test1.test1.bean.CourseAim;
import test1.test1.dao.CourseAimDao;

import java.util.List;

@Service
public class CourseAimService {
    @Autowired
    CourseAimDao courseAimDao;

    public List<CourseAim> findAll(){
        return courseAimDao.findAll();
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
