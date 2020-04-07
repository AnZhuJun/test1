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
    private int score;

    @Column
    private int aimid;

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

    public PsScoreAve() {
    }

    public PsScoreAve(int psavid, int courseid, int score, int aimid, int classid) {
        this.psavid = psavid;
        this.courseid = courseid;
        this.score = score;
        this.aimid = aimid;
        this.classid = classid;
    }
}
