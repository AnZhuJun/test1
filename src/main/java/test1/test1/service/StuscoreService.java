package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import test1.test1.bean.Stuscore;
import test1.test1.dao.*;

import java.util.List;

@Service
public class StuscoreService {
    @Autowired
    StuscoreDao stuscoreDao;

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    StudentDao studentDao;

    @Autowired
    ClassDao classDao;

    @Autowired
    CourseDao courseDao;

    public Page<Stuscore> findAllByUsername(Pageable pageable, String username){
        return stuscoreDao.findAllByTeacherid(pageable,teacherDao.findByUsername(username).getTeacherid());
    }

    public List<Stuscore> findById(int teacherid,int studentid){
        return stuscoreDao.findAllByTeacheridAndStudentid(teacherid, studentid);
    }

    public List<Stuscore> findByTeacherid(int id){
        return stuscoreDao.findAllByTeacherid(id);
    }

    public Stuscore getById(int id){
        return stuscoreDao.findById(id).orElse(new Stuscore(-1,-1,-1,-1,-1,"null","null","null","null","null"));
    }

    public Stuscore addStuscore(Stuscore stuscore){
        int stuid = stuscore.getStudentid();
        stuscore.setClassname(studentDao.findAllByStudentid(stuid).getClasss());
        stuscore.setStuname(studentDao.findAllByStudentid(stuid).getName());
        stuscore.setClassid(classDao.findAllByClassname(studentDao.findAllByStudentid(stuid).getClasss()).getClassid());
        stuscore.setCoursename(courseDao.findByCourseid(stuscore.getCourseid()).getCoursename());
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
