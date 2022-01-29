package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpaceshipTests {


    Astronaut astronaut = new Astronaut("Marian", 100);
    Spaceship spaceship = new Spaceship("Stoyan", 100);

    @Test
    public void testName() {
        Spaceship spaceship = new Spaceship("Stoyan", 1);
        Astronaut astronaut = new Astronaut("Marian", 100);
        Assert.assertEquals(1, spaceship.getCapacity());
        Assert.assertEquals("Marian", astronaut.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldFell() {
        Astronaut astronaut = new Astronaut("Marian", 100);
        Astronaut astronaut1 = new Astronaut("Marian1", 100);
        Spaceship spaceship = new Spaceship("Stoyan", 1);
        spaceship.add(astronaut);
        spaceship.add(astronaut1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldFellExistName() {
        Astronaut astronaut = new Astronaut("Marian", 100);
        Astronaut astronaut1 = new Astronaut("Marian", 100);
        Spaceship spaceship = new Spaceship("Stoyan", 10);
        spaceship.add(astronaut);
        spaceship.add(astronaut1);
    }

    @Test
    public void testAddShouldADD() {
        Astronaut astronaut = new Astronaut("Marian", 100);
        Spaceship spaceship = new Spaceship("Stoyan", 1);
        spaceship.add(astronaut);
        Assert.assertEquals(1, spaceship.getCapacity());
    }

    @Test
    public void testREMOVEShouldWORD() {
        Astronaut astronaut = new Astronaut("Marian", 100);
        Spaceship spaceship = new Spaceship("Stoyan", 1);
        spaceship.add(astronaut);
        spaceship.remove("Marian");
        Assert.assertEquals(0, spaceship.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldFellCapacity() {
        Astronaut astronaut = new Astronaut("Marian", 100);
        Spaceship spaceship = new Spaceship("Stoyan", -1);
        spaceship.add(astronaut);

    }

    @Test(expected = NullPointerException.class)
    public void testAddShouldFellName() {
        Astronaut astronaut = new Astronaut("Stoyan", 100);
        Spaceship spaceship = new Spaceship(null, 0);
        spaceship.add(astronaut);

    }

    @Test(expected = NullPointerException.class)
    public void testAddShouldFellNameISEMPTY() {
        Astronaut astronaut = new Astronaut("Stoyan", 100);
        Spaceship spaceship = new Spaceship("  ", 0);
        spaceship.add(astronaut);

    }

    @Test
    public void testShouldWORKGETNAME() {
        Astronaut astronaut = new Astronaut("Marian", 100);
        Spaceship spaceship = new Spaceship("Stoyan", 1);
        spaceship.add(astronaut);
        String expectedName = "Marian";
        Assert.assertEquals(expectedName, astronaut.getName());
    }

    @Test
    public void testShouldWORKGETNAMESpaceship() {
        Astronaut astronaut = new Astronaut("Marian", 100);
        Spaceship spaceship = new Spaceship("Stoyan", 1);
        spaceship.add(astronaut);
        String expectedName = "Stoyan";
        Assert.assertEquals(expectedName, spaceship.getName());
    }


}
