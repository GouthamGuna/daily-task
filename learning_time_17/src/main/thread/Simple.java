package main.thread;

public class Simple {
    public static void main(String[] args) {
        int MAX = 10;
        for (int i = 0; i < MAX; i++) {
            new Thread( Simple::doWork ).start();
        }
    }

    private static void doWork() {
        try {
            Thread.sleep( 5000 );
            System.out.println( "Thread : " + Thread.currentThread() );
        } catch (Throwable e) {
            System.err.println( e.getMessage() + " " + e );
        }
    }
}
