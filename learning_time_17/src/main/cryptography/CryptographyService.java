package main.cryptography;

public interface CryptographyService {

    void encodeStringUsingTheBasicBase64(String originalInput);

    void decodeStringUsingTheBasicBase64(String encodedString);

    void encodeURLAndFileNameBase64(String originalURI);

    void decodeURLAndFileNameBase64(String encodedUrl);

    void encodeStringUsingMIMETypeBase64(String originalInput);

    void decodeStringUsingMIMETypeBase64(String encodedString);

    void ASCIIToHexConverter(String originalInput);

    void HexToASCIIConverter(String asciiInputValues);

    void SHA256Example(String credential);

    void SHA256StandardCharsets(String credential);

    byte[] SHA256StandardCharsetsExOne(String credential);

    void SHA256CustomHashedValue(byte[] hash);

    void CaesarCipherEncrypt(String plainText, String keyword);

    void CaesarCipherDecrypt(String cipherText, String keyword);
}