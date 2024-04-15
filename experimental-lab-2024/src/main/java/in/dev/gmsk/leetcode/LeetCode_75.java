package in.dev.gmsk.leetcode;

import java.util.function.Function;
import java.util.function.Supplier;

public class LeetCode_75 {

    public static String task_4_ReverseVowels(String s) {

        if (s==null || s.isEmpty()) return s;

        int i = 0;
        int j = s.length()-1;

        char[] chars = s.toCharArray();

        while(i<j){
            while(i<j && !vowels.get().contains(chars[i]+"")){
                i++;
            }

            while(i<j && !vowels.get().contains(chars[j]+"")){
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

        if (num == null || num.length < 3){
            return false;
        }

        int i = Integer.MAX_VALUE, j = Integer.MIN_VALUE;

        for(int n: num) {
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
}
