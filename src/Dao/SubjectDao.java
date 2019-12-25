package Dao;

import domain.JdbcUtils;
import domain.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Author: zero
 * @Date: 2019/12/23 10:26
 */
public class SubjectDao {
    public int createSubject(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String currentTime = dateFormat.format(new Date());
            connection = JdbcUtils.getConnection();
            String sqlCmd = "INSERT INTO subject VALUES(?,?)";
            preparedStatement = connection.prepareStatement(sqlCmd);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, currentTime);

            return preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return 0;
    }

    public boolean findSubjectName(String name) {
        AtomicBoolean returnBool = new AtomicBoolean(false);
        ArrayList<Subject> arrayList = searchSubject(name);
        arrayList.forEach(s -> {
            if (name.equals(s.getName())) {
                returnBool.set(true);
            }
        });
        return returnBool.get();
    }


    public ArrayList<Subject> searchSubject(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        name = "%" + name + "%";
        ArrayList<Subject> subjectArrayList = new ArrayList<>();
        try {
            connection = JdbcUtils.getConnection();
            String sqlCmd = "SELECT *  FROM subject WHERE name LIKE ? or time LIKE ?";
            preparedStatement = connection.prepareStatement(sqlCmd);
            preparedStatement.setString(2, name);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Subject subject = new Subject();
                subject.setName(resultSet.getString("name"));
                subject.setTime(resultSet.getString("time"));
                subjectArrayList.add(subject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return subjectArrayList;
    }




    public int deleteSubject(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        //去空格
        name = name.replace(" ", "");
        try {
            connection = JdbcUtils.getConnection();
            String sqlCmd = "DELETE FROM subject WHERE name= ?";
            preparedStatement = connection.prepareStatement(sqlCmd);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            //删除表
            String deleteTable = "DROP TABLE ?";
            preparedStatement = connection.prepareStatement(deleteTable);
            preparedStatement.setString(1, name);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
