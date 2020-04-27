package test1.test1.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.bean.MidScoreAve;
import test1.test1.bean.PsScoreAcc;

import java.util.List;

public interface MidScoreAveDao extends JpaRepository<MidScoreAve,Integer> {
    List<MidScoreAve> findAllByTeacherid(int id);
    Page<MidScoreAve> findAllByTeacherid(Pageable pageable, int id);

    List<MidScoreAve> findAllByTeacheridAndCourseid(int teacherid,int courseid);
}
