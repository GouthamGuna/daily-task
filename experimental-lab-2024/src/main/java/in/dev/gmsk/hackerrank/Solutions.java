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

    /**
     * Problem Overview:
     * Given an array B, we need to determine an array A such that:
     * <p>
     * 1.) For all indices i, A[i] <= B[i].
     * 2.) We want to maximize the sum of absolute differences between consecutive pairs of A.
     */

    public static int sherlockAndCostOne(List<Integer> list) {

        int T = list.size();
        int result = 0;

        while (T > 0) {
            int N = list.size();
            int[] inputArray = new int[N];

            for (int i = 0; i < N; i++) {
                inputArray[i] = list.get(i);
            }

            int[][] dp = new int[N][2];
            dp[0][0] = 0;
            dp[0][1] = 0;

            for (int i = 1; i < N; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + inputArray[i - 1] - 1);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + inputArray[i] - 1);
            }

            result = Math.max(dp[N - 1][0], dp[N - 1][1]);
            T--;
        }
        return result;
    }

    /**
     * Approach:
     * We can use dynamic programming to solve this problem efficiently. Let’s break down the approach:
     * <p>
     * 1.) Initialize two arrays: dp[i][0] and dp[i][1]. These arrays will store the maximum sum of absolute differences for the first i elements of the input array.
     * 2.) Iterate through the input array from left to right:
     * Update dp[i][0] and dp[i][1] based on the previous values and the current element.
     * 3.) The final answer is the maximum value between dp[N-1][0] and dp[N-1][1].
     */
    public static int sherlockAndCostApproachTwo(List<Integer> list) {
        int N = list.size();
        int[][] dp = new int[N][2];
        dp[0][0] = 0;
        dp[0][1] = 0;

        for (int i = 1; i < N; i++) {
            int curr = list.get(i);
            int prev = list.get(i - 1);

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prev - 1);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + curr - 1);
        }

        return Math.max(dp[N - 1][0], dp[N - 1][1]);
    }

    public static int hourglassSum(List<List<Integer>> arr) {
        if (arr == null || arr.size() < 3 || arr.get(0).size() < 3) {
            throw new IllegalArgumentException("The input list must be at least 3x3 in size.");
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i <= arr.size() - 3; i++) {
            for (int j = 0; j <= arr.get(i).size() - 3; j++) {
                int sum = arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2)
                        + arr.get(i + 1).get(j + 1)
                        + arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2);
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

}
