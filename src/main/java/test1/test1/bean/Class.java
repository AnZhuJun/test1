package test1.test1.bean;

import javax.persistence.*;

@Entity
@Table(name = "class")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int classid;

    @Column
    private String classname;

    @Column
    private String department;

    public Class() {
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Class(int classid, String classname, String department) {
        this.classid = classid;
        this.classname = classname;
        this.department = department;
    }
}
