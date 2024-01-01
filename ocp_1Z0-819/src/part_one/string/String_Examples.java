package part_one.string;

/**
 * String APIs
 * Topic: Create and Manipulate Strings
 */

public class String_Examples {
    public static void main(String[] args) {
        EqualLiteralReferences();
        StringConstructors();
        StringConstructorsInterned();
    }

    public static void EqualLiteralReferences() {
        // String literals automatically interned so all "hello" literals
        // point to same reference in memory, in the string pool
        String s1 = "hello";

        String s2 = "hello";

        System.out.println( "s1 and s2 are string literals " +
                "assigned to String variables: (s1 == s2) = " +
                ((s1 == s2) ? "true" : "false") );

        System.out.println( "s1 and s2 are string literals " +
                "compare equals methods (s1.equals( s2 ) = " +
                ((s1.equals( s2 )) ? "true" : "false") );
    }

    public static void StringConstructors() {
        String s1 = new String( "hello" );
        String s2 = new String( "hello" );

        // Now evaluates to false, strings do not point to same reference,
        // and are not stored in the string pool
        System.out.println( "\n s1 and s2 are constructed String objects " +
                "assigned to String variables: (s1 == s2) = " +
                ((s1 == s2) ? "true" : "false") );
    }

    public static void StringConstructorsInterned() {
        //**** Add intern() method:  intern checks the string pool
        // and returns the string pool reference to s1.
        String s1 = new String( "hello" ).intern();

        //**** Add intern() method: s2 also gets the string pool
        // reference for "hello"
        String s2 = new String( "hello" ).intern();

        // Now evaluates to true
        System.out.println( "\n s1 and s2 are interned String objects " +
                "assigned to String variables: (s1 == s2) = " +
                ((s1 == s2) ? "true" : "false") );
    }
}
