package in.dev.gmsk.thread;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

public class AddElementsToMap {

    private Map<String, Integer> insertMapValues;

    public static void main(String... args) {
        new AddElementsToMap().runner();
    }

    public void runner() {
        List<String> listOfString = List.of( "ManiKandan", "Abadul", "Fahad", "Jaykumar", "Karan" );
        insertMapValues = new ConcurrentHashMap<>();

        var executor = Executors.newFixedThreadPool( 5 );
        var futureList = listOfString.stream()
                .map( s -> executor.submit( new AddElementsToMapRunnable( s ) ) )
                .toList();
        executor.shutdown();
        for (var f : futureList) while (!f.isDone()) ;
        System.out.println( "MAP " + insertMapValues );
    }

    private class AddElementsToMapRunnable implements Runnable {
        private final String name;
        AddElementsToMapRunnable(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            String dropOrAdd;
            if (name.length() <= 5) {
                dropOrAdd = "Adding!";
                insertMapValues.put( name, name.length() );
            } else dropOrAdd = "Dropping!";
            String formatString = "ThreadId = %d, Processing User = %s, %s%";
            System.out.format( formatString, Thread.currentThread().getId(), name, dropOrAdd );
        }
    }
}