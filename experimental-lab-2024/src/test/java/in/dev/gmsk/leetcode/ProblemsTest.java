package in.dev.gmsk.leetcode;

import org.junit.jupiter.api.Test;

import static in.dev.gmsk.leetcode.Problems.*;
import static org.junit.jupiter.api.Assertions.*;

class ProblemsTest {

    /**
     * Example 1:
     * <p>
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     * Example 2:
     * <p>
     * Input: nums = [4,5,6,7,0,1,2], target = 3
     * Output: -1
     * Example 3:
     * <p>
     * Input: nums = [1], target = 0
     * Output: -1
     */

    @Test
    void searchInRotatedSortedArrayTest() {

        int[] nums = {1};
        int target = 0;

        int actual = searchInRotatedSortedArray(nums, target);
        int expected = -1;

        assertEquals(expected, actual);
    }
}