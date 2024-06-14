package main.file_traversal;

import java.io.FileInputStream;
import java.io.InputStream;

public class _InputStreamExample {

    public static void main(String[] args) {
        readingDataFromFiles("D:\\accounts_sms_api\\pom.xml");
    }

    public static void readingDataFromFiles(String path) {
        try (InputStream inputStream = new FileInputStream(path)) {
            int data;
            while ((data = inputStream.read()) != -1) {
                System.out.print((char) data); // Process each data
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
