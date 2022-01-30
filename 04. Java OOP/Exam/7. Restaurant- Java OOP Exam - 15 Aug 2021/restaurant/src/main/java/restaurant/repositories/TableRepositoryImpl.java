package restaurant.repositories;

import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.TableRepository;

import java.util.*;

public class TableRepositoryImpl implements TableRepository<Table> {

    private Map<Integer, Table> entities;

    public TableRepositoryImpl() {
        this.entities = new LinkedHashMap<>();
    }


    @Override
    public Table byNumber(int number) {
        return entities.get(number);
    }

    @Override
    public Collection<Table> getAllEntities() {
        return Collections.unmodifiableCollection(entities.values());
    }

    @Override
    public void add(Table entity) {
        entities.put(entity.getTableNumber(), entity);
    }
}
