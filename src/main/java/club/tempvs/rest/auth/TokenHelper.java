package club.tempvs.rest.auth;

import java.math.BigInteger;
import java.security.MessageDigest;

public class TokenHelper {

    private static final String TOKEN = System.getenv("TOKEN");

    private String tokenHash;

    public TokenHelper() {
        this.tokenHash = generateHash(TOKEN);
    }

    public String getTokenHash() {
        return tokenHash;
    }

    private String generateHash(String token) {
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
