package main.thread;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Base {

    static void getPlayWithConcurrentThread() {

        class InnerClassForConcurrentThreadMethod extends Thread {

            final int counter = 100;

            void printStudentList() {
                System.out.println( "printStudentList() Thread Name : " + Thread.currentThread().getName() );
                for (int i = 0; i <= counter; i++) {
                    Stream<String> student = Base.getStudent();

                    int finalI = i;
                    student.forEach( x -> System.out.println( "count = " + (finalI) + " " + x ) );
                }
            }
        }

        InnerClassForConcurrentThreadMethod Obj = new InnerClassForConcurrentThreadMethod();
        Obj.start();
        Obj.printStudentList();
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

        Base.getPlayWithConcurrentThread();
    }
}
