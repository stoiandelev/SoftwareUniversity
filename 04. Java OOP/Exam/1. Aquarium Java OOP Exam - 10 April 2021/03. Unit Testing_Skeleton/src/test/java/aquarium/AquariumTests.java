package aquarium;

import org.junit.Assert;
import org.junit.Test;

public class AquariumTests {

    @Test(expected = NullPointerException.class)
    public void testSetInvalidName() {
        Aquarium aquarium = new Aquarium(null, 10);
    }

    @Test
    public void testSetValidName() {
        Aquarium aquarium = new Aquarium("Stoian", 10);
        String expectedName = aquarium.getName();
        String actualName = "Stoian";
        Assert.assertEquals(expectedName, actualName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidCapacity() {
        Aquarium aquarium = new Aquarium("Stoian", -1);
    }

    @Test
    public void testSetValidCapacity() {
        Aquarium aquarium = new Aquarium("Stoian", 10);
        int expectedCapacity = aquarium.getCapacity();
        int actualCapacity = 10;
        Assert.assertEquals(expectedCapacity, actualCapacity);
    }

    @Test
    public void testSetValidAdd() {
        Aquarium aquarium = new Aquarium("Stoian", 10);
        aquarium.add(new Fish("Test_Fish"));
        Assert.assertEquals(1, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidCapacityShouldFell() {
        Aquarium aquarium = new Aquarium("Stoian", 0);
        aquarium.add(new Fish("testFish"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testersShouldFELLRemove() {
        Aquarium aquarium = new Aquarium("Stoian", 0);
        aquarium.remove("Marian");
    }

    @Test
    public void testValidRemove() {
        Aquarium aquarium = new Aquarium("Stoian", 10);
        aquarium.add(new Fish("Marian"));
        aquarium.remove("Marian");
        Assert.assertEquals(0, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidSell() {
        Aquarium aquarium = new Aquarium("Stoian", 0);
        aquarium.sellFish("Marian");
    }

    @Test
    public void testValidSell() {
        Aquarium aquarium = new Aquarium("Stoian", 10);
        Fish fish = new Fish("test_fish");
        aquarium.add(fish);
        aquarium.sellFish("test_fish");
        Assert.assertFalse(fish.isAvailable());
    }

    @Test
    public void testGetInfoReportValid() {
        Aquarium aquarium = new Aquarium("Stoian", 10);
        aquarium.add(new Fish("fish1"));
        aquarium.add(new Fish("fish2"));
        aquarium.add(new Fish("fish3"));
        String expected = "Fish available at Stoian: fish1, fish2, fish3";
        Assert.assertEquals(expected, aquarium.report());
    }


}

