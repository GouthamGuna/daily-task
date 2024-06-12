package main.cryptography;

public class Main {
    private static final CryptographyService SERVICE = new CryptographyServiceImpl();

    public static void main(String[] args) {


        SERVICE.encodeStringUsingTheBasicBase64("GMSK"); // R01TSw==

        SERVICE.decodeStringUsingTheBasicBase64("R01TSw==");

        SERVICE.encodeURLAndFileNameBase64("http://sms.cerpsoft.in/<App>/api.do?method=getLinkedMetaData");

        SERVICE.decodeURLAndFileNameBase64("aHR0cDovL3Ntcy5jZXJwc29mdC5pbi9wZWFybC9hcGkuZG8_bWV0aG9kPWdldExpbmtlZE1ldGFEYXRh");

        SERVICE.encodeStringUsingMIMETypeBase64("GMSK"); // R01TSw==

        SERVICE.decodeStringUsingMIMETypeBase64("R01TSw==");

        SERVICE.ASCIIToHexConverter("TCS"); // 544353

        SERVICE.HexToASCIIConverter("544353");

        SERVICE.SHA256Example("admin@123");

        SERVICE.SHA256StandardCharsets("admin@123");

        SERVICE.SHA256CustomHashedValue(SERVICE.SHA256StandardCharsetsExOne("admin@123"));

        SERVICE.CaesarCipherEncrypt("admin@123", "asus"); // AVGAN@123

        SERVICE.CaesarCipherDecrypt("AVGAN@123", "asus");
    }
}
