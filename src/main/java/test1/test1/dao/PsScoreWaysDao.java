package test1.test1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.bean.PsScoreWays;

import java.util.List;

public interface PsScoreWaysDao extends JpaRepository<PsScoreWays,Integer> {
    List<PsScoreWays> findAllByTeacherid(int id);
}
