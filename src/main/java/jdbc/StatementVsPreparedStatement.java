package jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Calendar;

public class StatementVsPreparedStatement {

    private static String INSERT_NEW_RECORD = "INSERT INTO dish VALUES (?,?,?,?,?,?,?)";
    private static String GET_ALL = "SELECT * FROM dish";
    private static String DELETE = "DELETE FROM dish WHERE id=?";

    public static void main(String[] args) {

        DataBaseConnector dataBaseConnector = new DataBaseConnector();
        try (Connection connection = dataBaseConnector .getConnection()) {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(INSERT_NEW_RECORD);

            //  CREATE
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "dish title 1");
            preparedStatement.setString(3, "dish description 1");
            preparedStatement.setFloat(4, 0.3f);
            preparedStatement.setBoolean(5, true);
            preparedStatement.setDate(6, new Date(Calendar.getInstance().getTimeInMillis()));
            preparedStatement.setBlob(7, new FileInputStream("Java-duke.jpg"));
            preparedStatement.execute();

            // READ
            preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                byte[] icon = resultSet.getBytes("icon");
                System.out.println(icon.length);
            }

            //  DELETE
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1,1);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
