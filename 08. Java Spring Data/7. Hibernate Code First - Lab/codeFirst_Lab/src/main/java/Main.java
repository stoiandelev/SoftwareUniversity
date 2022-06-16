import entities.shampoo.BasicLabel;
import entities.shampoo.BasicShampoo;
import entities.shampoo.ProductionBatch;
import entities.vehicle.Bike;
import entities.vehicle.Car;
import entities.vehicle.Truck;

import javax.persistence.Basic;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("PU_name");

        EntityManager  entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        ProductionBatch batch = new ProductionBatch(LocalDate.now());
        BasicLabel label = new BasicLabel("red");
        BasicShampoo shampoo  = new BasicShampoo("shower", label, batch);

        entityManager.persist(batch);
        entityManager.persist(label);
        entityManager.persist(shampoo);

        ProductionBatch batch1 = entityManager.find(ProductionBatch.class, 1);
        System.out.println(batch1);


        entityManager.getTransaction().commit();
    }
}
