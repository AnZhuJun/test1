package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import test1.test1.bean.Class;
import test1.test1.bean.Student;
import test1.test1.dao.ClassDao;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    ClassDao classDao;

    public List<Class> findAll(){
        return classDao.findAll();
    }

    public Page<Class> findAll(Pageable pageable){
        return classDao.findAll(pageable);
    }

    public Class findById(int id){
        return classDao.findByClassid(id);
    }

    public Class getById(int id){
        return classDao.findById(id).orElse(new Class(-1,"null","null"));
    }

    public Class addClass(Class classs){
        return classDao.save(classs);
    }

    public Class deleteById(int id){
        Class classs = getById(id);
        if (classs.getClassid() > -1) {
            classDao.deleteById(id);
        }
        return classs;

    }
}
