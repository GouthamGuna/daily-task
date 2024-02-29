# SHA256 Apache Commons Codecs

 Apache Commons Codecs provides a convenient DigestUtils wrapper for the MessageDigest class.

 This library began to support SHA3-256 since version 1.11, and it requires JDK 9+ as well:

    String sha3Hex = new DigestUtils("SHA3-256").digestAsHex(originalString);