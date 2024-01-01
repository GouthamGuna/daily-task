package fundamentals.arrays;

public class CommonClass {
    public static void main(String[] args) {

        int[] numbers = new int[5];
        numbers[0] = 0;
        numbers[1] = 1;
        numbers[2] = 2;
        numbers[3] = 3;
        numbers[4] = 4;
        numbers[5] = 5;
        numbers[6] = 6;

        int length = numbers.length;

        System.out.println( "length = " + length );

        System.out.println("length = " + numbers[length]);

        //  System.out.println("length = " + numbers[length]); // Array out of bound exception.
    }
}
