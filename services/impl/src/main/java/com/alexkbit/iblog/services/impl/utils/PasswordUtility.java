package com.alexkbit.iblog.services.impl.utils;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Utility for calculate hash and encrypt password
 */
public class PasswordUtility {

    public static String encryptPassword(final byte[] password, String salt) {
        return new String(hashPassword(password, salt, 10, 32));
    }

    public static byte[] hashPassword(final byte[] password, final String salt, final int iterations, final int keyLength ) {
        char[] pwdChars = new String(password).toCharArray();
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance( "PBKDF2WithHmacSHA512" );
            PBEKeySpec spec = new PBEKeySpec(pwdChars, salt.getBytes(), iterations, keyLength );
            SecretKey key = skf.generateSecret( spec );
            byte[] res = key.getEncoded( );
            return res;

        } catch( NoSuchAlgorithmException | InvalidKeySpecException e ) {
            throw new RuntimeException( e );
        }
    }

}
