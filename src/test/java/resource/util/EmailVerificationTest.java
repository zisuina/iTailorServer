package resource.util;

import org.junit.Test;
import util.EmailVerification;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;


/**
 * Created by liker on 24/07/2015 0024.
 * Group iTailor.hunters.neu.edu.cn
 */
public class EmailVerificationTest {

    @Test
    public void testIsEmail() throws Exception {
        assertTrue(EmailVerification.isValid("liker.xu@foxmail.com"));
        assertTrue(EmailVerification.isValid("_123@foxmail.com"));
        assertFalse(EmailVerification.isValid("hunters.com"));
    }
}