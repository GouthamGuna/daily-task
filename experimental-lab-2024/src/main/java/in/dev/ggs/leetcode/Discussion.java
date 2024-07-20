package in.dev.ggs.leetcode;

import java.util.Arrays;

public class Discussion {

    public static int findMinimumAmplitude(int[] arr) {

        if (arr.length <= 3) return 0;

        Arrays.sort(arr);

        int n = arr.length;

        int optionZero = arr[n - 1] - arr[3];

        int optionOne = arr[n - 2] - arr[2];

        int optionTwo = arr[n - 3] - arr[1];

        int optionThree = arr[n - 4] - arr[0];

        return Math.min(Math.min(optionZero, optionOne), Math.min(optionTwo, optionThree));
    }
}
