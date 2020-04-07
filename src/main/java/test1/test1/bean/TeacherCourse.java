package test1.test1.bean;

import javax.persistence.*;

@Entity
@Table(name = "teachercourse")
public class TeacherCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tcid;

    @Column
    private int teacherid;

    @Column
    private int courseid;

    public TeacherCourse() {
    }

    public int getTcid() {
        return tcid;
    }

    public void setTcid(int tcid) {
        this.tcid = tcid;
    }

    public int getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public TeacherCourse(int tcid, int teacherid, int courseid) {
        this.tcid = tcid;
        this.teacherid = teacherid;
        this.courseid = courseid;
    }
}
