package test1.test1.bean;

import javax.persistence.*;

@Entity
@Table(name = "psscoreways")
public class PsScoreWays {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int psswid;

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

    public int getPsswid() {
        return psswid;
    }

    public void setPsswid(int psswid) {
        this.psswid = psswid;
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

    public PsScoreWays() {
    }

    public PsScoreWays(int psswid, int aimid, int teacherid, int courseid, String best, String good, String soso, String worse) {
        this.psswid = psswid;
        this.aimid = aimid;
        this.teacherid = teacherid;
        this.courseid = courseid;
        this.best = best;
        this.good = good;
        this.soso = soso;
        this.worse = worse;
    }
}
