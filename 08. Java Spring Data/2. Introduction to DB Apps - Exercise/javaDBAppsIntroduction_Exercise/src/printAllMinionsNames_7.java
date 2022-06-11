import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class printAllMinionsNames_7 {
    public static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";
    public static final String DB_NAME = "minions_DB";
    public static Connection connection;

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        connection = getConnection(scanner);

        PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT name FROM minions");
        ResultSet resultSet = preparedStatement.executeQuery();

        List<String> allMinionsNames = new ArrayList<>();
        while (resultSet.next()){
            String names = resultSet.getString("name");
            allMinionsNames.add(names);
        }

        int start = 0;
        int end = allMinionsNames.size() - 1;

        for (int i = 0; i < allMinionsNames.size(); i++) {
            System.out.println(i % 2 == 0
                    ? allMinionsNames.get(start ++)
                    : allMinionsNames.get(end --));
        }

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

