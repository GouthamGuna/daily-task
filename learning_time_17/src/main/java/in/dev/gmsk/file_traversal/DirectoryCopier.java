package in.dev.gmsk.file_traversal;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static java.lang.System.*;

public class DirectoryCopier {
    public static void copyDirectoryToServer(String sourceDir, String destinationDir, String targetServerUrl) {
        try {
            Path source = Paths.get(sourceDir);
            Path destination = Paths.get(destinationDir);

            Files.walk(source)
                    .forEach(sourcePath -> {
                        try {
                            Path targetPath = destination.resolve(source.relativize(sourcePath));
                            if (Files.isDirectory(sourcePath)) {
                                Files.createDirectories(targetPath);
                            } else {
                                Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
                                uploadFileToServer(targetPath.toString(), targetServerUrl);
                            }
                        } catch (IOException e) {
                            err.println(e.getMessage());
                        }
                    });
        } catch (IOException e) {
            err.println(e.getMessage());
        }
    }

    private static void uploadFileToServer(String filePath, String targetServerUrl) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(targetServerUrl);
            MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
            Path path = Paths.get(filePath);
            entityBuilder.addBinaryBody("file", path.toFile(), ContentType.APPLICATION_OCTET_STREAM, path.getFileName().toString());
            httpPost.setEntity(entityBuilder.build());

            // Execute the request and get the response
            HttpResponse response = httpClient.execute(httpPost);

            // Check the response status code
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                System.out.println("statusCode : "+statusCode);
                // Handle successful response & Process the response content if necessary
                String responseBody = EntityUtils.toString(response.getEntity());
                System.out.println("responseBody : "+responseBody);
            } else {
                System.err.println("Failed to upload file. Status code: " + statusCode);
            }

        } catch (IOException e) {
            err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        String sourceDir = "D:\\Music";
        String destinationDir = "C:\\Backup-Utils\\test";
        String targetServerUrl = "http://sms.cerpsoft.in:2427/upload"; // http://127.0.0.1:8000/upload
        copyDirectoryToServer(sourceDir, destinationDir, targetServerUrl);
    }
}
