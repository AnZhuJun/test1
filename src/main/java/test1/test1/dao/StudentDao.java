package test1.test1.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.bean.Student;

public interface StudentDao extends JpaRepository<Student,Integer> {
    Page<Student> findAll(Pageable pageable);
}
