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
            while(i<j && !Vowels.get().contains(chars[i]+"")){
                i++;
            }

            while(i<j && !Vowels.get().contains(chars[j]+"")){
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

    private static final Supplier<String> Vowels = () -> "aeiouAEIOU";

    private static final Function<String, Boolean> containsVowels = s -> s.contains("a") && s.contains("e")
            && s.contains("i") && s.contains("o") && s.contains("u");
}
