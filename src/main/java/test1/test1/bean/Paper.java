package test1.test1.bean;

import javax.persistence.*;

@Entity
@Table(name = "paper")
public class Paper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paperid;

    @Column
    private int courseid;

    @Column
    private int dt;

    @Column
    private int xt;

    @Column
    private int scores;

    @Column
    private int classid;

    @Column(name = "username")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Paper(int courseid, int dt, int xt, int scores, int classid, String username) {
        this.courseid = courseid;
        this.dt = dt;
        this.xt = xt;
        this.scores = scores;
        this.classid = classid;
        this.username = username;
    }

    public Paper(int paperid, int courseid, int dt, int xt, int scores, int classid, String username) {
        this.paperid = paperid;
        this.courseid = courseid;
        this.dt = dt;
        this.xt = xt;
        this.scores = scores;
        this.classid = classid;
        this.username = username;
    }

    public int getPaperid() {
        return paperid;
    }

    public void setPaperid(int paperid) {
        this.paperid = paperid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public int getXt() {
        return xt;
    }

    public void setXt(int xt) {
        this.xt = xt;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public Paper() {
    }


}
