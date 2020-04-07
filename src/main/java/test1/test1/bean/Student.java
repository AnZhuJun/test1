package test1.test1.bean;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentid;

    @Column
    private String name;

    @Column(name = "class")
    private String classs;

    @Column
    private String department;

//    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
//    Set<Score> scores;

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Student(int id,String name, String classs, String department) {
        this.studentid = id;
        this.name = name;
        this.classs = classs;
        this.department = department;
    }

    public Student(){

    }
}
