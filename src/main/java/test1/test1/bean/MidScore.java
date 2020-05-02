package test1.test1.bean;

import javax.persistence.*;

@Entity
@Table(name = "midscore")
public class MidScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int midscoreid;

    @Column
    private String year;

    @Column
    private String term;

    @Column
    private String time;

    @Column
    private int studentid;

    @Column
    private int classid;

    @Column
    private int courseid;

    @Column
    private int teacherid;

    @Column
    private String name;

    @Column
    private int first;

    @Column
    private int second;

    @Column
    private int third;

    @Column
    private int fourth;

    public int getMidscoreid() {
        return midscoreid;
    }

    public void setMidscoreid(int midscoreid) {
        this.midscoreid = midscoreid;
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


    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
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

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getThird() {
        return third;
    }

    public void setThird(int third) {
        this.third = third;
    }

    public int getFourth() {
        return fourth;
    }

    public void setFourth(int fourth) {
        this.fourth = fourth;
    }

    public MidScore() {
    }

    public MidScore(int finalscoreid, String year, String term, String time, int studentid, int classid, int courseid, int teacherid, String name, int first, int second, int third, int fourth) {
        this.midscoreid = finalscoreid;
        this.year = year;
        this.term = term;
        this.time = time;
        this.studentid = studentid;
        this.classid = classid;
        this.courseid = courseid;
        this.teacherid = teacherid;
        this.name = name;
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }
}
