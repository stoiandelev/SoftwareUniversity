import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class addMinion_4 {
    public static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";
    public static final String DB_NAME = "minions_DB";

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Connection connection = getConnection(scanner);

        //start from index 1
        String[] minionInfo = scanner.nextLine().split(" ");
        String minionName = minionInfo[1];
        int minionAge = Integer.parseInt(minionInfo[2]);
        String minionTown = minionInfo[3];
        String villainName = scanner.nextLine().split(" ")[1];

        int townId = getOrInsertTown(connection, minionTown);
        int villainId = getOrInsertVillain(connection, villainName);
        insertMinions(connection, minionName, minionAge, villainName, townId, villainId);

    }

    private static void insertMinions(Connection connection, String minionName, int minionAge, String villainName, int townId, int villainId) throws SQLException {
        PreparedStatement insertMinion = connection
                .prepareStatement("INSERT INTO minions(name, age, town_id) VALUES (?, ?, ?) ");
        insertMinion.setString(1, minionName);
        insertMinion.setInt(2, minionAge);
        insertMinion.setInt(3, townId);
        insertMinion.executeUpdate();

        PreparedStatement getLastMinion = connection
                .prepareStatement("SELECT id FROM minions ORDER BY id DESC ");
        ResultSet lastMinionSet = getLastMinion.executeQuery();
        lastMinionSet.next();
        int lastMinionId = lastMinionSet.getInt("id");

        PreparedStatement insertMinionsVillains = connection
                .prepareStatement("INSERT INTO minions_villains VALUES (?, ?)");
        insertMinionsVillains.setInt(1, lastMinionId);
        insertMinionsVillains.setInt(2, villainId);
        insertMinionsVillains.executeUpdate();


        System.out.printf("Successfully added %s to be minion of %s.%n", minionName, villainName);
    }

    private static int getOrInsertVillain(Connection connection, String villainName) throws SQLException {
        PreparedStatement selectVillain = connection
                .prepareStatement("SELECT id FROM villains WHERE name = ? ");
        selectVillain.setString(1, villainName);
        ResultSet villainSet = selectVillain.executeQuery();

        int villainId = 0;
        if (!villainSet.next()) {
            PreparedStatement insertVillain = connection
                    .prepareStatement("INSERT INTO villains(name, evilness_factor) VALUES (?, ?)");
            insertVillain.setString(1, villainName);
            insertVillain.setString(2, "evil");

            insertVillain.executeUpdate();

            ResultSet newVillainSet = selectVillain.executeQuery();
            newVillainSet.next();

            villainId = newVillainSet.getInt("id");
            System.out.printf("Villain %s was added to the database.%n", villainName);
        } else {
            villainId = villainSet.getInt("id");
        }
        return villainId;
    }

    private static int getOrInsertTown(Connection connection, String minionTown) throws SQLException {
        PreparedStatement selectTown = connection
                .prepareStatement("SELECT id FROM towns WHERE name = ? ");
        selectTown.setString(1, minionTown);
        ResultSet townSet = selectTown.executeQuery();
        int townId = 0;
        if (!townSet.next()) {
            PreparedStatement insertTown = connection
                    .prepareStatement("INSERT INTO towns(name) VALUES (?);");
            insertTown.setString(1, minionTown);
            insertTown.executeUpdate();

            ResultSet newTownSet = selectTown.executeQuery();
            newTownSet.next();
            townId = newTownSet.getInt("id");
            System.out.printf("Town %s was added to the database.%n", minionTown);
        } else {
            townId = townSet.getInt("id");
        }
        return townId;
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


