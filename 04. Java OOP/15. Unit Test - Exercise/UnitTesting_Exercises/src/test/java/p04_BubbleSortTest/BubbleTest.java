package p04_BubbleSortTest;


import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {

    @Test
    public void testSort() {
        int[] numbers = {3, 15, 43, 2, 45};
        Bubble.sort(numbers);

        int[] expectedSortedArray = {2, 3, 15, 43, 45};

        Assert.assertEquals(numbers.length, expectedSortedArray.length);
        Assert.assertArrayEquals(numbers, expectedSortedArray);

    }

}