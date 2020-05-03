package test1.test1.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.bean.Class;

public interface ClassDao extends JpaRepository<Class,Integer> {
    Page<Class> findAll(Pageable pageable);

    Class findByClassid(int id);

    Class findAllByClassname(String name);
}
