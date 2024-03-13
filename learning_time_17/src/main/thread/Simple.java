package main.thread;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executors;

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

    public static void fetch(int index, String path) {

        System.out.println( index + " : " + Thread.currentThread() + " : " + "before" );

        try {
            var numberOfLines = Files.lines( Paths.get( path ) ).count();

            System.out.println( index + " : " + Thread.currentThread() + " after " + numberOfLines );
        } catch (IOException e) {
            System.err.println( "e = " + e );
        }
    }
}
