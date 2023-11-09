package threading;

public class ThreadA {

    public static void main(String[] args) throws InterruptedException {

        System.err.println("Main method thread name = "+Thread.currentThread().getName());

        ThreadB threadB = new ThreadB();
        threadB.start();

        // Thread.sleep(1000); // Bad Practices. Never put it in sleep method.

        synchronized (threadB) {
            threadB.wait(10000);   // Good Practices for when your using wait method put it timeout.
            System.out.println("threadB = " + threadB.total);
        }
    }
}
