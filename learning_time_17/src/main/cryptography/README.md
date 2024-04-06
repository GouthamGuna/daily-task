# SHA256 Apache Commons Codecs

 Apache Commons Codecs provides a convenient DigestUtils wrapper for the MessageDigest class.

 This library began to support SHA3-256 since version 1.11, and it requires JDK 9+ as well:

    String sha3Hex = new DigestUtils("SHA3-256").digestAsHex(originalString);

## How to use java Cipher class

 The Java Cipher class provides cryptographic encryption and decryption functionality

      import javax.crypto.Cipher;
      import javax.crypto.spec.SecretKeySpec;

      public class CipherExample {

         private static final String ALGORITHM = "AES";
         private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";

         public static void main(String[] args) throws Exception {
            String plaintext = "Hello, World!";
            String secretKey = "mysecretkey123";

            byte[] encryptedData = encrypt(plaintext, secretKey);
            String decryptedText = decrypt(encryptedData, secretKey);

            System.out.println("Encrypted Data: " + new String(encryptedData));
            System.out.println("Decrypted Text: " + decryptedText);
         }

         public static byte[] encrypt(String plaintext, String secretKey) throws Exception {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), ALGORITHM);

            // Initialize the Cipher for encryption
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] plaintextBytes = plaintext.getBytes();
            byte[] encryptedBytes = cipher.doFinal(plaintextBytes);

            return encryptedBytes;
         }

         public static String decrypt(byte[] encryptedData, String secretKey) throws Exception {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), ALGORITHM);

            // Initialize the Cipher for decryption
            cipher.init(Cipher.DECRYPT_MODE, key);

            byte[] decryptedBytes = cipher.doFinal(encryptedData);

            return new String(decryptedBytes);
         }
      }

 **[Cipher.html](https://docs.oracle.com/javase/7/docs/api///javax/crypto/Cipher.html)**

 **[A Guide to encryption and decryption in java](https://www.javacodegeeks.com/2024/04/a-guide-to-encryption-and-decryption-in-java.html)**