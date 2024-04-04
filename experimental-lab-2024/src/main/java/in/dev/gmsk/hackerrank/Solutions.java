package in.dev.gmsk.hackerrank;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solutions {

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

        int aCount = 0;
        int bCount = 0;

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i)) {
                aCount++;
            } else if (a.get(i) < b.get(i)) {
                bCount++;
            }
        }

        return IntStream.of(aCount, bCount).boxed().collect(Collectors.toList());
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left; // The point where left and right converge is the insert position
    }

    /**
     * Binary search is an efficient algorithm used to find the position of a target value within a sorted array.
     * The process involves repeatedly dividing the search interval in half.
     * If the target value is less than the middle element, the search continues on the left half of the array; if it’s greater, it continues on the right half.
     * This method significantly reduces the search time, giving it a time complexity of ( O(\log N) ), where ( N ) is the number of elements in the array.
     */

    public static int binarySearch(int[] arr, int l, int r, int x) {
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (arr[m] == x) {
                return m; // Element found
            }
            if (arr[m] < x) {
                l = m + 1; // Search in the right half
            } else {
                r = m - 1; // Search in the left half
            }
        }
        return -1; // Element not found
    }

    public static Long aVeryBigSum(List<Integer> ar) {
        return ar.stream().filter(x -> x-- > 0).mapToLong(x -> x).sum();
    }

    public static int diagonalDifference(List<List<Integer>> arr) {

        if (arr.size() < 2) return 0;

        int result = 0;
        int arrSize = arr.size();

        for (int i = 0; i < arrSize; i++) {
            result += arr.get(i).get(i) - arr.get(i).get(arrSize - (i + 1));
        }

        return absoluteValue(result);
    }

    private static int absoluteValue(int a) {
        return (a < 0) ? -a : a;
    }
}
