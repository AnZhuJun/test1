package test1.test1.bean;

import javax.persistence.*;

@Entity
@Table(name = "stuscore")
public class Stuscore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stuscoreid;

    @Column
    private int sscore;

    @Column
    private int classid;

    @Column
    private int studentid;

    @Column
    private int courseid;

    @Column
    private int teacherid;

    @Column
    private String year;

    @Column
    private String term;

    @Column
    private String stuname;

    @Column
    private String classname;

    @Column
    private String coursename;

    public Stuscore(int sscore, int classid, int studentid, int courseid, int teacherid, String year, String term,String stuname,String classname,String coursename) {
        this.coursename = coursename;
        this.classname = classname;
        this.stuname = stuname;
        this.sscore = sscore;
        this.classid = classid;
        this.studentid = studentid;
        this.courseid = courseid;
        this.teacherid = teacherid;
        this.year = year;
        this.term = term;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public int getStuscoreid() {
        return stuscoreid;
    }

    public void setStuscoreid(int stuscoreid) {
        this.stuscoreid = stuscoreid;
    }

    public int getSscore() {
        return sscore;
    }

    public void setSscore(int sscore) {
        this.sscore = sscore;
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

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public Stuscore() {
    }

    public Stuscore(int stuscoreid, int sscore, int classid, int studentid, int courseid, int teacherid, String year, String term,String stuname) {
        this.stuname = stuname;
        this.stuscoreid = stuscoreid;
        this.sscore = sscore;
        this.classid = classid;
        this.studentid = studentid;
        this.courseid = courseid;
        this.teacherid = teacherid;
        this.year = year;
        this.term = term;
    }
}
