package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class HeroRepositoryTests {


    @Before
    public void setUp() {
        Hero hero = new Hero("Stoyan", 10);
        HeroRepository data = new HeroRepository();
    }

    @Test
    public void testGetCount() {
        Hero hero = new Hero("Stoyan", 10);
        HeroRepository data = new HeroRepository();
        data.create(hero);
        int expectedResult = 1;
        Assert.assertEquals(1, data.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testHeroNull() {
        Hero hero = new Hero("Stoyan", 10);
        HeroRepository data = new HeroRepository();
        data.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHeroSameName() {
        Hero hero = new Hero("Stoyan", 10);
        Hero hero1 = new Hero("Stoyan", 10);
        HeroRepository data = new HeroRepository();
        data.create(hero);
        data.create(hero1);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveHeroInvalidName() {
        Hero hero = new Hero("Stoyan", 10);
        HeroRepository data = new HeroRepository();
        data.create(hero);
        data.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void testHeroRemoveInvalidName2() {
        Hero hero = new Hero("Stoyan", 10);
        HeroRepository data = new HeroRepository();
        data.create(hero);
        data.remove("  ");
    }

    @Test
    public void testHeroRemoveCorrect() {
        Hero hero = new Hero("Stoyan", 10);
        HeroRepository data = new HeroRepository();
        data.create(hero);
        Assert.assertEquals(1, data.getCount());
        data.remove("Stoyan");
        Assert.assertEquals(0, data.getCount());
    }

    @Test
    public void testGetHeroWithHighestLevel() {
        Hero hero = new Hero("Stoyan", 10);
        Hero hero1 = new Hero("Stoyan1", 12);
        HeroRepository data = new HeroRepository();
        data.create(hero);
        data.create(hero1);
        Assert.assertEquals(hero1, data.getHeroWithHighestLevel());
    }

    @Test
    public void testGetHero() {
        Hero hero = new Hero("Stoyan", 10);
        HeroRepository data = new HeroRepository();
        data.create(hero);
        Assert.assertEquals(hero, data.getHero("Stoyan"));
    }

    @Test
    public void testGetHeroCollection() {
        Hero hero = new Hero("Stoyan", 10);
        Hero hero1 = new Hero("Stoyan1", 10);
        HeroRepository data = new HeroRepository();
        Collection<Hero> heroCollection = new ArrayList<>();
        heroCollection.add(hero);
        heroCollection.add(hero1);
        data.create(hero);
        data.create(hero1);

        Assert.assertEquals(heroCollection.size(), data.getHeroes().size());
    }


}
