import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class removeVillain_6 {
    public static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";
    public static final String DB_NAME = "minions_DB";
    public static Connection connection;

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        connection = getConnection(scanner);

        System.out.println("Enter villain ID:");
        int villainId= Integer.parseInt(scanner.nextLine());

        PreparedStatement selectVillain = connection
                .prepareStatement("SELECT name FROM villains WHERE id = ? ");
        selectVillain.setInt(1, villainId);
        ResultSet villainSet = selectVillain.executeQuery();

        if(!villainSet.next()){
            System.out.println("No such villain was found");
            return;
        }

        String villainName = villainSet.getString("name");

        PreparedStatement selectAllVillainMinions = connection
                .prepareStatement("SELECT COUNT(DISTINCT minion_id) AS m_count " +
                        " FROM minions_villains WHERE villain_id = ? ");
        selectAllVillainMinions.setInt(1,villainId);
        ResultSet minionsSet = selectAllVillainMinions.executeQuery();
        minionsSet.next();
        int countMinionsDeleted = minionsSet.getInt("m_count");

        connection.setAutoCommit(false);
        try {
            PreparedStatement deleteMinionsVillains = connection
                    .prepareStatement("DELETE FROM minions_villains WHERE villain_id = ? ");
            deleteMinionsVillains.setInt(1, villainId);
            deleteMinionsVillains.executeUpdate();

            PreparedStatement deleteVillain = connection
                    .prepareStatement("DELETE FROM villains WHERE id = ? ");
            deleteVillain.setInt(1, villainId);
            deleteVillain.executeUpdate();



            connection.commit();
            System.out.println(villainName + " was deleted");
            System.out.println(countMinionsDeleted + " minions released");


        }catch (SQLException e) {
            connection.rollback();
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

