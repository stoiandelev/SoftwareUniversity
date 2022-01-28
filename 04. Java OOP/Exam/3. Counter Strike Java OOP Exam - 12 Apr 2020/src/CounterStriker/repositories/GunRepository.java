package CounterStriker.repositories;

import CounterStriker.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collection;

import static CounterStriker.common.ExceptionMessages.*;

public class GunRepository<T extends Gun> implements Repository<T> {
    Collection<T> models;

    public GunRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<T> getModels() {
        return models;
    }

    @Override
    public void add(T model) {
        if (model == null) {
            throw new NullPointerException(INVALID_GUN_REPOSITORY);
        }
        models.add(model);
    }

    @Override
    public boolean remove(T model) {
        return models.remove(model);
    }

    @Override
    public T findByName(String name) {
        // ако има такова има върни първото
        return this.models.stream().filter(m -> m.getName().equals(name)).findFirst().orElse(null);
    }
}
