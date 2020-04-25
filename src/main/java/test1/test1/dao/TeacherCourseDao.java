package test1.test1.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.bean.TeacherCourse;

public interface TeacherCourseDao extends JpaRepository<TeacherCourse,Integer> {
    Page<TeacherCourse> findAll(Pageable pageable);
}
