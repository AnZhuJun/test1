package test1.test1.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.parameters.P;
import test1.test1.bean.PsScore;
import test1.test1.bean.PsScoreAcc;

import java.util.List;

public interface PsScoreDao extends JpaRepository<PsScore,Integer> {
    List<PsScore> findAllByTeacherid(int id);
    Page<PsScore> findAllByTeacherid(Pageable pageable, int id);

    List<PsScore> findAllByTeacheridAndName(int teacherid,String name);
}
