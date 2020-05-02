package test1.test1.bean;

import javax.persistence.*;

@Entity
@Table(name = "analyse")
public class Analyse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int analyseid;

    @Column
    private int courseid;

    @Column
    private int teacherid;

    @Column
    private int classid;

    @Column
    private int aimid;

    @Column
    private int examwaysid;

    @Column
    private String zbpoint;

    //达成度
    @Column
    private int achidegree;

    @Column
    private int sumbest;

    @Column
    private int sumgood;

    @Column
    private int sumsoso;

    @Column
    private int sumworse;

    @Column
    private int sumselect;

    //学分
    @Column
    private int point;

    @Column
    private String problem;

    @Column
    private String comment;

    @Column
    private String analy;

    @Column
    private String teachername;

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public Analyse(int courseid, int teacherid, int classid, int aimid, int examwaysid, String zbpoint, int achidegree, int sumbest, int sumgood, int sumsoso, int sumworse, int sumselect, int point, String problem, String comment, String analy, String teachername) {
        this.courseid = courseid;
        this.teacherid = teacherid;
        this.classid = classid;
        this.aimid = aimid;
        this.examwaysid = examwaysid;
        this.zbpoint = zbpoint;
        this.achidegree = achidegree;
        this.sumbest = sumbest;
        this.sumgood = sumgood;
        this.sumsoso = sumsoso;
        this.sumworse = sumworse;
        this.sumselect = sumselect;
        this.point = point;
        this.problem = problem;
        this.comment = comment;
        this.analy = analy;
        this.teachername = teachername;
    }

    public int getAnalyseid() {
        return analyseid;
    }

    public void setAnalyseid(int analyseid) {
        this.analyseid = analyseid;
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

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public int getAimid() {
        return aimid;
    }

    public void setAimid(int aimid) {
        this.aimid = aimid;
    }

    public int getExamwaysid() {
        return examwaysid;
    }

    public void setExamwaysid(int examwaysid) {
        this.examwaysid = examwaysid;
    }

    public String getZbpoint() {
        return zbpoint;
    }

    public void setZbpoint(String zbpoint) {
        this.zbpoint = zbpoint;
    }

    public int getAchidegree() {
        return achidegree;
    }

    public void setAchidegree(int achidegree) {
        this.achidegree = achidegree;
    }

    public int getSumbest() {
        return sumbest;
    }

    public void setSumbest(int sumbest) {
        this.sumbest = sumbest;
    }

    public int getSumgood() {
        return sumgood;
    }

    public void setSumgood(int sumgood) {
        this.sumgood = sumgood;
    }

    public int getSumsoso() {
        return sumsoso;
    }

    public void setSumsoso(int sumsoso) {
        this.sumsoso = sumsoso;
    }

    public int getSumworse() {
        return sumworse;
    }

    public void setSumworse(int sumworse) {
        this.sumworse = sumworse;
    }

    public int getSumselect() {
        return sumselect;
    }

    public void setSumselect(int sumselect) {
        this.sumselect = sumselect;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAnaly() {
        return analy;
    }

    public void setAnaly(String analy) {
        this.analy = analy;
    }

    public Analyse() {
    }

    public Analyse(int analyseid, int courseid, int teacherid, int classid, int aimid, int examwaysid, String zbpoint, int achidegree, int sumbest, int sumgood, int sumsoso, int sumworse, int sumselect, int point, String problem, String comment, String analy,String teachername) {
        this.teachername = teachername;
        this.analyseid =analyseid;
        this.courseid = courseid;
        this.teacherid = teacherid;
        this.classid = classid;
        this.aimid = aimid;
        this.examwaysid = examwaysid;
        this.zbpoint = zbpoint;
        this.achidegree = achidegree;
        this.sumbest = sumbest;
        this.sumgood = sumgood;
        this.sumsoso = sumsoso;
        this.sumworse = sumworse;
        this.sumselect = sumselect;
        this.point = point;
        this.problem = problem;
        this.comment = comment;
        this.analy = analy;
    }
}
