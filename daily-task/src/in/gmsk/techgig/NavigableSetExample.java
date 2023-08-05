package in.gmsk.techgig;

import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetExample {

    public static void main(String[] args) {

        NavigableSet<Integer> setNumber = new TreeSet<>();
        setNumber.add(11);
        setNumber.add(12);
        setNumber.add(13);
        setNumber.headSet(14);

        System.out.println(setNumber);
    }
}
