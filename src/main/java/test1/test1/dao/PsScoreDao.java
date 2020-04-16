package test1.test1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.bean.PsScore;

import java.util.List;

public interface PsScoreDao extends JpaRepository<PsScore,Integer> {
    List<PsScore> findAllByTeacherid(int id);
}
