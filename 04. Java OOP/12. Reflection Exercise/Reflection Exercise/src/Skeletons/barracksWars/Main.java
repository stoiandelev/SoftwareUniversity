package Skeletons.barracksWars;

import Skeletons.barracksWars.core.Engine;
import Skeletons.barracksWars.core.factories.UnitFactoryImpl;
import Skeletons.barracksWars.data.UnitRepository;
import Skeletons.barracksWars.interfaces.Repository;
import Skeletons.barracksWars.interfaces.Runnable;
import Skeletons.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
