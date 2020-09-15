package com.example.profilemanager;

import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {

    public static final String firstnameFeedbackMessage="First Name invalid";
    public static final String lastnameFeedbackMessage="Last Name invalid";
    public static final String phoneFeedbackMessage="Phone invalid";

    public static boolean isUserValid(String firstname, String lastname, String phone) {
        return (    isFirstnameValid(firstname)
                 && isLastnameValid(lastname)
                 && isPhoneValid(phone));
    }

    public static boolean isFirstnameValid(String firstname) {
        final String patternRule = "^[a-zA-Z]+$";

        Pattern pattern = Pattern.compile(patternRule);
        Matcher matcher = pattern.matcher(firstname);

        return matcher.matches();
    }

    public static boolean isLastnameValid(String lastname) {
        final String patternRule = "^[a-zA-Z]+$";

        Pattern pattern = Pattern.compile(patternRule);
        Matcher matcher = pattern.matcher(lastname);

        return matcher.matches();
    }

    public static boolean isPhoneValid(String phone) {
        final String patternRule = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";

        Pattern pattern = Pattern.compile(patternRule);
        Matcher matcher = pattern.matcher(phone);

        return matcher.matches();
    }
}