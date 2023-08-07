package in.gmsk.techgig;

public class Random {

    // Class initializer may be 'static'
    {
        System.out.println("first block.");
    }

    Random(){
        System.out.println("default block.");
    }

    Random(int x){
        System.out.println(x);
    }

    public static void main(String[] args) {
        new Random();
        new Random(10);

        // How many times init the object that time executing the block.
    }
}
