package test1.test1.bean;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherid;

    @Column
    private String teachername;

    @Column
    private String username;

    @Column
    private String password;



    public Teacher(int teacherid, String teachername, String username, String password) {
        this.teacherid = teacherid;
        this.teachername = teachername;
        this.username = username;
        this.password = password;
    }

    @ManyToMany
    private Set<Role> roles;

    public Teacher(int teacherid,String teachername, String username, String password, Set<Role> roles) {
        this.teacherid = teacherid;
        this.teachername = teachername;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public int getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Teacher() {
    }

    public Teacher(String teachername, String username, String password) {
        this.teachername = teachername;
        this.username = username;
        this.password = password;
    }
}
