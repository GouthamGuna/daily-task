package fundamentals.constructor;

class Base{
    int counter = 1000;

    Base(){
        Base();
    }

    void Base(){
        System.out.println("Counter = "+(++counter));
    }
}

class Derived extends Base{
    int counter = 2000;

    Derived(){}

    void Base(){
        System.out.println("Derived = "+(--counter));
    }
}

public class ConstructorExample {
    public static void main(String[] args) {
        Base base = new Derived();
    }
}
