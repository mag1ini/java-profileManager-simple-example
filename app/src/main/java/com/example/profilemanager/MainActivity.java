package com.example.profilemanager;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MotionEvent;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.profilemanager.User;

public class MainActivity extends AppCompatActivity {

    public User User = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_fillProfile = findViewById(R.id.btn_fillProfile);
        Button btn_showProfile = findViewById(R.id.btn_showProfile);


        Bundle arguments = getIntent().getExtras();

        if (arguments!= null) {
            User = (User) arguments.getSerializable("user");
        }


        btn_fillProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        InputProfileActivity.class);
                intent.putExtra("user",User);
                startActivity(intent);
            }
        });

        btn_showProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        ShowProfileActivity.class);
                intent.putExtra("user",User);
                startActivity(intent);
            }
        });


    }


}