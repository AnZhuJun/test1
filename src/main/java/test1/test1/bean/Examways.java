package test1.test1.bean;

import javax.persistence.*;

@Entity
@Table(name = "examways")
public class Examways {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int examwaysid;

    @Column(name = "teacherid")
    private int teacherid;

    @Column(name = "courseid")
    private int courseid;

    @Column
    private int aimid;

    @Column
    private int psper;

    @Column
    private int midper;

    @Column
    private int finper;

    @Column
    private String orderpoint;

    public int getExamwaysid() {
        return examwaysid;
    }

    public void setExamwaysid(int examwaysid) {
        this.examwaysid = examwaysid;
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

    public int getAimid() {
        return aimid;
    }

    public void setAimid(int aimid) {
        this.aimid = aimid;
    }

    public int getPsper() {
        return psper;
    }

    public void setPsper(int psper) {
        this.psper = psper;
    }

    public int getMidper() {
        return midper;
    }

    public void setMidper(int midper) {
        this.midper = midper;
    }

    public int getFinper() {
        return finper;
    }

    public void setFinper(int finper) {
        this.finper = finper;
    }

    public String getOrderpoint() {
        return orderpoint;
    }

    public void setOrderpoint(String orderpoint) {
        this.orderpoint = orderpoint;
    }

    public Examways() {
    }

    public Examways(int examwaysid, int teacherid, int courseid, int aimid, int psper, int midper, int finper, String orderponit) {
        this.examwaysid = examwaysid;
        this.teacherid = teacherid;
        this.courseid = courseid;
        this.aimid = aimid;
        this.psper = psper;
        this.midper = midper;
        this.finper = finper;
        this.orderpoint = orderponit;
    }
}
