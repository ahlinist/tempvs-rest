package club.tempvs.rest.auth;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TokenHelperTest {

    private static final String TOKEN = "TOKEN";
    private static final String TOKEN_HASH = "94c8aa2452bccd82ee129b46f7c4be79";

    private TokenHelper tokenHelper;

    @Before
    public void setup() {
        tokenHelper = new TokenHelper(TOKEN);
    }

    @Test(expected = Test.None.class)
    public void testAuthenticate() {
        tokenHelper.authenticate(TOKEN_HASH);
    }

    @Test(expected = AuthenticationException.class)
    public void testAuthenticateForWrongToken() {
        tokenHelper.authenticate("wrong_token");
    }

    @Test
    public void testTokenMD5Generation() {
        assertEquals("TOKEN is converted to 94c8aa2452bccd82ee129b46f7c4be79", TOKEN_HASH, tokenHelper.getTokenHash());
    }
}
