import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * LinearSearch1Test.java
 * Illustrates JUnit tests for the LinearSearch1 class.
 */
public class LinearSearch1Test {

    /** Test case for the search method. */
    @Test
    public void testSearch1() {
        int[] a = {2, 4, 6, 8, 10};
        int target = 6;
        int expected = 2;
        int actual = LinearSearch1.search(a, target);
        assertEquals(expected, actual);
    }

    /** Test case for the search method. */
    @Test
    public void testSearch2() {
        int[] a = {2, 4, 6, 8, 10};
        int target = 2;
        int expected = 0;
        int actual = LinearSearch1.search(a, target);
        assertEquals(expected, actual);
    }

    /** Test case for the search method. */
    @Test
    public void testSearch3() {
        int[] a = {2, 4, 6, 8, 10};
        int target = 10;
        int expected = 4;
        int actual = LinearSearch1.search(a, target);
        assertEquals(expected, actual);
    }
    
    /** Test case for the search method. */
    @Test
    public void testSearch4() {
        int[] a = {2, 4, 6, 8, 10};
        int target = 7;
        int expected = -1;
        int actual = LinearSearch1.search(a, target);
        assertEquals(expected, actual);
    }

}