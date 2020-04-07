package test1.test1.bean;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int courseid;

    @Column
    private String coursename;

//    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
//    Set<Score> scores;

    public Course() {
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public Course(int courseid, String coursename) {
        this.courseid = courseid;
        this.coursename = coursename;
    }
}
