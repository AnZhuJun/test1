package test1.test1.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.bean.Course;

public interface CourseDao extends JpaRepository<Course,Integer> {
    Page<Course> findAll(Pageable pageable);
}
