package CounterStriker.repositories;

import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;

import static CounterStriker.common.ExceptionMessages.INVALID_GUN_NAME;
import static CounterStriker.common.ExceptionMessages.INVALID_PLAYER_REPOSITORY;

public class PlayerRepository<T extends Player> implements Repository<T> {
    Collection<T> models;

    public PlayerRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<T> getModels() {
        return models;
    }

    @Override
    public void add(T model) {
        if (model == null) {
            throw new NullPointerException(INVALID_PLAYER_REPOSITORY);
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
        return this.models.stream().filter(m -> m.getUsername().equals(name)).findFirst().orElse(null);
    }
}
