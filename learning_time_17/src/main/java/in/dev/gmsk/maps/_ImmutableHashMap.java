package in.dev.gmsk.maps;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class _ImmutableHashMap {

    /**
     * This code creates a mutable {@code HashMap},then converts it to an immutable {@code HashMap} using {@code Collections.unmodifiableMap().}
     * Note that this approach does not prevent external modifications, it only throws an {@code UnsupportedOperationException} if you try to modify the map.
     * <p>
     * <p>
     * Remember that {@code Map.ofEntries()} is generally more efficient and safer than
     * {@code Collections.unmodifiableMap()} because it does not allow external modifications and is more type-safe.
     */
    public static void main(String[] args) {
        example_1();
        example_2();
        example_3();
    }

    public static void example_1() {

        Map<String, Integer> immutableMap = new HashMap<>(Map.ofEntries(
                Map.entry("key1", 1),
                Map.entry("key2", 2),
                Map.entry("key3", 3)
                // Map.entry("key3", 3) // Exception in thread "main" java.lang.IllegalArgumentException: duplicate key: key3
        ));

        System.out.printf("Map.ofEntries impl := %s%n", immutableMap);

        // Map.put("key4", 4); // Non-static method 'put(K, V)' cannot be referenced from a static context
    }

    public static void example_2() {

        Map<String, Integer> map = new HashMap<>();
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key2", 3); // Not-taken this duplicate key : no error

        Map<String, Integer> immutableMap = Collections.unmodifiableMap(map);

        map.put("key4", 4); // no error this element added to the map.
        // immutableMap.put("key4", 4); // Exception in thread "main" java.lang.UnsupportedOperationException

        System.out.printf("unmodifiableMap impl := %s%n", immutableMap);
    }

    public static void example_3() {

        ConcurrentHashMap<String, Integer> immutableMap = new ConcurrentHashMap<>(Map.ofEntries(
                Map.entry("key1", 1),
                Map.entry("key2", 2),
                Map.entry("key3", 3)
                // Map.entry("key3", 3) // Exception in thread "main" java.lang.IllegalArgumentException: duplicate key: key3
        ));

        System.out.printf("ConcurrentHashMap impl := %s%n", immutableMap);

        // Map.put("key4", 4); // Non-static method 'put(K, V)' cannot be referenced from a static context
    }
}
