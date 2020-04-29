package test1.test1.bean;

import javax.persistence.*;

@Entity
@Table(name = "outline")
public class Outline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int outlineid;

    @Column
    private String address;

    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOutlineid() {
        return outlineid;
    }

    public void setOutlineid(int outlineid) {
        this.outlineid = outlineid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Outline() {
    }

    public Outline(int outlineid, String address) {
        this.outlineid = outlineid;
        this.address = address;
    }
}
