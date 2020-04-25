package test1.test1.service;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import test1.test1.bean.Student;
import test1.test1.dao.StudentDao;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentDao studentDao;

    public List<Student> findAll(){
        return studentDao.findAll();
    }

    public Page<Student> findAll(Pageable pageable){
        return studentDao.findAll(pageable);
    }

    public Student getById(int id){
        return studentDao.findById(id).orElse(new Student(-1,"null","null","null"));
    }

    public Student addStudent(Student student){
        return studentDao.save(student);
    }

    public Student deleteById(int id){
        Student student = getById(id);
        if (student.getStudentid() > -1) {
            studentDao.deleteById(id);
        }
        return student;
    }
}
