import java.sql.*;
import java.util.*;

public class changeTownNamesCasing_5 {
    public static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";
    public static final String DB_NAME = "minions_DB";
    public static Connection connection;

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        connection = getConnection(scanner);

        System.out.println("Enter country name:");
        String countryName = scanner.nextLine();
        PreparedStatement preparedStatement = connection
                .prepareStatement("UPDATE towns SET name = UPPER(name) WHERE country = ? ");
        preparedStatement.setString(1, countryName);

        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows == 0) {
            System.out.println("No town names were affected.");
            return;
        }
        System.out.printf("%d town names were affected.%n", affectedRows);

        PreparedStatement preparedStatementTowns = connection
                .prepareStatement("SELECT name FROM towns WHERE country = ?");
        preparedStatementTowns.setString(1, countryName);
        ResultSet resultSet = preparedStatementTowns.executeQuery();
        List<String> towns = new ArrayList<>();
        while (resultSet.next()) {
            String townsName = resultSet.getString("name");
            towns.add(townsName);
        }
        System.out.print("[");
        String result = String.join(", ", towns);
        System.out.print(result);
        System.out.println("]");
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



