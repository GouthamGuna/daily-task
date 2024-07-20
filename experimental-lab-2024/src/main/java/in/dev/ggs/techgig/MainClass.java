package in.dev.gmsk.techgig;

public class MainClass {

    public static void main(String[] args) {
        int num = 1234;
        System.out.println("reverseNumber = " + reverseNumber(num));

        int[] arr = {10, 22, 55, 20, 1, 4, 5, 2, 3, 12};
        bubbleSort(arr);
        System.out.println("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
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

    // Time Complexity : O(n^2)
    private static void bubbleSort(int[] numbers) {

        int n = numbers.length;
        int temp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }
}