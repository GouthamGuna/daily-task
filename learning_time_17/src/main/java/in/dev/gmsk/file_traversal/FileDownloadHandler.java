package in.dev.gmsk.file_traversal;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

import static java.lang.System.err;
import static java.lang.System.out;

public class FileDownloadHandler {

    public CompletableFuture<Void> handleRequestAndDownloadFile(HttpServletRequest request) {
        return CompletableFuture.runAsync(() -> {
            try {
                Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
                InputStream fileContent = filePart.getInputStream();

                // Copy the input stream to a file
                Files.copy(fileContent, Paths.get(fileName), StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                err.println(e.getMessage());
            }
        });
    }

    CompletableFuture<Void> handleUploadedFiles(List<File> uploadedFiles) {
        return CompletableFuture.runAsync(() -> {
            List<String> fileNames = uploadedFiles.stream()
                    .map(File::getName)
                    .toList();

            // Example: Processing files (replace with actual logic).
            fileNames.stream()
                    .filter(this::isValidFileName)
                    .forEach(fileName -> {
                        File processedFile = processFile(fileNames.get(0));
                        // Further processing, like storing the result back to storage or doing some computation
                        out.println("Processed file: " + fileName);
                        out.println("Processed processedFile : " + processedFile);
                    });
        }, Executors.newCachedThreadPool());
    }

    private File processFile(String s) {
        return new File(s);
    }

    private boolean isValidFileName(String fileName) {
        return true;
    }

    public void runner(HttpServletResponse response) {
        try (ByteArrayOutputStream outByteStream = new ByteArrayOutputStream()) {
            byte[] outArray = outByteStream.toByteArray();
            response.setContentType("application/octet-stream");
            response.setContentLength(outArray.length);
            response.setHeader("Expires:", "0"); // eliminates browser caching
            response.setHeader("Content-Disposition", "attachment; filename=" + "-FeeDefaulterReport.xlsx");
            OutputStream outStream = response.getOutputStream();
            outStream.write(outArray);
            outStream.flush();
        } catch (Exception e) {
            err.println(e.getMessage());
        }

        // HttpServletRequest
    }
}

