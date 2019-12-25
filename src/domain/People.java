package domain;

import java.sql.Timestamp;

/**
 * @Author: zero
 * @Date: 2019/12/25 9:20
 */
public class People {
    private int id;
    private String name;
    private String gender;
    private String grade;
    private String tele;
    private Timestamp createTime;

    public People(String name, String gender, String grade, String tele, Timestamp createTime) {
        this.name = name;
        this.gender = gender;
        this.grade = grade;
        this.tele = tele;
        this.createTime = createTime;
    }

    public People() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", grade='" + grade + '\'' +
                ", tele='" + tele + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
