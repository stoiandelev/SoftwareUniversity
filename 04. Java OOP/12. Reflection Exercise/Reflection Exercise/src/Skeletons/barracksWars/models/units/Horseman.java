package Skeletons.barracksWars.models.units;

public class Horseman extends AbstractUnit {
    private static final int HORSEMAN_HEALTH = 50;
    private static final int HORSE_DAMAGE = 10;

    public Horseman() {
        super(HORSEMAN_HEALTH, HORSE_DAMAGE);
    }
}
