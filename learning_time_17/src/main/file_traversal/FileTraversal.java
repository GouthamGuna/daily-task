package main.file_traversal;

import main.model.DirectoryEntry;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.*;

public class FileTraversal {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        /*traverseFiles(new File("q:\\xyz"));
        NIOFileTraversal(Paths.get("r:\\xyz"));
        findSpecificFile(Paths.get("m:\\xyz"), "xyz.jpg");
        concurrentFileTraversal(Paths.get("D:\\accounts_sms_api"));
        directoryService("D:\\accounts_sms_api"); */

        CompletableFuture<List<DirectoryEntry>> completableFutureOfDirectoryEntries =
                asCompletableFutureOfDirectoryEntries(new File("D:\\accounts_sms_api"));

        out.println(convertToJson(completableFutureOfDirectoryEntries.get()));
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

    public static void directoryService(String rootPath) {

        List<DirectoryEntry> directoryEntries = new ArrayList<>();

        utilTraverseDirectory(rootPath, directoryEntries);

        out.println("Files : " + convertToJson(directoryEntries));
    }

    private static void utilTraverseDirectory(String dirPath, List<DirectoryEntry> directoryEntries) {
        File directory = new File(dirPath);

        // Iterate over the files and subdirectories
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            if (file.isDirectory()) {
                utilTraverseDirectory(file.getAbsolutePath(), directoryEntries);
            } else {
                directoryEntries.add(new DirectoryEntry(file.getName(), file.getAbsolutePath(), file.getAbsolutePath()));
            }
        }
    }

    private static String convertToJson(List<DirectoryEntry> directoryEntries) {
        StringBuilder json = new StringBuilder();

        json.append("[");
        for (int i = 0; i < directoryEntries.size(); i++) {
            DirectoryEntry directoryEntry = directoryEntries.get(i);
            // json.append("{\"name\":\"").append(directoryEntry.getName()).append("\",\"path\":\"").append(directoryEntry.getPath()).append("\"}");
            json.append("{\"name\":\"").append(directoryEntry.getName()).append("\",\"path\":\"").append(directoryEntry.getPath())
                    .append("\",\"url\":\"").append(directoryEntry.getUrl())
                    .append("\"}");
            if (i < directoryEntries.size() - 1) {
                json.append(",");
            }
        }
        json.append("]");

        return json.toString();
    }

    public static CompletableFuture<List<DirectoryEntry>> asCompletableFutureOfDirectoryEntries(File directory) throws IOException {
        try (Stream<Path> entries = Files.walk(directory.toPath())) {
            return CompletableFuture.completedFuture(entries.filter(Files::isRegularFile)
                    .map(entry -> new DirectoryEntry(entry.getFileName().toString(), entry.toAbsolutePath().toString(), generateRandomUrl(entry.toAbsolutePath().toString()).get()))
                    .filter(FileTraversal::isSafeToProcess) // Additional security check here
                    .collect(Collectors.toList()));
        } catch (IOException e) {
            throw new IOException("Failed to list directory entries: " + directory, e);
        }
    }

    private static boolean isSafeToProcess(DirectoryEntry entry) {
        String fileName = entry.getName();
        return !fileName.contains(".exe") && !fileName.endsWith(".sh") && !fileName.endsWith(".class");
    }

    private static Supplier<String> generateRandomUrl(String fileName) {
        // return () -> "file:\\" + Base64.getEncoder().encodeToString(fileName.getBytes());

        /*// Process each path/url using Java 8 Futures.
        Future<byte[][]> futures = CompletableFuture.supplyAsync(() -> {
            try {
                return pathsAndUrls.stream()
                        .map(item -> processItem(item))
                        .collect(Collectors.toList());
            } catch (IOException e) {
                throw new RuntimeException("Error processing items", e);
            }
        });*/

        return () -> processItem(fileName);
    }

    private static String processItem(String itemName) {
        return "http://127.0.0.1:8000/files?data=" + Base64.getUrlEncoder()
                .encodeToString(itemName.getBytes(StandardCharsets.UTF_8));
    }
}