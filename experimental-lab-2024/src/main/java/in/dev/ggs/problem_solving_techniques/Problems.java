package in.dev.ggs.problem_solving_techniques;

import java.util.*;
import java.util.stream.Collectors;

public class Problems {

    public static void alignTheNumberOne(int[] arr) {

        if (arr.length == 0) {
            return;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                if (arr[i] == 1) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int e : arr) {
            System.out.print(e + " ");
        }
    }

    public static void findTheDuplicateStringCount(String s) {

        if (s.trim().isEmpty()) {
            return;
        }

        Map<String, Long> map = Arrays.stream(s.split(" "))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        map.forEach((key, value) -> {
            if (value > 1) {
                System.out.printf("%s -> %d\n", key, value);
            }
        });
    }

    public static void salesByMatch(List<Integer> ar, int n) {

        if (ar.isEmpty() || n <= 0) {
            return;
        }

        //Collections.sort(ar);
        ar = ar.stream().sorted().collect(Collectors.toList());
        int count = 1;
        int pair = 0;

        for (int i = 0; i < n - 1; i++) {
            if (Objects.equals(ar.get(i), ar.get(i + 1))) {
                count++;
            } else {
                pair = pair + (count / 2);
                count = 1;
            }
        }
        System.out.println("Maximum sales by a match: " + pair);
    }

    public static void test() {
        String s = "m&y na!#me is& Go@#wtham$";
        String exp = "[$@#!&]+";
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (!String.valueOf(currentChar).matches(exp)) {
                result.append(currentChar);
            }
        }

        System.out.println(result);
    }

    public static int countSubSets(int[] ar, int sum, int index) {

        if (sum == 0) {
            return 1;
        }

        if (sum < 0) {
            return 0;
        }

        if (index == ar.length) {
            return 0;
        }

        return countSubSets(ar, sum -  ar[index], index + 1) + countSubSets(ar, sum, index + 1);
    }

    public static int findSecondSmallestElement(int[] arr) {
        int max1 = 0, max2 = 0;

        if (arr[0] > arr[1]) {
            max1 = arr[0];
            max2 = arr[1];
        } else {
            max1 = arr[1];
            max2 = arr[0];
        }

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] > max1) {
                max2 = max1;
                max1 = arr[i];
            } else if (arr[i] > max2){
                max2 = arr[i];
            }
        }

        return max2;
    }

    public static void countDuplicatesWordsUsingStreamAPI(String s) {

        if (s.isEmpty()) {
            System.out.println("Invalid Input...");
        }

        Map<String, Long> map = Arrays.stream(s.split(" "))
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        map.forEach((k, v) -> {
            if (v > 1) {
                System.out.printf("%s -> %d\n", k, v);
            }
        });
    }

    /**
     * The indexOf method in Java searches for the specified character in the given string and returns the index of the first occurrence of the character.
     * If the character is not found in the string, the indexOf method returns -1.
     * */
    public static String removeDuplicateString(String s) {

        if (null == s || s.isEmpty()) {
            return "Invalid Input...";
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);

            if (temp != ' ') {
                if (result.toString().indexOf(temp) == -1) {
                    result.append(temp);
                }
            } else {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void palindromeFinder() {

        String[] ar = {"radar", "eye", "eve", "gowtham", "sree"};

        List<String> list = new ArrayList<>();

        for (String s: ar) {
            isPalindrome(s, list);
        }

        System.out.println("list = " + list);
    }

    private static void isPalindrome(String s, List<String> list) {

        String cs = s.replaceAll("\\s", "").toLowerCase();
        int l = 0, r = cs.length() - 1;
        boolean isPalindrome = true;

        while (l < r) {
            if (cs.charAt(l) != cs.charAt(r)) {
                isPalindrome = false;
                break;
            }
            l++;
            r--;
        }

        if (isPalindrome) {
            list.add(cs);
        }
    }

    public static void comparingObjects() {
        String s1 = "hello";
        String s2 = new String("hello");

        // use == for reference equality checks (usually for primitives or singletons)
        // which means it compares the memory locations of two objects.
        if (s1 == s2) {
            System.out.println("s1 and s2 are the same object");
        } else {
            System.out.println("s1 and s2 are different objects"); // false
        }

        // which means it compares the actual values or contents of two objects.
        if (s1.equals(s2)) {
            System.out.println("s1 and s2 have the same content"); // true
        } else {
            System.out.println("s1 and s2 have different content");
        }
    }
}
