package test1.test1.bean;

import javax.persistence.*;

@Entity
@Table(name = "psscoreacc")
public class PsScoreAcc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int psaid;

    @Column
    private int courseid;

    @Column
    private int score;

    @Column
    private int teacherid;

    @Column
    private int classid;

    public int getPsaid() {
        return psaid;
    }

    public void setPsaid(int psaid) {
        this.psaid = psaid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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

    public PsScoreAcc() {
    }

    public PsScoreAcc(int psaid, int courseid, int score, int teacherid, int classid) {
        this.psaid = psaid;
        this.courseid = courseid;
        this.score = score;
        this.teacherid = teacherid;
        this.classid = classid;
    }
}
