package test1.test1.bean;

import javax.persistence.*;

@Entity
@Table(name = "midscoreave")
public class MidScoreAve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int msavid;

    @Column
    private int courseid;

    @Column
    private int dt;

    @Column
    private int xt;

    @Column
    private int averange;

    @Column
    private int teacherid;

    @Column
    private int classid;

    public int getMsavid() {
        return msavid;
    }

    public void setMsavid(int msaid) {
        this.msavid = msaid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public int getXt() {
        return xt;
    }

    public void setXt(int xt) {
        this.xt = xt;
    }

    public int getAverange() {
        return averange;
    }

    public void setAverange(int averange) {
        this.averange = averange;
    }

    public int getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public MidScoreAve() {
    }

    public MidScoreAve(int msavid, int courseid, int dt, int xt, int averange, int teacherid, int classid) {
        this.msavid = msavid;
        this.courseid = courseid;
        this.dt = dt;
        this.xt = xt;
        this.averange = averange;
        this.teacherid = teacherid;
        this.classid = classid;
    }
}
