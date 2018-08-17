package club.tempvs.rest.auth;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * An authentication helper for MD5 hashed tokens handling.
 */
public class TokenHelper {

    private String tokenHash;

    /**
     * Parameterless constructor that takes the "TOKEN" env variable and converts it to MD5 for further usage.
     */
    public TokenHelper() {
        this.tokenHash = generateHash(System.getenv("TOKEN"));
    }

    /**
     * A constructor that accepts a token as a parameter and converts it to MD5 hash for further usage.
     * @param token
     */
    public TokenHelper(String token) {
        this.tokenHash = generateHash(token);
    }

    /**
     * A simple getter.
     * @return tokenHash field value.
     */
    public String getTokenHash() {
        return this.tokenHash;
    }

    /**
     * A method that receives the auth key and compares it with tokenHash field value. In case of mismatching
     * {@link AuthenticationException} is thrown.
     * @param receivedToken
     */
    public void authenticate(String receivedToken) {
        if (receivedToken == null || !receivedToken.equals(tokenHash)) {
            throw new AuthenticationException();
        }
    }

    private static String generateHash(String token) {
        if (token == null) {
            return null;
        }

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] tokenBytes = token.getBytes("UTF-8");
            byte[] digest = messageDigest.digest(tokenBytes);
            BigInteger number = new BigInteger(1, digest);
            return number.toString(16);
        } catch (Exception e) {
            return null;
        }
    }
}
