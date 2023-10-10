package fundamentals.arrays;

public class CommonClass {
    public static void main(String[] args) {

        int[] numbers = new int[5];

        int length = numbers.length;

        System.out.println("length = " + numbers[length]);

        //  System.out.println("length = " + numbers[length]); // Array out of bound exception.
    }
}
