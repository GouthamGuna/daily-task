package in.dev.gmsk.thread;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Base {

    static void getPlayWithConcurrentThread(int range) {

        System.out.println( "range = " + range );

        class InnerClassForConcurrentThreadMethod implements Runnable {

            final int counter = 100;

            @Override
            public void run() {
                printStudentList();
            }

            void printStudentList() {
                System.out.println( "printStudentList() Thread Name : " + Thread.currentThread().getName() );
                for (int i = 0; i <= counter; i++) {
                    Stream<String> student = Base.getStudent();

                    student.forEach( x -> System.out.println( "count = " + (range) + " " + x ) );
                }
            }
        }

        InnerClassForConcurrentThreadMethod Obj = new InnerClassForConcurrentThreadMethod();
        Thread thread = new Thread(Obj);
        thread.start();
    }

    static Stream<String> getStudent() {
        System.out.println( "getStudent() Thread Name : " + Thread.currentThread().getName() );
        List<String> list = Arrays.asList( "Mainkandan", "Dinesh", "Abudal", "Jaykumar", "Fahad", "manoj" );
        //addMissingStudentList(list); // UnsupportedOperationException
        return list.parallelStream();
    }

    private static void addMissingStudentList(List<String> list) {
        System.out.println( "addMissingStudentList() Thread Name : " + Thread.currentThread().getName() );

        String anotherNameList = "Gowtham Sankar";

        list.add( anotherNameList );
    }
}

public class ConcurrentMain {
    public static void main(String[] args) {
        System.out.println( "main() Thread Name : " + Thread.currentThread().getName() );

        IntStream.range( 1, 100 ).forEach( Base::getPlayWithConcurrentThread );
    }
}
