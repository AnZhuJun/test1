package test1.test1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.bean.Paper;

import java.util.List;

public interface PaperDao extends JpaRepository<Paper,Integer> {
    List<Paper> findAllByUsername(String username);
}
