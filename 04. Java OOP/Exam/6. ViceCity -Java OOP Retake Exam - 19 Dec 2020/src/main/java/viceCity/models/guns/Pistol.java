package viceCity.models.guns;

public class Pistol extends BaseGun {
    private static final int INITIAL_BULLETS_PER_BARREL = 10;
    private static final int TOTAL_BULLETS = 100;


    public Pistol(String name) {
        super(name, INITIAL_BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        if (getBulletsPerBarrel() == 0 && getTotalBullets() > 0) {
            reload();
        }
        if (getBulletsPerBarrel() > 0) {
            setBulletsPerBarrel(getBulletsPerBarrel() - 1);
        }
        return 1;
    }

    private void reload() {
        setTotalBullets(getTotalBullets() - INITIAL_BULLETS_PER_BARREL);
        setBulletsPerBarrel(INITIAL_BULLETS_PER_BARREL);
    }
}
