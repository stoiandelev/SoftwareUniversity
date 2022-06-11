import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class increaseAgeStoredProcedure_9 {
    public static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";
    public static final String DB_NAME = "minions_DB";
    public static Connection connection;

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        connection = getConnection(scanner);
        System.out.println("Enter minion Id: ");
        int id = Integer.parseInt(scanner.nextLine());

        CallableStatement callableStatement = connection
                .prepareCall("CALL usp_get_older(?)");
        callableStatement.setInt(1, id);
        callableStatement.executeUpdate();
    }

    private static Connection getConnection(Scanner scanner) throws SQLException {
        System.out.println("Enter user:");
        String user = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);
        return DriverManager
                .getConnection(CONNECTION_STRING + DB_NAME, properties);
    }
}

