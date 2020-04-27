package test1.test1.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.bean.FinalScore;
import test1.test1.bean.PsScoreAcc;

import java.util.List;

public interface FinalScoreDao extends JpaRepository<FinalScore,Integer> {
    List<FinalScore> findAllByTeacherid(int id);
    Page<FinalScore> findAllByTeacherid(Pageable pageable, int id);

    List<FinalScore> findAllByTeacheridAndName(int teacherid,String name);
}
