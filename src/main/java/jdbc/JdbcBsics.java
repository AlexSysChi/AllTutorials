package jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;


public class JdbcBsics {

    //private static Logger logger = Logger.getLogger(JdbcBsics.class.getName());
    private static Logger logger = LoggerFactory.getLogger(JdbcBsics.class.getName());
    // http://www.mkyong.com/logging/log4j-log4j-properties-examples/
    //https://stackoverflow.com/questions/12532339/no-appenders-could-be-found-for-loggerlog4j

    public static final String URL = "jdbc:mysql://localhost:3306/jdbc_db?" +
            "useUnicode=true&" +
            "useJDBCCompliantTimezoneShift=true&" +
            "useLegacyDatetimeCode=false&serverTimezone=UTC&" +
            "autoReconnect=true&" +
            "useSSL=false";
    public static final String USER = "root";
    public static final String PASSWORD = "root";

    public static final String INSERT_IN_USER_TABLE =
            //"INSERT INTO User (name, password, age, email) VALUES ('%s', %s, '%d', '%s')";
    "INSERT INTO User(id, name, password, age, email) VALUES (null, '%s', '%s', %d, '%s')";

    public static void main(String[] args) {
//        BasicConfigurator.configure(); - replacement log4j.properties
        try {
            logger.info("try to register driver");
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            logger.error("Driver registry is failed ");
            e.printStackTrace();
        }
        logger.info("driver successfully registered ");
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            statement.execute(String.format(INSERT_IN_USER_TABLE,
                   "user_4", "password_4", 20, "address4@mail.ru"));

            // batch processing
            statement.addBatch(String.format(INSERT_IN_USER_TABLE,
                    "batch_user_1", "b_password_1", 20, "address1@mail.ru"));
            statement.addBatch(String.format(INSERT_IN_USER_TABLE,
                    "batch_user_2", "b_password_2", 20, "address2@mail.ru"));
            statement.addBatch(String.format(INSERT_IN_USER_TABLE,
                    "batch_user_3", "b_password_3", 20, "address3@mail.ru"));

            //  if we need to clear batch
            //statement.clearBatch();
            statement.executeBatch();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");

            statement.executeUpdate("UPDATE user SET password='password_5' WHERE id=5");

            statement.execute("DELETE FROM user WHERE user.name='user_4'");

            logger.warn("connection is closed: " + statement.isClosed());

            // below code redundant because of we use try with resources
            statement.close();
            logger.warn("connection is closed: " + statement.isClosed());

        } catch (SQLException e) {

            e.printStackTrace();
        }



    }
}
