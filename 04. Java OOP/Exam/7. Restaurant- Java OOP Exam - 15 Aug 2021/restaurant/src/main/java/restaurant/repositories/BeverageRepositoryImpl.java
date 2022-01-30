package restaurant.repositories;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.repositories.interfaces.BeverageRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class BeverageRepositoryImpl implements BeverageRepository<Beverages> {

    private Map<String, Beverages> entities;

    public BeverageRepositoryImpl() {
        this.entities = new LinkedHashMap<>();
    }

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        return entities.get(drinkName + ", " + drinkBrand);
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return Collections.unmodifiableCollection(entities.values());
    }

    @Override
    public void add(Beverages entity) {
        this.entities.put(entity.getName() + ", " + entity.getBrand(), entity);
    }
}
