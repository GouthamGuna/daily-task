package chapter_10;

import java.util.Random;

public class HandleError implements Runnable {

    static {
        System.out.println("static block execute thread name is : " + Thread.currentThread().getName());
        wellConstructedCatchClauses();
    }

    public static void main(String[] args) {
        HandleError handleError = new HandleError();
        handleError.run();
    }

    @Override
    public void run() {
        System.out.println("------------------------------------------------------------------");
        System.out.println("run() execute thread name is  : " + Thread.currentThread().getName());
        HandleError.wellConstructedCatchClauses();
    }

    public static void wellConstructedCatchClauses() {
        int a = 0, b = 0, c = 0;

        Random random = new Random();

        for (int i = 0; i < 3500; i++) {
            try {
                c = random.nextInt();
                b = random.nextInt();
                a = 12345 / (b / c);
            } catch (ArithmeticException e) {
                System.out.println("Division by Zero.");
                a = 0; // set a to zero and continue.
            }
            System.out.println("a = " + a);
        }
    }
}
