package test1.test1.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.bean.Examways;

import java.util.List;

public interface ExamwaysDao extends JpaRepository<Examways,Integer> {
    List<Examways> findAllByTeacherid(int id);
    Page<Examways> findAllByTeacherid(Pageable pageable, int id);
    Examways findAllByTeacheridAndAndExamwaysid(int teacherid,int examwaysid);

    Examways findByCourseid(int courseid);
}
