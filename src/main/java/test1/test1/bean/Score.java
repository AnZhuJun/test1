//package test1.test1.bean;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "score")
//public class Score {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    int scoreid;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "course_id")
//    Course course;
//
//    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "student_id")
//    Student student;
//
//}
