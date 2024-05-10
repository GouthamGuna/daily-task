package main.general;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FileDownload {

    public static void main(String[] args) {
        //downloadTheResponse();
        //System.out.println("response = " + fetchMetaDataFromApplicationUseAsync());
        System.out.println("response = " + fetchMetaFromApplication());
    }

    public static void downloadTheResponse() {
        try {
            String requestURL = "https://javacodegeeks.tradepub.com/?p=w_merg14&w=d&email=1030abfd3e2a1c8a8779f620150c7f69&key=gXICopakZvfvRqwLJKNJ&ts=39299&u=1520582301081714839236&e=Z293dGhhbXNhbmthci5nQGNlcnBzb2Z0Lmlu&secure=1&_afn=0";

            URL url = new URL(requestURL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            int responseCode = httpURLConnection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = httpURLConnection.getInputStream();
                FileOutputStream outputStream = new FileOutputStream("C:\\Users\\ggowt\\Downloads\\Enterprise Transformation to AI.zip");

                int bytesRead = 0;
                byte[] buffer = new byte[4096];
                while ((bytesRead == inputStream.read(buffer))) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                outputStream.close();
                inputStream.close();
                System.out.println("File downloaded successfully...");
            } else {
                System.out.println("No File to downloaded. Server replied HTTP code : " + responseCode);
            }
            httpURLConnection.disconnect();
        } catch (Exception e) {
            throw new RuntimeException("Error Occurs...." + e);
        }
    }

    public static String fetchMetaFromApplication() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://sms.cerpsoft.in/education/login.do?method=getLinkedDataFormat"))
                    .header("content-type", "application/json")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            return HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (Exception e) {
            throw new RuntimeException("Some thing went wrong : " + e);
        }
    }

    public static String fetchMetaDataFromApplicationUseAsync() {
        try (AsyncHttpClient client = new DefaultAsyncHttpClient()) {

            return client.prepare("GET", "http://sms.cerpsoft.in/education/login.do?method=getLinkedDataFormat")
                    .setHeader("content-type", "application/json")
                    .execute()
                    .toCompletableFuture()
                    .thenApplyAsync(response -> response).join().toString();
        } catch (Exception e) {
            throw new RuntimeException("Some thing went wrong : " + e);
        }
    }
}
