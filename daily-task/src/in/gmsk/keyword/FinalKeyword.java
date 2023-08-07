package in.gmsk.keyword;

class Example{

    int speedLimit = 40; //instance variable

    final int speedLimitFinal = 200; //final instance variable

    final int blankSpeedLimit; //final blank instance variable

    /*Example(int blankSpeedLimit) {
        this.blankSpeedLimit = blankSpeedLimit;
    }*/

   {
        blankSpeedLimit = 180;
    }

    public void exampleMethodOne() {
        // speedLimitFinal = 250;
        speedLimit = 60;
    }

    final void exampleMethodTwo(){
        final int speed =  20;
    }

    void exampleMethodThree(final int speed){
        System.out.println("speed : "+speed);
    }
}

public class FinalKeyword extends Example{

    public static void main(String[] args) {

        FinalKeyword instance = new FinalKeyword();
        // speedLimit = 100;
        instance.exampleMethodThree(instance.speedLimitFinal);
    }
}
