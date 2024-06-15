package in.dev.gmsk.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayManipulate {

    private static String getFirstIndexAndLastIndexValues(String ids) {

        int length = ids.split(",").length;

        List<Integer> keys = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            System.out.println("Input vales : " + ids.split(",")[i]);

            int key = new ArrayManipulate().getRandomGenerateNumber();
            keys.add(key);
        }

        return keys.get(0) + " to " + keys.get(keys.size() -1);
    }

    private int getRandomGenerateNumber() {
        return new Random().nextInt(100) + 1;
    }

    public static void main(String[] args) {
        String str = "14, 15, 13, 14, 15, 16";
        System.out.println("str = " +
                getFirstIndexAndLastIndexValues(str)
        );
    }
}
