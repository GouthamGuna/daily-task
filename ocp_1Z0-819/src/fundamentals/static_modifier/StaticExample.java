package fundamentals.static_modifier;

public class StaticExample {

    static {
        getMethodA();
       // iamNotStaticMethodA(); // compiler error cannot reference from static context.
    }

    static void getMethodA(){
        System.out.println("I am Method A");
    }
    void iamNotStaticMethodA(){
        System.out.println("I am Method A - Non static");
    }

    public static void main(String[] args) {
        StaticExample example = new StaticExample();
        example.iamNotStaticMethodA();
    }
}
