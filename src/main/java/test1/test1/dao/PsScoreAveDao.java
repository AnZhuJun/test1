package test1.test1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.bean.PsScoreAcc;
import test1.test1.bean.PsScoreAve;

import java.util.List;

public interface PsScoreAveDao extends JpaRepository<PsScoreAve,Integer> {
    List<PsScoreAve> findAllByTeacherid(int id);
}
