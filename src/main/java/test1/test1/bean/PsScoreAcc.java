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
    private int aimid;

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

    public int getAimid() {
        return aimid;
    }

    public void setAimid(int aimid) {
        this.aimid = aimid;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public PsScoreAcc() {
    }

    public PsScoreAcc(int psaid, int courseid, int score, int aimid, int classid) {
        this.psaid = psaid;
        this.courseid = courseid;
        this.score = score;
        this.aimid = aimid;
        this.classid = classid;
    }
}
