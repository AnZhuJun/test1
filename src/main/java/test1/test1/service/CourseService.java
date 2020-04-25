package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import test1.test1.bean.Course;
import test1.test1.dao.CourseDao;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseDao courseDao;

    public List<Course> findAll(){
        return courseDao.findAll();
    }

    public Page<Course> findAll(Pageable pageable){
        return courseDao.findAll(pageable);
    }

    public Course getById(int id){
        return courseDao.findById(id).orElse(new Course(-1,"null"));
    }

    public Course addCourse(Course course){
        return courseDao.save(course);
    }

    public Course deleteById(int id){
        Course course = getById(id);
        if (course.getCourseid() > -1) {
            courseDao.deleteById(id);
        }
        return course;
    }
}
