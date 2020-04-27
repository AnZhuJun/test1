package test1.test1.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.bean.MidScore;
import test1.test1.bean.PsScoreAcc;

import java.util.List;

public interface MidScoreDao extends JpaRepository<MidScore,Integer> {
    List<MidScore> findAllByTeacherid(int id);
    Page<MidScore> findAllByTeacherid(Pageable pageable, int id);

    List<MidScore> findAllByTeacheridAndName(int teacherid,String name);
}
