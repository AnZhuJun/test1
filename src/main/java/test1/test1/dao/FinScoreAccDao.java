package test1.test1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.bean.FinScoreAcc;

public interface FinScoreAccDao extends JpaRepository<FinScoreAcc,Integer> {
}
