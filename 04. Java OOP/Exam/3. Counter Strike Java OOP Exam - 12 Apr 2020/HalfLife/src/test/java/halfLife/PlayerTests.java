package halfLife;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTests {

    @Test
    public void testConstructorCreateInstance() {
        Player player = new Player("Stoian", 100);
        Assert.assertNotNull(player);
    }

    @Test
    public void testGetUserName() {
        Player player = new Player("Stoian", 100);
        String actualName = player.getUsername();
        String expectedName = "Stoian";
        Assert.assertEquals(actualName, expectedName);
    }

    @Test(expected = NullPointerException.class)
    public void setUserNameInvalid() {
        Player player = new Player(null, 100);
    }

    @Test
    public void testGetHalt() {
        Player player = new Player("Stoian", 100);
        int actualHealth = player.getHealth();
        int expectedHealth = 100;
        Assert.assertEquals(actualHealth, expectedHealth);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidHeal() {
        Player player = new Player("Stoian", -100);
    }

    @Test
    public void testGetGuns() {
        Player player = new Player("Stoian", 100);
        int actualLength = player.getGuns().size();
        int expectedLength = 0;
        Assert.assertEquals(actualLength, expectedLength);
    }

    @Test(expected = IllegalStateException.class)
    public void testDamageBellowZero() {
        Player player = new Player("Stoian", 0);
        player.takeDamage(200);
    }

    @Test
    public void testDamage() {
        Player player = new Player("Stoian", 100);
        player.takeDamage(20);
        int expectedHealth = player.getHealth();
        int actualHealth = 80;
        Assert.assertEquals(actualHealth, expectedHealth);
    }

    @Test(expected = NullPointerException.class)
    public void addNullGun() {
        Player player = new Player("Stoian", 100);
        player.addGun(null);
    }

    @Test
    public void addGun() {
        Player player = new Player("Stoian", 100);
        Gun gun = new Gun("rifle", 100);
        player.addGun(gun);
        Gun expectedGun = gun;
        Gun actualGun = player.getGun(gun.getName());
        Assert.assertEquals(expectedGun, actualGun);
    }

    @Test
    public void removeGun() {
        Player player = new Player("Stoian", 100);
        Gun gun = new Gun("rifle", 100);
        player.addGun(gun);
        boolean actualResult = player.removeGun(gun);
        Assert.assertTrue(actualResult);
    }

    @Test
    public void getValidGun() {
        Player player = new Player("Stoian", 100);
        Gun gun = new Gun("rifle", 100);
        player.addGun(gun);
        Gun expectedGun = gun;
        Gun actualGun = player.getGun(gun.getName());
        Assert.assertEquals(expectedGun, actualGun);
    }
    @Test
    public void getInValidGun() {
        Player player = new Player("Stoian", 100);
        Gun gun = new Gun("rifle", 100);
        player.addGun(gun);
        Gun expectedGun = gun;
        Gun actualGun = player.getGun("M16");
        Assert.assertNotEquals(expectedGun, actualGun);
    }
}

