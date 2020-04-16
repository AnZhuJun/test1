package test1.test1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.bean.FinScoreAve;

import java.util.List;

public interface FinScoreAveDao extends JpaRepository<FinScoreAve,Integer> {
    List<FinScoreAve> findAllByTeacherid(int id);
}
