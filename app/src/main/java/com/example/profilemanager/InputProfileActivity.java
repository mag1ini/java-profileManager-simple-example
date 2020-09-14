package com.example.profilemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputProfileActivity extends AppCompatActivity {

    EditText edit_firstname;
    EditText edit_lastname;
    EditText edit_phone;
    EditText edit_city;

    User User;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_profile);

        Button btn_back = findViewById(R.id.btn_back);
        Button btn_save = findViewById(R.id.btn_save);

        Bundle arguments = getIntent().getExtras();
        if (arguments!= null) {
            User = (User) arguments.getSerializable("user");
        }

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_firstname = findViewById(R.id.edt_firstname);
                String firstname = edit_firstname.getText().toString();

                edit_lastname = findViewById(R.id.edt_lastname);
                String lastname = edit_lastname.getText().toString();

                edit_phone = findViewById(R.id.edt_phone);
                String phone = edit_phone.getText().toString();

                edit_city = findViewById(R.id.edt_city);
                String city = edit_city.getText().toString();

                User = new User(firstname,lastname,phone,city);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InputProfileActivity.this,
                        MainActivity.class);
                if (User!=null)
                    intent.putExtra("user",User);

                startActivity(intent);
            }
        });

    }

}