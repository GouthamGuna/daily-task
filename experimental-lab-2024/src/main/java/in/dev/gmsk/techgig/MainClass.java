package in.dev.gmsk.techgig;

public class MainClass {

    public static void main(String[] args) {
        int num = 1234;
        System.out.println("reverseNumber = " + reverseNumber(num));
    }

    private static int reverseNumber(int num) {

        int reverse = 0;

        while (num != 0) {
            int remainder = num % 10;
            reverse = reverse * 10 + remainder;
            num = num / 10;
        }
        return reverse;
    }
}
