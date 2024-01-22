package fundamentals.constructor;

abstract class LapTop{

    static {
        System.out.println("One");
    }

    public LapTop(String name){
        super();
        System.out.println("Two");
    }

    {
        System.out.println("Three");
    }

}

public class ConstructorFoo extends LapTop {

    {
        System.out.println("Four");
    }

    public ConstructorFoo() {
        super( "ConstructorFoo" );
        System.out.println("Five");
    }

    public static void main(String[] args) {
        new ConstructorFoo();
    }
}
