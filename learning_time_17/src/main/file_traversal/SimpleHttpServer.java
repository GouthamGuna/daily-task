package main.file_traversal;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import jakarta.servlet.http.HttpServletResponse;
import main.model.DirectoryEntry;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

import static java.lang.System.err;
import static java.lang.System.out;


public class SimpleHttpServer {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/", new MyHandler());
        server.createContext("/files", new fileDownloader());
        server.setExecutor(null); // Use the default executor
        server.start();
        System.out.println("Server is running on port 8000");
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            try {
                List<DirectoryEntry> response = FileTraversal.
                        asCompletableFutureOfDirectoryEntries(new File("D:\\accounts_sms_api")).get();

                String json = new Gson().toJson(response);

                exchange.sendResponseHeaders(200, json.length());
                OutputStream os = exchange.getResponseBody();
                os.write(json.getBytes());
                os.close();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static class fileDownloader implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {

            System.out.println("exchange.getRequestURI(); " + exchange.getRequestURI());

            String requestURI = exchange.getRequestURI().toString();

            String s = requestURI.split("=")[1];
            System.out.println("s = " + s);

            byte[] decodedBytes = Base64.getUrlDecoder().decode(s);
            String decodedUrl = new String(decodedBytes);

            System.out.println("encodedUrl = " + decodedUrl);

            File file = new File(decodedUrl);
            byte[] fileContent = readFileToByteArray(file);

            // Serve the byte array as a downloadable file
            serveFileAsDownload(fileContent, "downloaded_file", exchange);

                /*try (Stream<Path> paths = Files.walk(Paths.get(decodedUrl))) {

                    paths.filter(Files::isRegularFile)
                            .forEach(f -> {
                                try (InputStream fileInputStream = new FileInputStream(f.toFile())) {
                                    byte[] buffer = new byte[1024];
                                    int bytesRead;
                                    while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                                        // outputStreamWriter.write(Arrays.toString(buffer), 0, bytesRead);

                                    }
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            });
                } catch (Exception e) {
                    err.println(e.getMessage());
                }*/
        }

        private static byte[] readFileToByteArray(File file) throws IOException {
            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] buffer = new byte[(int) file.length()];
                fis.read(buffer);
                return buffer;
            }
        }

        private static void serveFileAsDownload(byte[] content, String fileName, HttpExchange response)
                throws IOException {

            response.sendResponseHeaders(200, content.length);
            OutputStream os = response.getResponseBody();
            os.write(content);
            os.close();

            /*response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
            response.getOutputStream().write(content);
            response.flushBuffer();*/
        }
    }
}


