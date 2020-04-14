package test1.test1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.bean.MidScoreAcc;

import java.util.List;

public interface MidScoreAccDao extends JpaRepository<MidScoreAcc,Integer> {
    List<MidScoreAcc> findAllByTeacherid(int id);
}
