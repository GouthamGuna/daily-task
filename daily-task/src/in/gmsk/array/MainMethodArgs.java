package in.gmsk.array;

public class MainMethodArgs {
    public static void main(String[] args) {
        boolean help = false;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-h")) {
                help = true;
            }
        }
        if (help) {
            System.out.println("Usage: java Main [-h]");
            System.exit(0);
        }
    }
}
