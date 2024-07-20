package in.dev.ggs.leetcode;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class Problems {

    /**
     * You must write an algorithm with O(log n) runtime complexity.
     */
    public static int searchInRotatedSortedArray(int[] arr, int target) {

        int i = 0, j = arr.length - 1;

        while (i <= j) {

            int m = (i + j) / 2;

            if (arr[m] == target) {
                return m;

            } else if (arr[i] <= arr[m]) {
                if (arr[i] <= target && target < arr[m]) {
                    j = m - 1;
                } else {
                    i = m + 1;
                }
            } else {
                if (arr[m] < target && target <= arr[j]) {
                    i = m + 1;
                } else {
                    j = m - 1;
                }
            }
        }
        return -1;
    }

    // Code Brute Force- Merge and Sort

    /**
     * Algorithm Used:
     * <p/>
     * The Arrays.sort() method uses a variation of the Dual-Pivot Quicksort algorithm.
     * Quicksort is a comparison-based sorting algorithm that recursively divides the array into smaller subarrays and sorts them.
     * <p/>
     * Dual-Pivot Quicksort:
     * <p/>
     * Dual-Pivot Quicksort is an enhancement of the traditional Quicksort.
     * It uses two pivot elements (instead of one) to partition the array.
     * The two pivots help improve the efficiency of the sorting process.
     * <p/>
     * Steps in Dual-Pivot Quicksort:
     * <p/>
     * Choose two pivot elements (usually from the beginning and end of the array).
     * Partition the array into three segments: elements less than the left pivot, elements between the pivots, and elements greater than the right pivot.
     * Recursively apply the same process to the left and right segments.
     * Combine the sorted segments to obtain the final sorted array.
     * <p/>
     * Complexity Analysis:
     * <p/>
     * Time Complexity: The average time complexity of Dual-Pivot Quicksort is O(N log N).
     * Space Complexity: The algorithm uses O(1) auxiliary space (in-place sorting).
     */

    public static BiFunction<Integer[], Integer[], Double> findMedianSortedArrays = (arrOne, arrTwo) -> {
        // Get the sizes of both input arrays.
        int n = arrOne.length;
        int m = arrTwo.length;

        // Merge the arrays into a single sorted array.
        var merged = new int[n + m];
        int k = 0;

        for (Integer integer : arrOne) {
            merged[k++] = integer;
        }
        for (Integer integer : arrTwo) {
            merged[k++] = integer;
        }

        // Sort the merged array.
        Arrays.sort(merged);

        // Calculate the total number of elements in the merged array.
        int total = merged.length;

        if (total % 2 == 1) {
            // If the total number of elements is odd, return the middle element as the median.
            return (double) merged[total / 2];
        } else {
            // If the total number of elements is even, calculate the average of the two middle elements as the median.
            int middle1 = merged[total / 2 - 1];
            int middle2 = merged[total / 2];
            return ((double) middle1 + (double) middle2) / 0x1.0p1; // hex
        }
    };

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] all = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2)).sorted().toArray();
        int len = all.length;
        return (len %2 ==0)?(double)(all[len/2]+all[len/2-1])/2:all[len/2];
    }
}
