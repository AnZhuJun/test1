package test1.test1.bean;

import javax.persistence.*;

@Entity
@Table(name = "psscoreave")
public class PsScoreAve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int psavid;

    @Column
    private int courseid;

    @Column
    private int averange;

    @Column
    private int teacherid;

    @Column
    private int classid;

    public int getPsavid() {
        return psavid;
    }

    public void setPsavid(int psavid) {
        this.psavid = psavid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
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

    public PsScoreAve() {
    }

    public PsScoreAve(int psavid, int courseid, int averange, int aimid, int classid) {
        this.psavid = psavid;
        this.courseid = courseid;
        this.averange = averange;
        this.teacherid = aimid;
        this.classid = classid;
    }
}
