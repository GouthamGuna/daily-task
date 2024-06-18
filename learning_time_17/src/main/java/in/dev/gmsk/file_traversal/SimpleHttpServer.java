package in.dev.gmsk.file_traversal;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import in.dev.gmsk.model.DirectoryEntry;

import java.io.*;
import java.net.InetSocketAddress;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class SimpleHttpServer {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/", new MyHandler());
        server.createContext("/files", new fileDownloader());
        server.createContext("/upload", new FileUploadHandler());
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
            serveFileAsDownload(fileContent, exchange);

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

        private static void serveFileAsDownload(byte[] content, HttpExchange response)
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

    static class ParseFormURI implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            System.out.println("calling....");
            Map<String, String> stringStringMap = parseFormData(exchange);
            System.out.println("stringStringMap = " + stringStringMap);
        }
    }

    public static Map<String, String> parseFormData(HttpExchange exchange) throws IOException {
        Map<String, String> formData = new HashMap<>();
        InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), "utf-8");
        BufferedReader br = new BufferedReader(isr);
        String query = br.readLine();
        String[] pairs = query.split("&");
        for (String pair : pairs) {
            int idx = pair.indexOf("=");
            formData.put(java.net.URLDecoder.decode(pair.substring(0, idx), "UTF-8"), java.net.URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
        }
        return formData;
    }

    public static class FileUploadHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("POST".equals(exchange.getRequestMethod())) {
                CompletableFuture.runAsync(() -> {
                    try {
                        // Parse the request
                        InputStream inputStream = exchange.getRequestBody();
                        // You'll need to write a method to parse the multipart request and extract the file
                        File file = parseMultipartRequest(inputStream);

                        // Process the file as needed

                        // Send a response
                        String response = "File uploaded successfully...";
                        exchange.sendResponseHeaders(200, response.length());
                        OutputStream os = exchange.getResponseBody();
                        os.write(response.getBytes());
                        os.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            } else {
                exchange.sendResponseHeaders(405, -1); // Method Not Allowed
            }
        }

        private File parseMultipartRequest(InputStream inputStream) {
            // Implement parsing logic here
            System.out.println("inputStream = " + inputStream);
            return null;
        }
    }

}


