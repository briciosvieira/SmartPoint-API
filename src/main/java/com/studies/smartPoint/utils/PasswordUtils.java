package com.studies.smartPoint.utils;

import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.logging.Logger;

public class PasswordUtils {
    private static final Logger log = (Logger) LoggerFactory.getLogger(PasswordUtils.class);

    public PasswordUtils(){

    }

    public static String genetedBcrypt(String password){
        if (password == null) {
            return password;
        }
        log.info("Gerando hash com  Bcrypt");
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }
}
