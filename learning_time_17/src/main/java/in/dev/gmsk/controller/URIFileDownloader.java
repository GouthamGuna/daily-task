package in.dev.gmsk.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class URIFileDownloader {
    public static void main(String[] args) throws IOException {
        runner("<URL>", "C:\\Users\\ggowt\\Desktop\\");
    }

    static void runner(String URI, String filePath) throws IOException {

        File file = new File( filePath);
        file.getParentFile().mkdirs();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new URL(URI).openStream());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        int count = 0;
        byte[] b = new byte[1024];
        while ((count = bufferedInputStream.read(b)) != -1) {
            fileOutputStream.write(b, 0, count);
        }
    }
}
