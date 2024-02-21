package main.cryptography;

import java.util.Base64;
import java.util.SimpleTimeZone;
import java.util.stream.Collectors;

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

        String encodedString = Base64.getMimeEncoder().encodeToString( originalInput.getBytes() );

        System.out.println( "encodedString MIME = " + encodedString );
    }

    @Override
    public void decodeStringUsingMIMETypeBase64(String encodedString) {

        byte[] decodedBytes = Base64.getMimeDecoder().decode( encodedString );
        String decodedString = new String( decodedBytes );

        System.out.println( "decodedString MIME = " + decodedString );
    }

    @Override
    public void ASCIIToHexConverter(String originalInput) {

        StringBuilder forLoopHex = new StringBuilder();

        for (char c : originalInput.toCharArray()) {
            forLoopHex.append( Integer.toHexString( c ) );
        }

        System.out.println( "forLoopHex = " + forLoopHex );

        // Using Stream...

        String streamHex = originalInput.chars()
                .mapToObj( Integer::toHexString )
                .collect( Collectors.joining() );

        System.out.println( "streamHex = " + streamHex );
    }

    @Override
    public void HexToASCIIConverter(String asciiInputValues) {

        StringBuilder forLoopASCII = new StringBuilder();

        for (int i = 0; i < asciiInputValues.length(); i += 2) {

            String str = asciiInputValues.substring( i, i + 1 );
            forLoopASCII.append( (char) Integer.parseInt( str, 16 ) );
        }

        System.out.println( "forLoopASCII = " + forLoopASCII );

        // Using Stream...

        String streamASCII = asciiInputValues.chars()
                .mapToObj( c -> String .valueOf( (char) Integer.parseInt( "" + (char) c + (char) c, 16)) )
                .collect(Collectors.joining());

        System.out.println( "streamASCII = " + streamASCII );
    }
}
