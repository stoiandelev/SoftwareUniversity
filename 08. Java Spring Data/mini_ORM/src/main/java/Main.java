import entity.Address;
import entity.User;
import orm.EntityManager;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import static orm.MyConnector.*;

public class Main {

    public static void main(String[] args) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {

        createConnection("root", "12345678", "custom_orm");
        Connection connection = getConnection();

        EntityManager<User> userEntityManager = new EntityManager<>(connection);

        //create new table
        EntityManager<Address> addressEntityManager = new EntityManager<>(connection);
        addressEntityManager.doCreate(Address.class);


        User user = new User("stoian", 33, LocalDate.now());
        user.setUsername("Angel Dodov");

//        userEntityManager.doCreate(User.class);
//        userEntityManager.doAlter(User.class);
        userEntityManager.persist(user);

        Iterable<User> first = userEntityManager.find(User.class);
        System.out.println(first.toString());

        User toDelete = userEntityManager.findFirst(User.class, "id > 3");
        System.out.println(toDelete);

        userEntityManager.delete(toDelete);

        Iterable<User> second = userEntityManager.find(User.class);
        System.out.println(second.toString());
    }
}
