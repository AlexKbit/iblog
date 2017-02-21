package com.alexkbit.iblog.services.impl.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Test for {@link PasswordUtility}
 */
@RunWith(JUnit4.class)
public class PasswordUtilityTest {

    private static final String EMAIL_1 = "user1@mail.com";
    private static final String EMAIL_2 = "user2@mail.com";
    private static final byte[] PASSWORD_1 = "qwerty123".getBytes();
    private static final byte[] PASSWORD_2 = "asdfgh123".getBytes();

    @Test
    public void testDifferentPasswords() {
        String hash1 = PasswordUtility.encryptPassword(PASSWORD_1, EMAIL_1);
        String hash2 = PasswordUtility.encryptPassword(PASSWORD_2, EMAIL_2);
        assertFalse(hash1.equals(hash2));
    }

    @Test
    public void testTheSamePassword() {
        String hash1 = PasswordUtility.encryptPassword(PASSWORD_1, EMAIL_1);
        String hash2 = PasswordUtility.encryptPassword(PASSWORD_1, EMAIL_2);
        assertFalse(hash1.equals(hash2));
    }

    @Test
    public void testTheSameEmail() {
        String hash1 = PasswordUtility.encryptPassword(PASSWORD_1, EMAIL_1);
        String hash2 = PasswordUtility.encryptPassword(PASSWORD_2, EMAIL_1);
        assertFalse(hash1.equals(hash2));
    }

    @Test
    public void testHash() {
        String hash1 = PasswordUtility.encryptPassword(PASSWORD_1, EMAIL_1);
        String hash2 = PasswordUtility.encryptPassword(PASSWORD_1, EMAIL_1);
        assertTrue(hash1.equals(hash2));
    }

}