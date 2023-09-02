package in.gmsk.techgig;

import java.util.Arrays;

import static java.lang.System.*;

public class ArrayExample {

    public void arrayCodeFragment(String values) {

        String[] val = values.split(" ");
        Arrays.sort(val);

        Arrays.stream(val).forEach(out::println);
    }



    public static void main(String[] args) {
        String values = "Word1 Word2 Word3 Word5";
        ArrayExample obj = new ArrayExample();
        obj.arrayCodeFragment(values);
    }
}
