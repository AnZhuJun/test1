package test1.test1.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.bean.Analyse;

import java.util.List;

public interface AnalyseDao extends JpaRepository<Analyse,Integer> {
    Page<Analyse> findAllByTeacherid(Pageable pageable,int teacherid);

    List<Analyse> findAllByTeacherid(int teacherid);

    Analyse findAllByTeacheridAndCourseidAndClassidAndYearAndTerm(int teacherid,int courseid,int classid,String year,String term);
}
