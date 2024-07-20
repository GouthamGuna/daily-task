package in.dev.ggs.util;

import java.util.ArrayList;
import java.util.List;

public class MatrixConverter {

    /**
     * Octal integer '010000' => 4096
     * <p>
     * Octal integer '002440' => 1312
     * <p>
     * Octal integer '000200' => 128
     * <p>
     * Octal integer '001240' => 001240
     */

    public static List<List<Integer>> matrixConverter() {

        List<List<Integer>> matrix = new ArrayList<>();

        matrix.add(new ArrayList<>(List.of(111000, 010000, 111000, 002440, 000200)));
        matrix.add(new ArrayList<>(List.of(001240)));

        return matrix;
    }

    public static void printMatrix(List<List<Integer>> matrix) {

        for (int row = 0; row < matrix.size(); row++) {
            System.out.println("Row " + (row + 1) + ": ");

            for (int col = 0; col < matrix.get(row).size(); col++) {

                int number = matrix.get(row).get(col);
                if (number == 0) {
                    System.out.print("0");
                } else {
                    System.out.printf("%4d", number);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printMatrix(matrixConverter());
    }
}
