package threading;

import java.util.ArrayList;
import java.util.List;

public class ThreadB extends Thread {

    List<Integer> total = new ArrayList<>();

    @Override
    public void run() {

        System.err.println("Run method thread name = " + Thread.currentThread().getName());

        synchronized (this) {

            int counter = 0;

            for (int i = 0; i <= 100; i++) {
                total.add(counter += i);
            }
            this.notify();
        }
    }
}
