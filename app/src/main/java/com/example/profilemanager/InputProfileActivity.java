package com.example.profilemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import javax.xml.validation.Validator;

public class InputProfileActivity extends AppCompatActivity {

    EditText edit_firstname;
    TextView tv_feedbackMsg_firstname;

    EditText edit_lastname;
    TextView tv_feedbackMsg_lastname;

    EditText edit_phone;
    TextView tv_feedbackMsg_phone;

    Spinner spinner_city;

    User User = null;

    private void setValidColor(EditText editText) {
        Drawable drawable = edit_firstname.getBackground();
        drawable.setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);
        editText.setBackgroundDrawable(drawable);
    }

    private void setInvalidColor(EditText editText) {
        Drawable drawable = edit_firstname.getBackground();
        drawable.setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
        editText.setBackgroundDrawable(drawable);
    }

    private void setDefaultColor(EditText editText) {
        Drawable drawable = edit_firstname.getBackground();
        drawable.setColorFilter(Color.argb(25,255,100,255), PorterDuff.Mode.SRC_ATOP);
        editText.setBackgroundDrawable(drawable);
    }

    private void setFeedbackMessage(EditText editText, TextView textView ) {
        InputValidatorHelper validator = new InputValidatorHelper();

        String feedbackMessage = validator.Validate(editText);
        if (feedbackMessage.equals(validator.isValid))
            InputProfileActivity.this.setDefaultColor(editText);
        else
            InputProfileActivity.this.setInvalidColor(editText);

        textView.setText(feedbackMessage);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_profile);

        Button btn_back = findViewById(R.id.btn_back);
        Button btn_save = findViewById(R.id.btn_save);

        edit_firstname = findViewById(R.id.edt_firstname);
        tv_feedbackMsg_firstname
                = findViewById(R.id.tv_feedbackMessage_firstname);


        edit_lastname = findViewById(R.id.edt_lastname);
        tv_feedbackMsg_lastname
                = findViewById(R.id.tv_feedbackMessage_lastname);

        edit_phone = findViewById(R.id.edt_phone);
        tv_feedbackMsg_phone
                = findViewById(R.id.tv_feedbackMessage_phone);


        spinner_city = findViewById(R.id.spinner_city);

        Bundle arguments = getIntent().getExtras();
        User = (User) arguments.getSerializable("user");
        if (User!=null)
            this.FillFiedls(User);

        edit_firstname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                InputProfileActivity
                        .this
                        .setFeedbackMessage(edit_firstname,tv_feedbackMsg_firstname);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edit_lastname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                InputProfileActivity
                        .this
                        .setFeedbackMessage(edit_lastname,tv_feedbackMsg_lastname);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edit_phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                InputProfileActivity
                        .this
                        .setFeedbackMessage(edit_phone,tv_feedbackMsg_phone);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstname = edit_firstname.getText().toString();

                String lastname = edit_lastname.getText().toString();

                String phone = edit_phone.getText().toString();

                String city = spinner_city.getSelectedItem().toString();

                User = new User(firstname,lastname,phone,city);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InputProfileActivity.this,
                        MainActivity.class);
//                if (User!=null)
                    intent.putExtra("user",User);

                startActivity(intent);
            }
        });
    }

    protected void FillFiedls(User user) {
        edit_firstname.setText(user.Firstname);
        edit_lastname.setText(user.Lastname);
        edit_phone.setText(user.Phone);

        for(int i=0; i<spinner_city.getCount();i++) {
            if (spinner_city.getItemAtPosition(i).equals(user.City)) {
                spinner_city.setSelection(i);
                break;
            }
        }
    }

}