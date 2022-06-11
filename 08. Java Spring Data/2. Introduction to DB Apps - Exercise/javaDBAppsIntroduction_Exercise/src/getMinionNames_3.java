import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class getMinionNames_3 {
    public static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";
    public static final String DB_NAME = "minions_DB";
    public static Connection connection;

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        connection = getConnection(scanner);
        System.out.println("Enter villain ID:");
        int villainId = Integer.parseInt(scanner.nextLine());

        try {
            String villainName = findEntityById("villains", villainId);
        }catch (Exception e) {
            System.out.println("No villain with ID 10 exists in the database.");
            return;
        }

        String villainName = findEntityById("villains", villainId);
        System.out.println("Villain: " + villainName);
        Set<String> allMinisByVillainId = getAllMinisByVillainId(villainId);
        allMinisByVillainId.forEach(System.out::print);
    }

    private static Set<String> getAllMinisByVillainId(int villainId) throws SQLException {
        Set<String> result = new LinkedHashSet<>();
        PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT m.name, m.age FROM minions  m " +
                        "JOIN minions_villains mv on m.id = mv.minion_id " +
                        "WHERE mv.villain_id = ?; ");
        preparedStatement.setInt(1,villainId);
        ResultSet resultSet = preparedStatement.executeQuery();
        int counter = 0;
        while (resultSet.next()){
            result.add(String.format("%d. %s %d %n",
                    ++counter,
                    resultSet.getString("name"),
                    resultSet.getInt("age")));
        }
        return result;
    }

    private static String findEntityById(String tableName, int entityID) throws SQLException {
        String query = String.format("SELECT name FROM %s WHERE id = ?", tableName);
        PreparedStatement preparedStatement = connection
                .prepareStatement(query);
        preparedStatement.setInt(1, entityID);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return  resultSet.getString(1);
    }

    private static String findVillainNameById(int villainId) throws SQLException {
        PreparedStatement preparedStatement = connection.
                prepareStatement("SELECT  name FROM villains WHERE id = ?;");
        preparedStatement.setInt(1, villainId);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getString("name");
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

