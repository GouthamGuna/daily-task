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
}
