package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBaseConnector {
    private final String MYSQL_DB_URL = "jdbc:mysql://localhost:3306/jdbc_db?" +
            "useUnicode=true&" +
            "useJDBCCompliantTimezoneShift=true&" +
            "useLegacyDatetimeCode=false&serverTimezone=UTC&" +
            "autoReconnect=true&" +
            "useSSL=false";
    private final String USER = "root";
    private final String PASSWORD = "root";

    private Connection connection;

    public DataBaseConnector() {
        try {
            this.connection = DriverManager.getConnection(MYSQL_DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
