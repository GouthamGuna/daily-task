package in.dev.gmsk.leetcode;

import javax.swing.tree.TreeNode;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class LeetCode_75 {

    public static String task_4_ReverseVowels(String s) {

        if (s == null || s.isEmpty()) return s;

        int i = 0;
        int j = s.length() - 1;

        char[] chars = s.toCharArray();

        while (i < j) {
            while (i < j && !vowels.get().contains(chars[i] + "")) {
                i++;
            }

            while (i < j && !vowels.get().contains(chars[j] + "")) {
                j--;
            }

            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;

            i++;
            j--;
        }

        return new String(chars);
    }

    // Type parameters: <T> – the type of results supplied by this supplier

    private static final Supplier<String> vowels = () -> "aeiouAEIOU";

    public static final Function<int[], Boolean> increasingTripletSubsequence = (num) -> {

        if (num == null || num.length < 3) {
            return false;
        }

        int i = Integer.MAX_VALUE, j = Integer.MIN_VALUE;

        for (int n : num) {
            if (n <= i) {
                i = n;
            } else if (n <= j) {
                j = n;
            } else {
                return true;
            }
        }

        return false;
    };

    public static Function<char[], Integer> stringCompression = chars -> {

        int c = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {

            if (i + 1 < chars.length && chars[i] == chars[i + 1]) {
                c++;
            } else {
                sb.append(chars[i]);
                if (c > 1) {
                    sb.append(c);
                }
                c = 1;
            }
        }
        System.out.print(sb);
        char[] compressedChars = sb.toString().toCharArray();
        System.arraycopy(compressedChars, 0, chars, 0, compressedChars.length);
        return sb.length();
    };

    public static double findMaxAverage(int[] nums, int k) {

        List<Integer> list = new ArrayList<>();
        int sum = 0;
        int a = 0;

        for (int b = 0; b < nums.length; b++) {
            sum += nums[b];

            if (b >= k - 1) {
                list.add(sum / k);
                sum -= nums[a];
                a++;
            }
        }

        return list.stream().mapToInt(Integer::intValue).average().orElse(Double.NaN);
    }

    public String longestPalindrome(String s) {
        if(s.length() <= 1){
            return s;
        }

        int maxLen = 1;
        String maxStr = s.substring(0,1);

        for(int i = 0; i < s.length(); i++){
            for(int j = i + maxLen; j <= s.length(); j++){
                if(j - i > maxLen && isPalindrome(s.substring(i, j))){
                    maxLen = j - i;
                    maxStr = s.substring(i ,j);
                }
            }
        }

        return maxStr;
    }

    private boolean  isPalindrome(String str){
        int left = 0;
        int right = str.length() - 1;

        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
