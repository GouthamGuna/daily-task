package in.gmsk.array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxValues {
    public static void main(String[] args) {
        int[][] arrays = new int[10][20];
        arrays[0] = new int[]{1, 232, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        arrays[1] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};


        int[] top3 = findTop3(arrays);
        System.out.println(Arrays.toString(top3));
    }

    public static int[] findTop3(int[][] arrays) {

        /*

          PriorityQueue to keep track of the top 3 maximum values.
          It iterates through each value in the arrays and adds it to the PriorityQueue.
          If the size of the PriorityQueue is greater than 3, it removes the smallest value.
          At the end, it returns an array containing the top 3 maximum values.
         */

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] array : arrays) {
            for (int value : array) {
                pq.add(value);
                if (pq.size() > 3) {
                    pq.poll();
                }
            }
        }
        int[] top3 = new int[3];
        for (int i = 2; i >= 0; i--) {
            top3[i] = pq.poll();
        }
        return top3;
    }
}
