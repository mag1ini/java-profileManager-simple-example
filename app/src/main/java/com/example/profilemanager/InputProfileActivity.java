package com.example.profilemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputProfileActivity extends AppCompatActivity {

    EditText edit_firstname;
    User User;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_profile);

        Button btn_back = findViewById(R.id.btn_back);
        Button btn_save = findViewById(R.id.btn_save);

        Bundle arguments = getIntent().getExtras();

        User = (User) arguments.getSerializable("user");

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_firstname = findViewById(R.id.edt_firstname);
                String firstname = edit_firstname.getText().toString();
                User = new User(firstname);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InputProfileActivity.this,
                        MainActivity.class);
                intent.putExtra("user",User);

                startActivity(intent);
            }
        });
    }
}