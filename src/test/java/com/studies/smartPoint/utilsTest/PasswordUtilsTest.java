package com.studies.smartPoint.utilsTest;

import com.studies.smartPoint.utils.PasswordUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PasswordUtilsTest {

    private static final String password = "123456";
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Test
    public void testPasswordNull() throws Exception{
        assertNull(PasswordUtils.genetedBcrypt(null));
    }

    @Test
    public void testHashPassword() throws Exception{
        String hash = PasswordUtils.genetedBcrypt(password);
        assertTrue(bCryptPasswordEncoder.matches(password, hash));
    }
}
