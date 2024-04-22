package in.dev.gmsk.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static in.dev.gmsk.leetcode.LeetCode_75.*;

class LeetCodeTest {

    @Test
    void task_4_ReverseVowelsTest() {

        System.out.println(
                task_4_ReverseVowels("leetcode")
        );
    }

    @Test
    void increasingTripletSubsequenceTest() {

        // test case 1 : nums = [1,2,3,4,5] : true, nums = [5,4,3,2,1] : false, nums = [2,1,5,0,4,6] : true
        // nums = [2,4,-2,-3] , false

        int[] nums = {2,4,-2,-3};

        Boolean actual = increasingTripletSubsequence.apply(nums);

        assertFalse(actual);
    }

    @Test
    void stringCompression(){

    }
}