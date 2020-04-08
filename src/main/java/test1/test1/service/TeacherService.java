package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import test1.test1.bean.Student;
import test1.test1.bean.Teacher;
import test1.test1.dao.RoleDao;
import test1.test1.dao.TeacherDao;

import java.util.HashSet;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherDao teacherDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RoleDao roleDao;

    public List<Teacher> findAll(){
        return teacherDao.findAllByTeacheridIsGreaterThan(2);
    }

    public Teacher getById(int id){
        return teacherDao.findById(id).orElse(new Teacher(-1,"null","null","null"));
    }

    public Teacher addTeacher(Teacher teacher){
        teacher.setPassword(bCryptPasswordEncoder.encode(teacher.getPassword()));
        teacher.setRoles(new HashSet<>(roleDao.findAll()));
        return teacherDao.save(teacher);
    }

    public Teacher deleteById(int id){
        Teacher teacher = getById(id);
        if (teacher.getTeacherid() > -1) {
            teacherDao.deleteById(id);
        }
        return teacher;
    }
}
