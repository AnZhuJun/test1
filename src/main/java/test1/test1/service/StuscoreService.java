package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import test1.test1.bean.Stuscore;
import test1.test1.dao.StudentDao;
import test1.test1.dao.StuscoreDao;
import test1.test1.dao.TeacherDao;

import java.util.List;

@Service
public class StuscoreService {
    @Autowired
    StuscoreDao stuscoreDao;

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    StudentDao studentDao;

    public Page<Stuscore> findAllByUsername(Pageable pageable, String username){
        return stuscoreDao.findAllByTeacherid(pageable,teacherDao.findByUsername(username).getTeacherid());
    }

    public Stuscore findById(int teacherid,int studentid){
        return stuscoreDao.findAllByTeacheridAndStudentid(teacherid, studentid);
    }

    public List<Stuscore> findByTeacherid(int id){
        return stuscoreDao.findAllByTeacherid(id);
    }

    public Stuscore getById(int id){
        return stuscoreDao.findById(id).orElse(new Stuscore(-1,-1,-1,-1,-1,"null","null","null"));
    }

    public Stuscore addStuscore(Stuscore stuscore){
        int stuid = stuscore.getStudentid();
        stuscore.setStuname(studentDao.findAllByStudentid(stuid).getName());
        return stuscoreDao.save(stuscore);
    }

    public Stuscore deleteById(int id){
        Stuscore stuscore = getById(id);
        if(stuscore.getStuscoreid() > -1){
            stuscoreDao.deleteById(id);
        }
        return stuscore;
    }
}
