//package test1.test1.bean;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "scoreways")
//public class ScoreWays {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int scorewayid;
//
//    @Column
//    private String courseways;
//
//    @Column
//    private int teacherid;
//
//    @Column
//    private int courseid;
//
//    @Column
//    private String best;
//
//    @Column
//    private String good;
//
//    @Column
//    private String soso;
//
//    @Column
//    private String worse;
//
//    public int getScorewayid() {
//        return scorewayid;
//    }
//
//    public void setScorewayid(int scorewayid) {
//        this.scorewayid = scorewayid;
//    }
//
//    public String getCourseways() {
//        return courseways;
//    }
//
//    public void setCourseways(String courseways) {
//        this.courseways = courseways;
//    }
//
//    public int getTeacherid() {
//        return teacherid;
//    }
//
//    public void setTeacherid(int teacherid) {
//        this.teacherid = teacherid;
//    }
//
//    public int getCourseid() {
//        return courseid;
//    }
//
//    public void setCourseid(int courseid) {
//        this.courseid = courseid;
//    }
//
//    public String getBest() {
//        return best;
//    }
//
//    public void setBest(String best) {
//        this.best = best;
//    }
//
//    public String getGood() {
//        return good;
//    }
//
//    public void setGood(String good) {
//        this.good = good;
//    }
//
//    public String getSoso() {
//        return soso;
//    }
//
//    public void setSoso(String soso) {
//        this.soso = soso;
//    }
//
//    public String getWorse() {
//        return worse;
//    }
//
//    public void setWorse(String worse) {
//        this.worse = worse;
//    }
//
//    public ScoreWays() {
//    }
//
//    public ScoreWays(int scorewayid, String courseways, int teacherid, int courseid, String best, String good, String soso, String worse) {
//        this.scorewayid = scorewayid;
//        this.courseways = courseways;
//        this.teacherid = teacherid;
//        this.courseid = courseid;
//        this.best = best;
//        this.good = good;
//        this.soso = soso;
//        this.worse = worse;
//    }
//}
