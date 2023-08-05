package in.gmsk.techgig;

public class Random {

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

        // How many times create the object executing the block.
    }
}
