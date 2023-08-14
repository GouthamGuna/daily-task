package in.gmsk.array;

import java.util.Arrays;
import java.util.Comparator;

public class TopSpeeds {
    public void mainMethod() {

        int[] racers = {10, 20, 15, 18, 12, 25, 30, 22, 17, 16};

        // Find the top 3 speeds
        int[] topSpeeds = Arrays.stream(racers)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .mapToInt(Integer::intValue)
                .toArray();

        // Print the top 3 speeds
        System.out.println("Top 3 speeds: " + Arrays.toString(topSpeeds));
    }
}
