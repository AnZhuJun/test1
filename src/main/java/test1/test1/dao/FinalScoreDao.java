package test1.test1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.bean.FinalScore;

import java.util.List;

public interface FinalScoreDao extends JpaRepository<FinalScore,Integer> {
    List<FinalScore> findAllByTeacherid(int id);
}
