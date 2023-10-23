package chapter_10;

public class MultipleCatchClauses {

    public static void exampleForMultipleCatchClauses(String[] args) {
        try {

            int a = args.length;
            int b = 27 / a;

            int[] c = {1};
            c[42] = 99;

        } catch (ArithmeticException e) {
            System.out.println("Division by zero : " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index oob : " + e.getMessage());
        }
        System.out.println("After try and catch block.");
    }
}
