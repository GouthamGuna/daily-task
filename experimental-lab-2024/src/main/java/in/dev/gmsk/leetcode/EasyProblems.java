package in.dev.gmsk.leetcode;

public class EasyProblems {

    /**
     * Merge Sorted Array
     * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
     * <p>
     * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
     * <p>
     * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
     * <p>
     * Constraints:
     * <p>
     * nums1.length == m + n
     * nums2.length == n
     * 0 <= m, n <= 200
     * 1 <= m + n <= 200
     * -109 <= nums1[i], nums2[j] <= 109
     *
     * @return
     */

    static int[] singleArraySorted(int[] nums1, int m, int[] nums2, int n) {
        for (int j = 0, i = m; j < n; j++) {
            nums1[i] = nums2[j];
            i++;
        }
        return nums1;
    }

    /**
     * Time complexity of second solution is O(N ^ 2) OR O(N logN) Instead of O(N)?
     * I have explained well how the time complexity of the second solution is O(N). Its explanation is written below the solution.
     * Problem Constraints
     * Test cases written like more than one solution cannot exist. Either solution exist or not.
     * Brute Force Approach
     * Run two nested loops to check every possible pair of numbers in the given array to see if they add up to the target sum.
     * If they add up to the target sum return the indexes.
     * Brute Force Code
     */

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
