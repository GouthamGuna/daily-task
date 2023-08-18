package fundamentals.final_modifier;

public class PolarBear {

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
}
