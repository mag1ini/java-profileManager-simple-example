package com.example.profilemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ShowProfileActivity extends AppCompatActivity {

    User User;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_profile);

        Button btn_back = findViewById(R.id.btn_back);

        Bundle arguments = getIntent().getExtras();
        User = (User) arguments.getSerializable("user");
        if (User!=null)
            FillTextViewsFiedls(User);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowProfileActivity.this,
                        MainActivity.class);
                if (User!=null)
                    intent.putExtra("user",User);
                startActivity(intent);
            }
        });
    }

    protected void FillTextViewsFiedls(User user) {
        TextView tv_firstname = findViewById(R.id.tv_firstname);
        tv_firstname.setText(user.Firstname);

        TextView tv_lastname = findViewById(R.id.tv_lastname);
        tv_lastname.setText(user.Lastname);

        TextView tv_phone = findViewById(R.id.tv_phone);
        tv_phone.setText(user.Phone);

        TextView tv_city = findViewById(R.id.tv_city);
        tv_city.setText(user.City);


    }
}