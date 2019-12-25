package Dao;

import domain.People;
import domain.Subject;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: zero
 * @Date: 2019/12/23 17:18
 */
public class test {
    public static void main(String[] args) {
        PeopleDao peopleDao = new PeopleDao();
        String name = "彩蛋";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp currentTime=Timestamp.valueOf(dateFormat.format(new Date()));

        People people = new People("王", "男", "三", "15511176036", currentTime);
        System.out.println("ppp :" + people.toString());
        peopleDao.insertPeople(name, people);


        peopleDao.searchPeopleTable(name,"").forEach(s->{
            System.out.println(s.toString());
        });

//        peopleDao.deletePeople(name);


//        SubjectDao subjectDao = new SubjectDao();
//        subjectDao.createSubject("a12fa3");
//        subjectDao.searchSubject("").forEach(s->{
//            System.out.println( s.toString());
//        });
//        subjectDao.deleteSubject("123");
//        subjectDao.deleteSubject("a12fa3");
//        subjectDao.deleteSubject("12fa3");

    }
}
