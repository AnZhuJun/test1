package test1.test1.dao;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.bean.TeacherCourse;

import java.util.List;

public interface TeacherCourseDao extends JpaRepository<TeacherCourse,Integer> {
    Page<TeacherCourse> findAll(Pageable pageable);

    Page<TeacherCourse> findAllByTeacherid(Pageable pageable,int teacherid);

    List<TeacherCourse> findAllByTeacherid(int teacherid);

    TeacherCourse findAllByTeacheridAndCourseid(int teacherid,int courseid);
}
