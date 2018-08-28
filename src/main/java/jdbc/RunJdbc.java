package jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RunJdbc {

    Logger logger = LoggerFactory.getLogger(RunJdbc.class.getName());

    public static void main(String[] args) {

        String query = "SELECT * FROM user WHERE id < 3";

        DataBaseConnector dataBaseConnector = new DataBaseConnector();

        try (Statement statement = dataBaseConnector.getConnection().createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("password"),
                        resultSet.getInt("age"),
                        resultSet.getString("email")
                );
                System.out.println(user.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
