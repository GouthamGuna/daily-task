package main.general;

public abstract class ExampleAbstraction {

    abstract void foo();

    public static void main(String[] args) { // Is subclassed by Anonymous in main in ExampleAbstraction (main.general)

        ExampleAbstraction obj = new ExampleAbstraction() {
            @Override
            void foo() {
                System.out.println("foo!");
            }
        };

        obj.foo();
    }
}
