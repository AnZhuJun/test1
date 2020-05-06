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


    @Column
    private String coursename;

    @Column
    private int point;

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

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

    public TeacherCourse(int tcid, int teacherid, int courseid,String coursename,int point) {
        this.coursename = coursename;
        this.point = point;
        this.tcid = tcid;
        this.teacherid = teacherid;
        this.courseid = courseid;
    }
}
