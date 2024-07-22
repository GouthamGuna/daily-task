package in.dev.ggs.problem_solving_techniques;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static in.dev.ggs.problem_solving_techniques.Problems.*;

class ProblemsTest {

    @Test
    void testAlignTheNumberOne() {
        int[] arr = {1, 2, 3, 2, 4, 1, 1, 2, 1, 3, 1};
        alignTheNumberOne(arr);
    }

    @Test
    void testFindTheDuplicateStringCount() {
        String s = "There is nothing to to find";
        findTheDuplicateStringCount(s);
    }

    @Test
    void testSalesByMatch() {
        List<Integer> ar = Arrays.asList(1, 1, 3, 1, 2, 1, 3, 3, 3, 3);
        int n = 10;
        salesByMatch(ar, n);
    }

    @Test
    void interviewTest() {
        test();

        int i = 1;
        while (i <= 3) {
            System.out.println( "Hello" );
            if ( i < 2 ) {
                System.out.println( "Hello" );
            }
            i++;
        }
    }

    @Test
    void testCountSubSets() {
        int[] arr = {20, 10, 15, 5, 10};
        int sum = 25;
        System.out.println(countSubSets(arr, sum, 0));
    }

    @Test
    void testFindSecondSmallestElement() {
        int[] arr = {23, 77, 45, 90, 33, 88, 777, 888};
        System.out.println(findSecondSmallestElement(arr));
    }
}