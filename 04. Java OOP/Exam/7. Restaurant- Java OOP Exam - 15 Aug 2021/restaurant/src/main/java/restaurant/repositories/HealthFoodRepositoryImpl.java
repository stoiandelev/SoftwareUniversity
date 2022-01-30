package restaurant.repositories;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.repositories.interfaces.HealthFoodRepository;

import java.util.*;

public class HealthFoodRepositoryImpl implements HealthFoodRepository<HealthyFood> {

    private Map<String, HealthyFood> entities;

    public HealthFoodRepositoryImpl() {
        this.entities = new LinkedHashMap<>();
    }


    @Override
    public HealthyFood foodByName(String name) {
        return this.entities.get(name);
    }

    @Override
    public Collection<HealthyFood> getAllEntities() {
        return Collections.unmodifiableCollection(entities.values());
    }

    @Override
    public void add(HealthyFood entity) {
        entities.put(entity.getName(), entity);
    }
}
