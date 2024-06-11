package main.file_traversal;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;

import static java.lang.System.*;

public class FileTraversal {

    public static void main(String[] args) {
        traverseFiles(new File("q:\\xyz"));
        NIOFileTraversal(Paths.get("r:\\xyz"));
        findSpecificFile(Paths.get("m:\\xyz"), "xyz.jpg");
        concurrentFileTraversal(Paths.get("s:\\xyz"));
    }

    public static void traverseFiles(File folders) {
        try {
            if (folders.isDirectory()) {
                File[] files = folders.listFiles();

                if (files != null) {
                    for (File file : files) {
                        if (file.isDirectory()) {
                            traverseFiles(file); // Recursive call for subfolders
                        } else {
                            out.printf("File : %s%n", file.getAbsoluteFile());
                        }
                    }
                }
            }
        } catch (Exception e) {
            err.println(e.getMessage());
        }
    }

    public static void NIOFileTraversal(Path folerPath) {
        try (Stream<Path> paths = Files.walk(folerPath)) {
            paths.filter(Files::isRegularFile)
                    .forEach(out::println); // Process each path files
        } catch (Exception e) {
            err.println(e.getMessage());
        }
    }

    public static void findSpecificFile(Path folerPath, String fileNameToFind) {
        try (Stream<Path> paths = Files.walk(folerPath)) {
            Optional<Path> foundFile = paths.filter(Files::isRegularFile)
                    .filter(path -> path.getFileName().toString().equalsIgnoreCase(fileNameToFind))
                    .findFirst();

            if (foundFile.isEmpty()) {
                out.println("Could not find file : " + fileNameToFind);
            } else {
                foundFile.ifPresent(out::println);
            }
        } catch (Exception e) {
            err.println(e.getMessage());
        }
    }

    public static void concurrentFileTraversal(Path root) {
        try (Stream<Path> paths = Files.walk(root)) {

            ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
            List<Future<Path>> futures = new ArrayList<>();

            paths.filter(Files::isRegularFile)
                    .forEach(path -> futures.add(executor.submit(() -> path)));

            for (Future<Path> future : futures) {
                out.println("future = " + future.get());
            }
            executor.shutdown();

        } catch (Exception e) {
            err.println(e.getMessage());
        }
    }
}
