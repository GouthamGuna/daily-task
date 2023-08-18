package fundamentals;

public class FinalLocalVariables {

    /**
     * public static void printZooInfo(boolean isWeekend){

     *         final int giraffe = 5;
     *         final long lemur;

     *         if(isWeekend) lemur = 5;
     *         giraffe = 3;                             // DOES NOT COMPILE

     *         System.out.println(giraffe +" "+ lemur); // DOES NOT COMPILE
     *     }
     *
     *     The Second compilation is from attempting to use the lemur variable,
     *     Which Would not be assigned a value.
     *     The compiler DOEST NOT allow the use of local variable that may not have been assign a value.
     * */
    

    public static void printZooInfo(boolean isWeekend){

        final int giraffe = 5;
        final long lemur;

        if(isWeekend) lemur = 5;
        else lemur = 10;

        System.out.println(giraffe +" "+ lemur);
    }

    /**
     *  Object reference builder is constance, but that doesn't mean the data in the class is constant.
     *
     **/

    public static void printStringBuilder(String args){

        final StringBuilder builder = new StringBuilder();
        builder.append("Hi, ");
        builder.append("GMSK");
        builder.append(args);

        System.out.println(builder);
    }

    public static void main(String[] args) {
        printZooInfo(false);
        printStringBuilder("...");
    }
}
