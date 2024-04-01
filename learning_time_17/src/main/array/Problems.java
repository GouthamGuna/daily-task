package main.array;

import java.util.Arrays;

public class Problems {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};

        Arrays.stream(removeDuplicatesFromSortedArray(nums)).forEach(System.out::println);

    }

    public static int[] removeDuplicatesFromSortedArray(int[] ar) {

        int j = 1;
        int[] returnArr = new int[ar.length];

        for (int i = 1; i < ar.length; i++) {
            if (ar[i] != ar[i - 1]) {
                ar[j] = ar[i];
                j++;
                returnArr[i] = ar[j];
            }
        }
        return returnArr;
    }
}
