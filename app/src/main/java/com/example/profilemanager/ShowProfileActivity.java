package com.example.profilemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowProfileActivity extends AppCompatActivity {

    User User;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_profile);

        TextView tv_firstname = findViewById(R.id.tv_firstname);
        Button btn_back = findViewById(R.id.btn_back);

        Bundle arguments = getIntent().getExtras();

        if (arguments!=null) {
            User = (User) arguments.getSerializable("user");
            tv_firstname.setText(User.Firstname);
        }

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowProfileActivity.this,
                        MainActivity.class);
                intent.putExtra("user",User);
                startActivity(intent);
            }
        });
    }
}