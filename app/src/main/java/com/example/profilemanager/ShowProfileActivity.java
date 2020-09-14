package com.example.profilemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_profile);
        Intent intent = getIntent();
        String firstname = intent.getStringExtra("firstname");

        TextView tv_firstname = findViewById(R.id.tv_firstname);
        tv_firstname.setText(firstname);
        Button btn_back = findViewById(R.id.btn_back);





        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowProfileActivity.this,
                        MainActivity.class);
                startActivity(intent);
            }
        });
    }
}