package CounterStriker.models.guns;

public class Pistol extends GunImpl {
    public static final int BULLETS_ТО_SHOOT = 1;

    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (super.getBulletsCount() < BULLETS_ТО_SHOOT) {
            return 0;
        }
        super.decreaseBullets(BULLETS_ТО_SHOOT);
        return BULLETS_ТО_SHOOT;
    }
}
