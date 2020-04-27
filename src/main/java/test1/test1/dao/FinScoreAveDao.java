package test1.test1.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.bean.FinScoreAve;
import test1.test1.bean.PsScoreAcc;

import java.util.List;

public interface FinScoreAveDao extends JpaRepository<FinScoreAve,Integer> {
    List<FinScoreAve> findAllByTeacherid(int id);
    Page<FinScoreAve> findAllByTeacherid(Pageable pageable, int id);

    List<FinScoreAve> findAllByTeacheridAndCourseid(int teacherid,int courseid);
}
