package test1.test1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.bean.Teacher;

import java.util.List;

public interface TeacherDao extends JpaRepository<Teacher,Integer> {
    List<Teacher> findAllByTeachername(String name);
    Teacher findByUsername(String name);
    List<Teacher> findAllByTeacheridIsGreaterThan(int greate);
}
