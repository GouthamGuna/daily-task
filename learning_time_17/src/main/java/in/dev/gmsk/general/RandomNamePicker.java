package in.dev.gmsk.general;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

class Users {

    private final String name;

    Users(String name) {
        this.name = name;
    }

    static List<Users> getUsersName() {
        return Stream.of(
                new Users( "Jeetendra" ),
                new Users( "Anoop" ),
                new Users( "Rama" ),
                new Users( "Kumar" ),
                new Users( "Neeraj" ),
                new Users( "Nikhila" ),
                new Users( "Ratnam" ),
                new Users( "Sima" ),
                new Users( "Navneet" )
        ).toList();
    }

    @Override
    public String toString() {
        return "name = " + name;
    }

    static List<String> StringOfNames() {
        return Arrays.asList( "Navneet", "Neeraj", "Rama" );
    }
}

public class RandomNamePicker {
    private static final Random rand = new Random();

    public static void main(String[] args) {

        System.out.println( getRandomName( Users.getUsersName() ) );

        System.out.println( getStringsName( Users.StringOfNames() ) );
    }

    static String getRandomName(List<Users> usersList) {

        if (!usersList.isEmpty()) {

            int index = rand.nextInt( usersList.size() );

            return String.valueOf( usersList.get( index ).toString() );

        } else {
            return "users name not found.!";
        }

    }

    static String getStringsName(List<String> strings) {

        if (!strings.isEmpty()) {
            int index = rand.nextInt( strings.size() );
            return strings.get( index );
        } else {
            return "Name`s not found.!";
        }
    }
}
