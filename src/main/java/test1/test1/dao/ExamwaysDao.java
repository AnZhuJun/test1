package test1.test1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.bean.Examways;

import java.util.List;

public interface ExamwaysDao extends JpaRepository<Examways,Integer> {
    List<Examways> findAllByTeacherid(int id);
}
