package test1.test1.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.bean.PsScoreAcc;
import test1.test1.bean.PsScoreAve;

import java.util.List;

public interface PsScoreAveDao extends JpaRepository<PsScoreAve,Integer> {
    List<PsScoreAve> findAllByTeacherid(int id);
    Page<PsScoreAve> findAllByTeacherid(Pageable pageable, int id);

    List<PsScoreAve> findAllByTeacheridAndCourseid(int teacherid,int courseid);

    List<PsScoreAve> findAllByTeacheridAndCourseidAndClassid(int teacherid,int courseid,int classid);
}
