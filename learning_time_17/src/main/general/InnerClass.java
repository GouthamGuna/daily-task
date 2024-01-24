package main.general;

/**
 * An inner class is a nested class that is not explicitly or implicitly static.
 * */

class HasStatic{
    static int j = 100;
}

class Outer{
    class Inner extends HasStatic{

        static {
            System.out.println("Hello from Outer.Inner");
        }

        static       int x = 3;
        static final int y = 4;

        static void hello() {
            System.out.println("Hello from Outer.Inner.hello");
        }

        static class VeryNestedButNotInner
                extends NestedButNotInner {}
    }

    static class NestedButNotInner {
        int z = Inner.x;
    }

    interface NeverInner {}  // Implicitly static, so never inner
}
public class InnerClass {
    public static void main(String[] args) {
      // new Inner();
    }
}
