package test1.test1.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.bean.Paper;
import test1.test1.bean.PsScoreAcc;

import java.util.List;

public interface PaperDao extends JpaRepository<Paper,Integer> {
    List<Paper> findAllByUsername(String username);
    Page<Paper> findAllByUsername(Pageable pageable,String username);

    List<Paper> findAllByUsernameAndCourseid(String username,int courseid);
}
