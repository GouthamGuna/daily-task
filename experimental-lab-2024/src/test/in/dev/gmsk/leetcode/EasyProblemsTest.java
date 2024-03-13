package in.dev.gmsk.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static in.dev.gmsk.leetcode.EasyProblems.*;

class EasyProblemsTest {

    /**
     * Example 1:
     * <p>
     * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * Output: [1,2,2,3,5,6]
     * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
     * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
     * Example 2:
     * <p>
     * Input: nums1 = [1], m = 1, nums2 = [], n = 0
     * Output: [1]
     * Explanation: The arrays we are merging are [1] and [].
     * The result of the merge is [1].
     * Example 3:
     * <p>
     * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
     * Output: [1]
     * Explanation: The arrays we are merging are [] and [1].
     * The result of the merge is [1].
     * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
     */

    @Test
    void TestSingleArraySorted() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;
        int[] ints = singleArraySorted( nums1, m, nums2, n );

        System.out.println( "ints = " + Arrays.toString( Arrays.stream( ints ).sorted().toArray() ) );
    }

    /**
     * Example 1:
     *
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     * Example 2:
     *
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     * Example 3:
     *
     * Input: nums = [3,3], target = 6
     * Output: [0,1]
     * */

    @Test
    void TestTwoSum(){
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] ints = twoSum( nums, target );
        System.out.println( "ints = " + Arrays.toString( Arrays.stream( ints ).toArray() ) );
    }
}