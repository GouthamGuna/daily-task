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
    }
}