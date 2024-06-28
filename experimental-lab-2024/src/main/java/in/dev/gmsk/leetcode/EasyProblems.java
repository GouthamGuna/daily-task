package in.dev.gmsk.leetcode;

@SuppressWarnings("ALL")
public class EasyProblems {

    /**
     * Merge Sorted Array
     * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
     * <p>
     * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
     * <p>
     * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
     * <p>
     * Constraints:
     * <p>
     * nums1.length == m + n
     * nums2.length == n
     * 0 <= m, n <= 200
     * 1 <= m + n <= 200
     * -109 <= nums1[i], nums2[j] <= 109
     *
     * @return
     */

    static int[] singleArraySorted(int[] nums1, int m, int[] nums2, int n) {
        for (//noinspection ReassignedVariable
                int j = 0, i = m; j < n; j++) {
            nums1[i] = nums2[j];
            i++;
        }
        return nums1;
    }

    /**
     * Time complexity of second solution is O(N ^ 2) OR O(N logN) Instead of O(N)?
     * I have explained well how the time complexity of the second solution is O(N). Its explanation is written below the solution.
     * Problem Constraints
     * Test cases written like more than one solution cannot exist. Either solution exist or not.
     * Brute Force Approach
     * Run two nested loops to check every possible pair of numbers in the given array to see if they add up to the target sum.
     * If they add up to the target sum return the indexes.
     * Brute Force Code
     */

    public static int[] twoSum(int[] nums, int target) {
        for (//noinspection ReassignedVariable
                int i = 0; i < nums.length; i++) {
            for (//noinspection ReassignedVariable
                    int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    /**
     * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
     * The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
     * <p>
     * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
     * <p>
     * Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
     * Return k.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [3,2,2,3], val = 3
     * Output: 2, nums = [2,2,_,_]
     * Explanation: Your function should return k = 2, with the first two elements of nums being 2.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     * <p>
     * Constraints:
     * <p>
     * 0 <= nums.length <= 100
     * 0 <= nums[i] <= 50
     * 0 <= val <= 100
     */

    public static int removeElement(int[] nums, int val) {
        //noinspection ReassignedVariable
        int index = 0;

        for (//noinspection ReassignedVariable
                int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }

    public static String MergeStringsAlternately(String wordOne, String wordTwo) {

        StringBuilder sb = new StringBuilder();
        //noinspection ReassignedVariable
        int i = 0;

        while (wordOne.length() > i || i < wordTwo.length()) {
            if (i < wordOne.length()) {
                sb.append(wordOne.charAt(i));
            }
            if (i < wordTwo.length()) {
                sb.append(wordTwo.charAt(i));
            }
            i++;
        }

        return sb.toString();
    }

    public static String MergeStringsAlternatelyRefactor(String wordOne, String wordTwo) {

        int n = Math.min(wordOne.length(), wordTwo.length());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(wordOne.charAt(i));
            sb.append(wordTwo.charAt(i));
        }

        return sb.append(wordOne.substring(n)).append(wordTwo.substring(n)).toString();
    }

    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return gcdOfStrings(str2, str1); // Ensure str1 is not shorter than str2
        }
        if (!str1.startsWith(str2)) {
            return ""; // str2 is not a prefix of str1, so no GCD exists
        }
        if (str2.isEmpty()) {
            return str1; // The entire str1 is the GCD
        }
        return gcdOfStrings(str2, str1.substring(str2.length())); // Recursively find GCD
    }

    public static boolean isAcronym(String[] words, String s) {

        if (words.length < 0 && s.length() < 0) {
            throw new IllegalArgumentException("String length must be greater than zero");
        }

        int wordIndex = 0; // Index to track the current word
        int charIndex = 0; // Index to track the current character in the word

        for (char c : s.toCharArray()) {
            if (wordIndex < words.length && words[wordIndex].charAt(charIndex) == c) {
                // Move to the next character in the current word
                charIndex++;
                if (charIndex == words[wordIndex].length()) {
                    // Move to the next word
                    wordIndex++;
                    charIndex = 0;
                }
            } else {
                // Character mismatch
                return false;
            }
        }

        // Check if all words were used
        return wordIndex == words.length;
    }

}
