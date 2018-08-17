package club.tempvs.rest.auth;

import java.math.BigInteger;
import java.security.MessageDigest;

public class TokenHelper {

    private String tokenHash;

    public TokenHelper() {
        this.tokenHash = generateHash(System.getenv("TOKEN"));
    }

    public TokenHelper(String token) {
        this.tokenHash = generateHash(token);
    }

    public String getTokenHash() {
        return this.tokenHash;
    }

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
