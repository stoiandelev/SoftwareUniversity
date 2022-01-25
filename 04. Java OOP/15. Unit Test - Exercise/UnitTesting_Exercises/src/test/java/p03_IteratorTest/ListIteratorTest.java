package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {

    private ListIterator listIterator;
    private static final String[] data = {"Stoian", "Pesho", "Gosho"};

    @Before
    public void setUp() throws OperationNotSupportedException {
        listIterator = new ListIterator(data);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenLessThanOneElement() throws OperationNotSupportedException {
        String[] element = null;
        listIterator = new ListIterator(null);
    }

    @Test
    public void testHasNextAndMove() {
        //{"Stoian", "Pesho", "Gosho"};
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assert.assertFalse(listIterator.hasNext());
        Assert.assertFalse(listIterator.move());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintEmptyList() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void testPrintCorrectly() throws OperationNotSupportedException {
        int index = 0;
        while (listIterator.hasNext()) {
            Assert.assertEquals(listIterator.print(), data[index]);
            index++;
            listIterator.move();
        }
    }


}