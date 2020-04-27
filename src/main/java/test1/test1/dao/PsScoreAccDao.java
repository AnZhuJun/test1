package test1.test1.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.bean.PsScoreAcc;

import java.util.List;

public interface PsScoreAccDao extends JpaRepository<PsScoreAcc,Integer> {
//    List<PsScoreAcc> findAllByTeacherid(int id);
    List<PsScoreAcc> findByTeacherid(int id);
    Page<PsScoreAcc> findAllByTeacherid(Pageable pageable,int id);

    List<PsScoreAcc> findAllByTeacheridAndCourseid(int teacherid,int courseid);
}
