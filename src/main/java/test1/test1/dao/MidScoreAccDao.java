package test1.test1.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.bean.MidScoreAcc;
import test1.test1.bean.PsScoreAcc;

import java.util.List;

public interface MidScoreAccDao extends JpaRepository<MidScoreAcc,Integer> {
    List<MidScoreAcc> findAllByTeacherid(int id);
    Page<MidScoreAcc> findAllByTeacherid(Pageable pageable, int id);

    List<MidScoreAcc> findAllByTeacheridAndCourseid(int teacherid,int courseid);
}
