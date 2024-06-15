package in.dev.gmsk.general;

public class HowToImplementEqualsCorrectly {

    public static void main(String[] args) {
        obviouslyDifferent_1();
        obviouslyDifferent_2();

        obviouslyEqualDifferent_1();
        obviouslyEqualDifferent_2();
    }

    public static void obviouslyDifferent_1() {

        String some = "Some String";
        String other = "other String";

        boolean identical = some == other;

        System.out.println("identical_1 = " + identical);
    }

    public static void obviouslyDifferent_2() {

        String some = "Some String";
        String other = some;

        boolean identical = some == other;

        System.out.println("identical_2 = " + identical);
    }

    public static void obviouslyEqualDifferent_1() {

        String some = "Some String";
        String other = "other String";

        boolean equal = some.equals(other);

        System.out.println("equal_1 = " + equal);
    }

    public static void obviouslyEqualDifferent_2() {

        String some = "some String";
        String other = "some String";

        boolean equal = some.equals(other);

        System.out.println("equal_2 = " + equal);
    }
}
