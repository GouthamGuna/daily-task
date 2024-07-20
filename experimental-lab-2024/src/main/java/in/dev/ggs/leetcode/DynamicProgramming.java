package in.dev.ggs.leetcode;

import static in.dev.ggs.leetcode.LongestPalindromicSubstring.*;

public class DynamicProgramming {

    public static void main(String[] args) {

        System.out.println(ApproachOneBruteForce("babad"));
        System.out.println(ApproachTwoDynamicProgramming("babad"));
        System.out.println(ApproachThreeRecursiveTLE("babad"));
    }
}

class LongestPalindromicSubstring {

    /**
     * A string is palindromic if it reads the same forward and backward.
     */

    public static String ApproachOneBruteForce(String s) {

        if (s.length() <= 1) {
            return s;
        }

        int maxLen = 1;
        String maxStr = s.substring( 0, 1 );

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + maxLen; j <= s.length(); j++) {
                if (j - i > maxLen && isPalindrome( s.substring( i, j ) )) {
                    maxLen = j - i;
                    maxStr = s.substring( i, j );
                }
            }
        }
        return maxStr;
    }

    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt( left ) != str.charAt( right )) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static String ApproachTwoDynamicProgramming(String s) {

        if (s.length() <= 1) {
            return s;
        }

        int maxLen = 1;
        int start = 0;
        int end = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); ++i) {
            dp[i][i] = true;
            for (int j = 0; j < i; ++j) {
                if (s.charAt( j ) == s.charAt( i ) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > maxLen) {
                        maxLen = i - j + 1;
                        start = j;
                        end = i;
                    }
                }
            }
        }

        return s.substring( start, end + 1 );
    }

    /**
     * Time Limit Exceeded
     */
    public static String ApproachThreeRecursiveTLE(String s) {

        if (s.equals( new StringBuilder( s ).reverse().toString() )) {
            return s;
        }

        String left = ApproachThreeRecursiveTLE( s.substring( 1 ) );
        String right = ApproachThreeRecursiveTLE( s.substring( 0, s.length() - 1 ) );

        if (left.length() > right.length()) {
            return left;
        } else {
            return right;
        }
    }
}
