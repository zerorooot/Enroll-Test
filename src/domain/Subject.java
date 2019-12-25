package domain;

/**
 * @Author: zero
 * @Date: 2019/12/23 11:27
 */
public class Subject {
    private String name;
    private String time;
    Subject(String name, String time) {
       this.name=name;
        this.time = time;
    }

    public Subject() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
