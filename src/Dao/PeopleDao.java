package Dao;

import domain.JdbcUtils;
import domain.People;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * @Author: zero
 * @Date: 2019/12/24 10:50
 */
public class PeopleDao {
    public int createPeopleTable(String tableName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getConnection();
            //创建新表

            String createNewTable = "CREATE TABLE "+tableName+" (\n" +
                    "id INT AUTO_INCREMENT NOT NULL,\n" +
                    "name VARCHAR (11)  NOT NULL,\n" +
                    "grade  CHAR (11),\n" +
                    "gender CHAR (11),\n" +
                    "tele CHAR (11) NOT NULL ,\n" +
                    "createTime datetime,\n" +
                    "PRIMARY KEY (id)\n" +
                    ")";

            preparedStatement = connection.prepareStatement(createNewTable);
            preparedStatement.executeUpdate();
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

    public ArrayList<People> searchPeopleTable(String tableName, String condition) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        condition = "%" + condition + "%";
        ArrayList<People> peopleArrayList = new ArrayList<>();
        try {
            connection = JdbcUtils.getConnection();
            String sqlCmd = "SELECT *  FROM "+tableName+" WHERE id LIKE ? OR name LIKE ? OR gender LIKE ? OR grade LIKE ? OR" +
                    " " +
                    "createTime" +
                    " LIKE ?  OR tele LIKE ?";
            preparedStatement = connection.prepareStatement(sqlCmd);
            preparedStatement.setString(1, condition);
            preparedStatement.setString(2, condition);
            preparedStatement.setString(3, condition);
            preparedStatement.setString(4, condition);
            preparedStatement.setString(5, condition);
            preparedStatement.setString(6, condition);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                People people = new People();
                people.setId(resultSet.getInt("id"));
//                people.setCreateTime(resultSet.getString("createTime"));
                people.setCreateTime(resultSet.getTimestamp("createTime"));
                people.setGender(resultSet.getString("gender"));
                people.setName(resultSet.getString("name"));
                people.setTele(resultSet.getString("tele"));
                people.setGrade(resultSet.getString("grade"));
                peopleArrayList.add(people);
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

        return peopleArrayList;
    }


    public int insertPeople(String tableName, People people) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getConnection();
            String sqlCmd = "INSERT INTO "+tableName+" (name,gender,grade,tele,createTime) VALUES (?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sqlCmd);
            preparedStatement.setString(1, people.getName());
            preparedStatement.setString(2, people.getGender());
            preparedStatement.setString(3, people.getGrade());
            preparedStatement.setString(4, people.getTele());
            preparedStatement.setTimestamp(5, people.getCreateTime());

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


    public int deletePeople(String tableName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getConnection();
            String sqlCmd = "DELETE FROM subject WHERE name= ?";
            preparedStatement = connection.prepareStatement(sqlCmd);
            preparedStatement.setString(1, tableName);
            preparedStatement.executeUpdate();
            //删除表
            String deleteTable = "DROP TABLE " + tableName;
            preparedStatement = connection.prepareStatement(deleteTable);
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

}
