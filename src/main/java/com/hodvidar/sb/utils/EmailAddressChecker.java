package com.hodvidar.sb.utils;

import java.util.regex.Pattern;

public class EmailAddressChecker {

    private static final String MAIL_REGEX = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    private static final Pattern MAIL_PATTERN = Pattern.compile(MAIL_REGEX);

    public static boolean isEmailValid(String email) {
        if (email == null) {
            return false;
        }
        return MAIL_PATTERN.matcher(email).matches();
    }
}
