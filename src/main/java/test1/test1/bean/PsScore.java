package test1.test1.bean;

import javax.persistence.*;

@Entity
@Table(name = "psscore")
public class PsScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int psscoreid;

    @Column
    private String year;

    @Column
    private String term;

    @Column
    private String time;

    @Column
    private int classid;

    @Column
    private int studentid;

    @Column
    private int courseid;

    @Column
    private int teacherid;

    @Column
    private String name;

    @Column
    private int kaoqin;

    @Column
    private int zuoye;

    @Column
    private int shiyan;

    public int getPsscoreid() {
        return psscoreid;
    }

    public void setPsscoreid(int psscoreid) {
        this.psscoreid = psscoreid;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public int getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKaoqin() {
        return kaoqin;
    }

    public void setKaoqin(int kaoqin) {
        this.kaoqin = kaoqin;
    }

    public int getZuoye() {
        return zuoye;
    }

    public void setZuoye(int zuoye) {
        this.zuoye = zuoye;
    }

    public int getShiyan() {
        return shiyan;
    }

    public void setShiyan(int shiyan) {
        this.shiyan = shiyan;
    }

    public PsScore() {
    }

    public PsScore(int psscoreid, String year, String term, String time, int classid, int studentid, int courseid, int teacherid, String name, int kaoqin, int zuoye, int shiyan) {
        this.psscoreid = psscoreid;
        this.year = year;
        this.term = term;
        this.time = time;
        this.classid = classid;
        this.studentid = studentid;
        this.courseid = courseid;
        this.teacherid = teacherid;
        this.name = name;
        this.kaoqin = kaoqin;
        this.zuoye = zuoye;
        this.shiyan = shiyan;
    }
}
