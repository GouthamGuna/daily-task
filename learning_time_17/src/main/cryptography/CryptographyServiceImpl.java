package main.cryptography;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
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
                .mapToObj( c -> String.valueOf( (char) Integer.parseInt( "" + (char) c + (char) c, 16 ) ) )
                .collect( Collectors.joining() );

        System.out.println( "streamASCII = " + streamASCII );
    }

    /**
     * SHA256 Cryptographic Function
     * <p>
     * SHA-256 is a member of the SHA-2 family of cryptographic hash functions and is considered to be one of the most secure hashing algorithms available.
     * It produces a 256-bit hash value, which is very difficult to brute-force or crack.
     */

    @Override
    public void SHA256Example(String credential) {

        try {
            MessageDigest digest = MessageDigest.getInstance( "SHA-256" );
            digest.update( credential.getBytes() );

            byte[] hash = digest.digest();
            String hexString = new String( hash );

            System.out.println( "hexString = " + hexString );
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException( e );
        }
    }

    /**
     * MessageDigest Class in Java
     * <p>
     * The SHA (Secure Hash Algorithm) is one of the popular cryptographic hash functions.
     * A cryptographic hash can be used to make a signature for a text or a data file.
     * <p>
     * The SHA-256 algorithm generates an almost unique, fixed-size 256-bit (32-byte) hash.
     * This is a one-way function, so the result cannot be decrypted back to the original value.
     * <p>
     * Currently, SHA-2 hashing is widely used, as it is considered the most secure hashing algorithm in the cryptographic arena.
     */

    @Override
    public void SHA256StandardCharsets(String credential) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance( "SHA-256" );
            byte[] encodedHash = digest.digest(
                    credential.getBytes( StandardCharsets.UTF_8 ) );
            System.out.println( "encodedHash = " + Arrays.toString( encodedHash ) );

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException( e );
        }
    }

    @Override
    public byte[] SHA256StandardCharsetsExOne(String credential) {
        MessageDigest digest = null;
        byte[] encodedHash;

        try {
            digest = MessageDigest.getInstance( "SHA-256" );
            encodedHash = digest.digest(
                    credential.getBytes( StandardCharsets.UTF_8 ) );

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException( e );
        }

        return encodedHash;
    }

    /**
     * # bytesToHex :
     * <p>
     * However, here we have to use a custom byte to hex converter to get the hashed value in hexadecimal.
     * <p>
     * We need to be aware that the MessageDigest is not thread-safe.
     * Consequently, we should use a new instance for every thread.
     */
    @Override
    public void SHA256CustomHashedValue(byte[] hash) {

        StringBuilder hexString = new StringBuilder( 2 * hash.length );

        for (byte b : hash) {
            String hex = Integer.toHexString( 0xff & b ); // 255
            if (hex.length() == 1) {
                hexString.append( '0' );
            }
            hexString.append( hex );
        }

        System.out.println( "hexString = " + hexString );
    }
}
