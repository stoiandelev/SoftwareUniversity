package CounterStriker.models.guns;

public class Rifle extends GunImpl{
    public static final int BULLETS_ТО_SHOOT = 10;

    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        //ако са по малко от 10
        if (super.getBulletsCount() < BULLETS_ТО_SHOOT) {
            return 0;
        }
        super.decreaseBullets(BULLETS_ТО_SHOOT);
        return BULLETS_ТО_SHOOT;
    }
}
