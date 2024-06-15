package in.dev.gmsk.general;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class BlobDownloader {

    public static void downloadBlobVideo(String blobUrl, String outputFilePath) {
        try {
            URL url = new URL( blobUrl );
            try (BufferedInputStream in = new BufferedInputStream( url.openStream() );
                 FileOutputStream fileOutputStream = new FileOutputStream( outputFilePath )) {
                byte dataBuffer[] = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read( dataBuffer, 0, 1024 )) != -1) {
                    System.out.println( "bytesRead = " + bytesRead + " : " + Thread.currentThread() );
                    fileOutputStream.write( dataBuffer, 0, bytesRead );
                }
            } catch (IOException e) {
                e.printStackTrace( System.err );
            }
        } catch (Throwable e) {
            System.out.println( "An error occurred during download: " + e.getMessage() );
        }
    }

    public static void main(String[] args) throws InterruptedException {

        String blobUrl = ""; // Replace with your blob URL
        String outputFilePath = "D:\\gmsk_rep\\output.mp4"; // Replace with your desired output file path

        LoopThread loopThread = new LoopThread();
        loopThread.start();
        loopThread.join();


        /*Thread thread = new Thread( () -> {

            String blobUrl = ""; // Replace with your blob URL
            String outputFilePath = "D:\\gmsk_rep\\output.mp4"; // Replace with your desired output file path
            downloadBlobVideo( blobUrl, outputFilePath );
            System.out.println( "Download completed successfully." );

        } );
        thread.start();
        thread.join();*/

    }
}

class LoopThread extends Thread {

    @Override
    public void run() {

        String blobUrl = ""; // Replace with your blob URL
        String outputFilePath = "D:\\gmsk_rep\\output.mp4"; // Replace with your desired output file path

        try {
            URL url = new URL( blobUrl );
            try (BufferedInputStream in = new BufferedInputStream( url.openStream() );
                 FileOutputStream fileOutputStream = new FileOutputStream( outputFilePath )) {
                byte dataBuffer[] = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read( dataBuffer, 0, 1024 )) != -1) {
                    System.out.println( "bytesRead = " + bytesRead + " : " + Thread.currentThread() );
                    fileOutputStream.write( dataBuffer, 0, bytesRead );
                }
            } catch (IOException e) {
                e.printStackTrace( System.err );
            }
        } catch (Throwable e) {
            System.out.println( "An error occurred during download: " + e.getMessage() );
        }
    }
}
