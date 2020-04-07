package test1.test1.bean;

import javax.persistence.*;

@Entity
@Table(name = "examscoreways")
public class ExamScoreWays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scorewayid;

    @Column
    private int aimid;

    @Column
    private int teacherid;

    @Column
    private int courseid;

    @Column
    private String best;

    @Column
    private String good;

    @Column
    private String soso;

    @Column
    private String worse;

    public ExamScoreWays(int scorewayid, int aimid, int teacherid, int courseid, String best, String good, String soso, String worse) {
        this.scorewayid = scorewayid;
        this.aimid = aimid;
        this.teacherid = teacherid;
        this.courseid = courseid;
        this.best = best;
        this.good = good;
        this.soso = soso;
        this.worse = worse;
    }

    public int getScorewayid() {
        return scorewayid;
    }

    public void setScorewayid(int scorewayid) {
        this.scorewayid = scorewayid;
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

    public String getBest() {
        return best;
    }

    public void setBest(String best) {
        this.best = best;
    }

    public String getGood() {
        return good;
    }

    public void setGood(String good) {
        this.good = good;
    }

    public String getSoso() {
        return soso;
    }

    public void setSoso(String soso) {
        this.soso = soso;
    }

    public String getWorse() {
        return worse;
    }

    public void setWorse(String worse) {
        this.worse = worse;
    }

    public ExamScoreWays() {
    }

    public ExamScoreWays(int aimid, int teacherid, int courseid, String best, String good, String soso, String worse) {
        this.aimid = aimid;
        this.teacherid = teacherid;
        this.courseid = courseid;
        this.best = best;
        this.good = good;
        this.soso = soso;
        this.worse = worse;
    }
}
