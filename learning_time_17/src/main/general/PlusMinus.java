package main.general;

import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class PlusMinus {

    static int positives = 0;
    static int negatives = 0;
    static int zeroes = 0;

    public static void main(String[] args) {

        List<Integer> list = IntStream.of( 10, 20, 30, 40, 50, 60, 70, 80, -10, -20, -30 )
                .boxed()
                .toList();

        ternaryOperatorNotStatement( list );

        out.println( findPrimeNoUsingStream() );
    }

    /**
     * (x > 0) ? positives++: (x == 0) ? zeroes++: negatives++;
     */
    static void ternaryOperatorNotStatement(List<Integer> list) {

        list.forEach( x -> {
            int i = (x > 0) ? positives++ : ((x == 0) ? zeroes++ : negatives++);
        } );

        out.format( "%d.6\n", positives );
        out.format( "%d.6\n", zeroes );
        out.format( "%d.6\n", negatives );
    }

    static List<Integer> findPrimeNoUsingStream() {

        IntStream stream = IntStream.range( 1, 100 );

        return stream.filter( PlusMinus::isPrime )
                .boxed()
                .toList();
    }

    private static boolean isPrime(int i) {

        IntPredicate isDivisible = index -> i % index == 0;

        return i > 1 && IntStream.range( 2, i ).noneMatch( isDivisible );
    }
}
