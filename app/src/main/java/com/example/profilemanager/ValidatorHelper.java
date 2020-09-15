package com.example.profilemanager;

import android.widget.EditText;

public class ValidatorHelper {

    public static final String isValid = "";

    public static String getValidatedFeedbackMsg(EditText editText) {
        String text = editText.getText().toString();
        switch (editText.getId()) {
            case R.id.edt_firstname:
                return UserValidator.isFirstnameValid(text)?
                        isValid : UserValidator.firstnameFeedbackMessage;

            case R.id.edt_lastname:
                return UserValidator.isLastnameValid(text)?
                        isValid : UserValidator.lastnameFeedbackMessage;

            case R.id.edt_phone:
                return UserValidator.isPhoneValid(text)?
                        isValid :UserValidator.phoneFeedbackMessage;
        }
        return "";
    }
}
