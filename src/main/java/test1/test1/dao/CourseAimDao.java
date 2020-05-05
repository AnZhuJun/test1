package test1.test1.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.bean.CourseAim;

import java.util.List;

public interface CourseAimDao extends JpaRepository<CourseAim,Integer> {
    List<CourseAim> findAllByTeacherid(int id);

    Page<CourseAim> findAllByTeacherid(Pageable pageable,int teacherid);
    List<CourseAim> findAllByTeacheridAndCourseid(int teacherid,int courseid);

    CourseAim findByTeacheridAndCourseid(int teacherid,int courseid);
}
