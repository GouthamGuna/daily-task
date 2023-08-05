package in.gmsk.techgig;

public class InstanceMethodReference {

    public void printMsg(){
        System.out.println("Hello, this is instance method.");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new InstanceMethodReference()::printMsg);
        thread.start();
    }
}
