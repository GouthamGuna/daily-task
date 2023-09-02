package in.gmsk.techgig;

public class Sample {

    public static void main(String[] args) {

        Sample obj = new Sample();

        for(int a=0; a < 5; ++a){

           // obj.set(a); // Compile time err
            // obj.clear(2); // Compile time err

            System.out.println(obj);
        }
    }
}
