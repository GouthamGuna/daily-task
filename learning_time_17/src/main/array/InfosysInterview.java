package main.array;

import java.util.List;

import static java.util.Arrays.*;

/**
 * What are the main feature introduced in java 8?
 * <p>
 * 1.) Lambda Expression
 * 2.) Stream API
 * 3.) Default Method
 * 4.) Optional Class
 * 5.) Function Interface
 * 6.) Method Reference
 * 7.) Date and Time API
 * 8.) Default and Static Interface Methods
 *</p>
 * What are the SOLID principles of software design. How would you apply?
 * 1.) Single Responsibility Principle (SRP)
 * 2.) Open-Closed Principle (OCP)
 * 3.) Liskov Substitution Principle (LSP)
 * 4.) Interface Segregation Principle (ISP)
 * 5.) Dependency Inversion Principle (DIP)
 */

public class InfosysInterview {
    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        findTheSumOfEvenNo( numbers );

        List<String> list = asList( "Apple", "banana", "apple", "orange", "apple" );
        countTheOccurrencesOfWords( list, list.get( 0 ) );
    }

    // Program : 1 Find the sum of all the even numbers.
    static void findTheSumOfEvenNo(int[] values) {

        int sum = stream( values )
                .filter( i -> i % 2 == 0 )
                .sum();
        System.out.println( "sum = " + sum );
    }

    // Program : 2 count the number of occurrences of a specific element in a list using java 8 features
    static void countTheOccurrencesOfWords(List<String> values, String validateString) {

        long count = values.stream()
                .filter( n -> n.equalsIgnoreCase( validateString ) )
                .count();

        System.out.println( "\ncount = " + count );
    }
}