package in.dev.gmsk.general;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.*;

public class NumberGuessingGame {

    private static final Scanner scanner;
    private static final Random random;

    static {
        scanner = new Scanner( in );
        random = new Random();
    }

    public static void main(String[] args) {
        letStartGame();
    }

    /**
     * static int isStringInt(String s) {
     * try {
     * return Integer.parseInt( s );
     * } catch (NumberFormatException e) {
     * e.printStackTrace( out );
     * }
     * return 0;
     * }
     */

    static void letStartGame() {
        try {

            var targetNumber = random.nextInt( 100 ) + 1;

            int guessingNumber;

            do {
                out.println( "Enter your guessing number ? " );
                guessingNumber = scanner.nextInt();

                if (guessingNumber < targetNumber) {
                    out.println( "Too less! Try again..." );
                } else if (guessingNumber > targetNumber) {
                    out.println( "Too high! Try again..." );
                } else {
                    out.println( "Congratulations! You guessed the correct number." );
                }

            } while (guessingNumber != targetNumber);

        } catch (InputMismatchException e) {
            out.println( "Invalid Input Given.!" );
        } finally {
            try {
                scanner.close();
            } catch (Exception e) {
                e.printStackTrace( out );
            }
        }
    }
}
