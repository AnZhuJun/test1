package test1.test1.bean;

import javax.persistence.*;

@Entity
@Table(name = "finscoreacc")
public class FinScoreAcc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fsaid;

    @Column
    private int courseid;

    @Column
    private int dt;

    @Column
    private int xt;

    @Column
    private int score;

    @Column
    private int classid;

    @Column
    private int teacherid;

    public int getFsaid() {
        return fsaid;
    }

    public void setFsaid(int fsaid) {
        this.fsaid = fsaid;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public int getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
    }

    public FinScoreAcc() {
    }

    public FinScoreAcc(int fsaid, int courseid, int dt, int xt, int score, int teacherid, int classid) {
        this.fsaid = fsaid;
        this.courseid = courseid;
        this.dt = dt;
        this.xt = xt;
        this.score = score;
        this.teacherid = teacherid;
        this.classid = classid;
    }
}
