package test1.test1.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.bean.FinScoreAcc;
import test1.test1.bean.PsScoreAcc;

import java.util.List;

public interface FinScoreAccDao extends JpaRepository<FinScoreAcc,Integer> {
    List<FinScoreAcc> findAllByTeacherid(int id);
    Page<FinScoreAcc> findAllByTeacherid(Pageable pageable, int id);

    List<FinScoreAcc> findAllByTeacheridAndCourseid(int teacherid,int courseid);
}
