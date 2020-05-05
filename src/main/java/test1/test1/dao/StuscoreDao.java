package test1.test1.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.bean.Examways;
import test1.test1.bean.Stuscore;

import java.util.List;

public interface StuscoreDao extends JpaRepository<Stuscore,Integer> {
    List<Stuscore> findAllByTeacherid(int id);
    Page<Stuscore> findAllByTeacherid(Pageable pageable, int id);
    List<Stuscore> findAllByTeacheridAndStudentid(int teacherid,int studentid);

    int countAllByCourseidAndClassidAndYearAndTermAndSscoreBetween(int courseid,int classid,String year,String term,int start,int end);
}
