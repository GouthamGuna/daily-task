package in.dev.gmsk.techgig;

public class MainClass {

    public static void main(String[] args) {
        System.out.println("reverseNumber = " + reverseNumber(1234));
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
