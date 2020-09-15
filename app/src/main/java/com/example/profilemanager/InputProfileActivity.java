package com.example.profilemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class InputProfileActivity extends AppCompatActivity {

    Button btn_back;
    Button btn_save;

    EditText edit_firstname;
    TextView tv_feedbackMsg_firstname;

    EditText edit_lastname;
    TextView tv_feedbackMsg_lastname;

    EditText edit_phone;
    TextView tv_feedbackMsg_phone;

    Spinner spinner_city;

    User User = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_profile);

        this.Initialize();

        Bundle arguments = getIntent().getExtras();
        User = (User) arguments.getSerializable("user");
        if (User != null)
            this.FillFiedls(User);

        edit_firstname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                InputProfileActivity
                        .this
                        .setFeedbackMessage(edit_firstname, tv_feedbackMsg_firstname);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        edit_lastname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                InputProfileActivity
                        .this
                        .setFeedbackMessage(edit_lastname, tv_feedbackMsg_lastname);
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
                        .setFeedbackMessage(edit_phone, tv_feedbackMsg_phone);
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

                if(UserValidator.isUserValid(firstname,lastname,phone))  {
                    User = new User(firstname, lastname, phone, city);
                }
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InputProfileActivity.this,
                        MainActivity.class);

                intent.putExtra("user", User);

                startActivity(intent);
            }
        });
    }
    //..............................................................................................
    private void Initialize() {
        this.InitializeBtn();
        this.InitializeEdt();
        this.InitializeTv();
        this.InitializeSpnr();
    }
    //..............................................................................................
    private void InitializeBtn() {
        btn_back = findViewById(R.id.btn_back);
        btn_save = findViewById(R.id.btn_save);
    }
    //..............................................................................................
    private void InitializeEdt() {
        edit_firstname = findViewById(R.id.edt_firstname);
        edit_lastname = findViewById(R.id.edt_lastname);
        edit_phone = findViewById(R.id.edt_phone);
    }
    //..............................................................................................
    private void InitializeTv() {
        tv_feedbackMsg_firstname
                = findViewById(R.id.tv_feedbackMessage_firstname);
        tv_feedbackMsg_lastname
                = findViewById(R.id.tv_feedbackMessage_lastname);
        tv_feedbackMsg_phone
                = findViewById(R.id.tv_feedbackMessage_phone);
    }
    //..............................................................................................
    private void InitializeSpnr() {
        spinner_city = findViewById(R.id.spinner_city);
    }
    //..............................................................................................
    private void setColorEdtValid(EditText edt) {
        edt.getBackground().mutate()
                .setColorFilter(getResources()
                        .getColor(R.color.colorDeepOrange), PorterDuff.Mode.SRC_ATOP);
    }
    //..............................................................................................
    private void setColorEdtInvalid(EditText edt) {
        edt.getBackground().mutate()
                .setColorFilter(getResources()
                        .getColor(R.color.colorRed), PorterDuff.Mode.SRC_ATOP);
    }
    //..............................................................................................
    private void setFeedbackMessage(EditText editText, TextView textView) {
        String feedbackMessage = ValidatorHelper.getValidatedFeedbackMsg(editText);

        if (feedbackMessage.equals(ValidatorHelper.isValid))
            InputProfileActivity.this.setColorEdtValid(editText);
        else
            InputProfileActivity.this.setColorEdtInvalid(editText);

        textView.setText(feedbackMessage);
    }
    //..............................................................................................
    protected void FillFiedls(User user) {
        edit_firstname.setText(user.Firstname);
        edit_lastname.setText(user.Lastname);
        edit_phone.setText(user.Phone);

        for (int i = 0; i < spinner_city.getCount(); i++) {
            if (spinner_city.getItemAtPosition(i).equals(user.City)) {
                spinner_city.setSelection(i);
                break;
            }
        }
    }
}
