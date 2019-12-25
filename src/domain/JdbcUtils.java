package domain;

/**
 * @Author: zero
 * @Date: 2019/12/23 10:23
 */
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static Properties properties = null;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            InputStream inputStream = JdbcUtils.class.getResourceAsStream("dbconfig.properties");
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }

    public static Connection getConnection() throws SQLException{

        return DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"),
                properties.getProperty("password"));

    }
}
