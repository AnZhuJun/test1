package test1.test1.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.bean.ExamScoreWays;

import java.util.List;

public interface ExamScoreWaysDao extends JpaRepository<ExamScoreWays,Integer> {
    List<ExamScoreWays> findAllByTeacherid(int id);
    Page<ExamScoreWays> findAllByTeacherid(Pageable pageable, int id);
}
