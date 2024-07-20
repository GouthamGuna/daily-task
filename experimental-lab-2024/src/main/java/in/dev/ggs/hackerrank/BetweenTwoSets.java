package in.dev.ggs.hackerrank;

import java.util.Arrays;
import java.util.stream.Stream;

public class BetweenTwoSets {

    public static void utilityMethod_1() {
        Stream<Integer> iterate = Stream.iterate(2, x -> 2 + x).limit(100);
        iterate.forEach(System.out::println);
    }

    public static void main(String[] args) {
        //utilityMethod_1();

        // I need to find out the second-largest element
        int[] arr = {10, 40, 20, 50, 99, 140, 150, 250, 350, 200, 240, 260};

        int secondLargestElement = findSecondLargestElement(arr);
        System.out.println("secondLargestElement = " + secondLargestElement);
    }

    public static int findSecondLargestElement(int[] arr) {
        return Arrays.stream(arr)
                .boxed() // Convert int to Integer
                .sorted((a, b) -> b - a) // Sort in descending order
                .skip(1) // Skip the first element
                .findFirst() // Get the next element
                .orElseThrow(() -> new RuntimeException("Array does not have enough elements"));
    }
}
