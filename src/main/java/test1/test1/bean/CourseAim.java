package test1.test1.bean;

import javax.persistence.*;

@Entity
@Table(name = "courseaim")
public class CourseAim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aimid;

    @Column(name = "teacherid")
    private int teacherid;

    @Column(name = "courseid")
    private int courseid;

    @Column
    private String aim;

    @Column
    private String zbpoint;


    public CourseAim(int aimid, int teacherid, int courseid, String aim,String zbpoint) {
        this.zbpoint = zbpoint;
        this.aimid = aimid;
        this.teacherid = teacherid;
        this.courseid = courseid;
        this.aim = aim;
    }

    public String getZbpoint() {
        return zbpoint;
    }

    public void setZbpoint(String zbpoint) {
        this.zbpoint = zbpoint;
    }

    public int getAimid() {
        return aimid;
    }

    public void setAimid(int aimid) {
        this.aimid = aimid;
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

    public String getAim() {
        return aim;
    }

    public void setAim(String aim) {
        this.aim = aim;
    }

    public CourseAim() {
    }

    public CourseAim(int teacherid, int courseid, String aim) {
        this.teacherid = teacherid;
        this.courseid = courseid;
        this.aim = aim;
    }
}
