package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private Database database;
    private static final Integer[] NUMBERS = {5, 8, 20, 67, 98};

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    @Test
    public void testConstructorHasToCreateObject() {
        Integer[] databaseElement = database.getElements();
        Assert.assertEquals("Count of element in incorrect", databaseElement.length, NUMBERS.length);
        for (int i = 0; i < databaseElement.length; i++) {
            Assert.assertEquals(NUMBERS[i], databaseElement[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenUseThanMoreSixTeenElement() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenLessThanOneElement() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldTrowWhenParameterIsNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddParameter() throws OperationNotSupportedException {
        //NUMBERS = {5, 8, 20, 67, 98}; -> 5 element
        int element = 13;
        database.add(element);
        //NUMBERS = {5, 8, 20, 67, 98, 13}; -> 5 element
        Assert.assertEquals(database.getElements().length, 6);
        Assert.assertEquals(database.getElements()[5], Integer.valueOf(13));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldTrowWithEmptyData() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testRemoveLastElement() throws OperationNotSupportedException {
        //{5, 8, 20, 67, 98};
        database.remove();
        //{5, 8, 20, 67};
        Assert.assertEquals(database.getElements().length, NUMBERS.length - 1);
        Assert.assertEquals(database.getElements()[3],Integer.valueOf(67));

    }


}