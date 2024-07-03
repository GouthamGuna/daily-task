package in.dev.gmsk.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static in.dev.gmsk.leetcode.EasyProblems.*;
import static org.junit.jupiter.api.Assertions.*;

class EasyProblemsTest {

    @Test
    void testMergeStringsAlternately() {

        String W_One = "abc";
        String W_Two = "gmsk";

        String actual = MergeStringsAlternately(W_One, W_Two);
        String actualOne =MergeStringsAlternatelyRefactor(W_One, W_Two);

        String expected = "agbmcsk";

        assertEquals(expected, actual);
        assertEquals(expected, actualOne);
    }

    @Test
    void testIsAcronym() {
        String[] words = {"Hire", "Me", "Uber"};
        assertTrue(EasyProblems.isAcronym(words, "HMU"));
    }

    @Test
    void testContainsDuplicate() {
        int[] nums = {1, 2, 3, 1, 2, 3,};
       containsDuplicate(nums);
    }
}