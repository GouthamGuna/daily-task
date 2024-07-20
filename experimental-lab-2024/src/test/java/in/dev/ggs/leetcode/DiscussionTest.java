package in.dev.ggs.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscussionTest {

    @Test
    void findMinimumAmplitudeTest() {
        int[] arr = {10, 10, 3, 4, 10}; // {-1, 3, -1, 8, 5, 4};
        int actual = Discussion.findMinimumAmplitude(arr);
        // int expected = 2;
        int expected = 0;

        assertEquals(expected, actual);
    }
}