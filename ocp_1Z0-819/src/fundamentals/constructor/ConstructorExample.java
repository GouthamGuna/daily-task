package fundamentals.constructor;

class Base {
    int counter = 1000;

    Base() {
        base();
    }

    void base() {
        System.out.println( "Counter = " + (++counter) );
    }
}

class Derived extends Base {
    int counter = 2000;

    Derived() {
    }

    void base() {
        System.out.println( "Derived = " + (--counter) );
    }
}

public class ConstructorExample {
    public static void main(String[] args) {
        new Derived();
    }
}
