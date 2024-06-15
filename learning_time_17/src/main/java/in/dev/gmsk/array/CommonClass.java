package in.dev.gmsk.array;

import java.util.Arrays;
import java.util.OptionalInt;

public class CommonClass {

    private static int COUNTER = 0;

    public static void main(String[] args) {

        int[] amount = {600, 500, 300, 555, 300, 6767, 909, 757, 0};

        fetchLargestAmount(amount);

        fetchLeastAmount(amount);

        int[] numbers = {4, 6, 8, 3, 5, 89, 1, 90};

        fetchLargestNumber(numbers);


    }

    private static void fetchLargestNumber(int[] numbers) {

        OptionalInt max = Arrays.stream(numbers).distinct().max();

        System.out.println(++COUNTER +"\t Demonstration Stream API fetchLargestNumber = " + max);
    }

    private static void fetchLeastAmount(int[] amount) {

        OptionalInt min = Arrays.stream(amount).min();

        System.out.println(++COUNTER + "\t Demonstration Stream API fetchLeastAmount = " + min);

        /* Natural for loop demonstration */

        int minAmount = 0;

        for (int i = 0; i < amount.length; i++) {

            int maxAmount = amount[i];

            if (minAmount >= maxAmount) {
                minAmount = amount[i];
            }
        }

        System.out.println(++COUNTER + "\t Demonstration Natural for loop fetchLeastAmount = " + minAmount);

        /* Enhanced for loop */

        int enMin = 0;

        for (int enMax : amount) {

            if (enMin >= enMax) {
                enMin = enMax;
            }
        }

        System.out.println(++COUNTER + "\t Demonstration Enhanced for loop fetchLeastAmount = " + enMin);
    }

    private static void fetchLargestAmount(int[] amount) {

        OptionalInt max = Arrays.stream(amount).max();

        System.out.println(++COUNTER + "\t Demonstration Steam API fetchLargestAmount = " + max);

        /* Natural for loop demonstration */

        int maxAmount = 0;

        for (int i = 0; i < amount.length; i++) {

            int min = amount[i];

            if (min >= maxAmount) {
                maxAmount = amount[i];
            }
        }

        System.out.println(++COUNTER + "\t Demonstration natural for loop fetchLargestAmount = " + maxAmount);

        /* Enhanced for loop */

        int enMax = 0;

        for (int min : amount) {

            if (min >= enMax) {
                enMax = min;
            }
        }

        System.out.println(++COUNTER + "\t Demonstration Enhanced for loop fetchLargestAmount = " + maxAmount);
    }
}
