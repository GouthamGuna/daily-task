package main.security;

import java.util.Base64;

public class CryptographyServiceImpl implements CryptographyService {
    @Override
    public void encodeStringUsingTheBasicBase64(String originalInput) {

        String encodedString = Base64.getEncoder().encodeToString( originalInput.getBytes() );

        System.out.println( "encodedString = " + encodedString );
    }

    @Override
    public void decodeStringUsingTheBasicBase64(String encodedString) {

        byte[] decodedBytes = Base64.getDecoder().decode( encodedString );
        String decodedString = new String( decodedBytes );

        System.out.println( "decodedString = " + decodedString );
    }

    @Override
    public void encodeURLAndFileNameBase64(String originalURI) {

        String encodedUrl = Base64.getUrlEncoder().encodeToString( originalURI.getBytes() );

        System.out.println( "encodedUrl = " + encodedUrl );
    }

    @Override
    public void decodeURLAndFileNameBase64(String encodedUrl) {
        byte[] decodedBytes = Base64.getUrlDecoder().decode( encodedUrl );
        String decodedUrl = new String( decodedBytes );

        System.out.println( "decodedUrl = " + decodedUrl );
    }

    @Override
    public void encodeStringUsingMIMETypeBase64(String originalInput) {

        String encodedString = Base64.getMimeEncoder().encodeToString(originalInput.getBytes());

        System.out.println( "encodedString MIME = " + encodedString );
    }

    @Override
    public void decodeStringUsingMIMETypeBase64(String encodedString) {

        byte[] decodedBytes = Base64.getMimeDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);

        System.out.println( "decodedString MIME = " + decodedString );
    }
}
