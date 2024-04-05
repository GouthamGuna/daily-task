package in.dev.gmsk.leetcode;

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
}
