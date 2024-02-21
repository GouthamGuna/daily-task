package main.security;

public class Main {
    private static final CryptographyService SERVICE = new CryptographyServiceImpl();

    public static void main(String[] args) {


        SERVICE.encodeStringUsingTheBasicBase64( "GMSK" ); // R01TSw==

        SERVICE.decodeStringUsingTheBasicBase64( "R01TSw==" );

        SERVICE.encodeURLAndFileNameBase64( "http://sms.cerpsoft.in/<App>/api.do?method=getLinkedMetaData" );

        SERVICE.decodeURLAndFileNameBase64( "aHR0cDovL3Ntcy5jZXJwc29mdC5pbi9wZWFybC9hcGkuZG8_bWV0aG9kPWdldExpbmtlZE1ldGFEYXRh" );

        SERVICE.encodeStringUsingMIMETypeBase64( "GMSK" ); // R01TSw==

        SERVICE.decodeStringUsingMIMETypeBase64( "R01TSw==" );
    }
}
