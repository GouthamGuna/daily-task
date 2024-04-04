package in.dev.gmsk.hackerrank;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static in.dev.gmsk.hackerrank.Solutions.*;

class SolutionsTest {

    @Test
    void testCompareTriplets() {

        List<Integer> actual = compareTriplets(Arrays.asList(30, 20, 40), Arrays.asList(31, 51, 5));

        List<Integer> expected = Arrays.asList(1, 2);

        assertEquals(expected, actual);
    }

    @Test
    void testSearchInsert() {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        int expected = searchInsert(nums, target);
        int actual = 4;

        assertEquals(expected, actual);
    }

    @Disabled
    @Test
    void testAVeryBigSum() {
        long actual = aVeryBigSum(Arrays.asList(5, 1000000001, 1000000002, 1000000003, 1000000004, 1000000005));
        long expected = 00000015;

        assertEquals(expected, actual);
    }

    /**
     * test case 1 :  15 - 15 = 0
     * <p/>
     * test case 2 :  6 - 7 = 0
     * <p/>
     * test case 1 :  20 - 15 = 5
     * */

    @Test
    void diagonalDifferenceTest() {

        List<Integer> one = List.of(6,2,3);
        List<Integer> two = List.of(4,5,6);
        List<Integer> three = List.of(7,8,9);

        int actual = diagonalDifference(List.of(one, two, three));
        int expected = 5;

        assertEquals(expected, actual);
    }
}