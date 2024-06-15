package in.dev.gmsk.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {

        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println( "coreCount : " + coreCount );
        ExecutorService executorService = Executors.newFixedThreadPool( coreCount );

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            int r = (int) (Math.floor( Math.random() * 8 )) + 2;
            System.out.println( "r = " + r );
            executorService.execute( new CPUIntensiveTask() );
        }
    }

    static class CPUIntensiveTask implements Runnable {
        List<Integer> addInt = new ArrayList<>();

        @Override
        public void run() {

            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                System.out.println( "i = " + i + " Thread Name run() = " + Thread.currentThread().getName() );
                addInt.add( i );
            }
        }
    }
}
