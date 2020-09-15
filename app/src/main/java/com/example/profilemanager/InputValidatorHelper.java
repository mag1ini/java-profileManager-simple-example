package com.example.profilemanager;

import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidatorHelper {

    public static final String isValid = "";
    private static final String firstnameFeedbackMessage="First Name invalid";
    private static final String lastnameFeedbackMessage="Last Name invalid";
    private static final String phoneFeedbackMessage="Phone invalid";

    public String Validate(EditText editText) {
        String textToValidate = editText.getText().toString();
        switch (editText.getId()) {
            case R.id.edt_firstname:
                return this.ValidateFirstname(textToValidate);

            case R.id.edt_lastname:
                return this.ValidateLastname(textToValidate);

            case R.id.edt_phone:
                return this.ValidatePhone(textToValidate);
        }
        return "edt not found";
    }

    private String ValidateFirstname(String firstname) {
        final String patternRule = "^[a-zA-Z]+$";

        Pattern pattern = Pattern.compile(patternRule);
        Matcher matcher = pattern.matcher(firstname);

        return matcher.matches()? isValid : firstnameFeedbackMessage;
    }

    private String ValidateLastname(String lastname) {
        final String patternRule = "^[a-zA-Z]+$";

        Pattern pattern = Pattern.compile(patternRule);
        Matcher matcher = pattern.matcher(lastname);

        return matcher.matches()? isValid : lastnameFeedbackMessage;
    }

    private String  ValidatePhone(String phone) {
        final String patternRule = "^(\\s*)?(\\+)?([- _():=+]?\\d[- _():=+]?){10,14}(\\s*)?$";

        Pattern pattern = Pattern.compile(patternRule);
        Matcher matcher = pattern.matcher(phone);

        return matcher.matches()? isValid : phoneFeedbackMessage;
    }
}