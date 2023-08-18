package fundamentals.final_modifier;

public class PolarBear {

    /**
     *  The rule for static final variables are similar to instance final variables, except they
     *  do not use static constructor.
     * <p>
     *  public class PolarBear{
     *      final static String name = "Sree";
     *      static final int bamboo;
     *      static final double height; // DOES NOT COMPILE
     *      static { bamboo = 5;}
     *  }
     * <p>
     *   The height variable is not assigned a value anywhere in the class definition.
     * */

     final int age = 10;
    final int fishEaten;
    final String name;

    {fishEaten = 20;} // instance initializer

    public PolarBear(){
        name = "lemur";
    }
    
    public PolarBear(int height){
        this();
    }

    public static void main(String[] args) {
        PolarBear instance = new PolarBear();

        System.out.println(instance.age);
        System.out.println(instance.fishEaten);
        System.out.println(instance.name);
    }
}
