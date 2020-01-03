package com.example.signupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button BtnSUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnSUp = findViewById(R.id.BtnSUp);
        BtnSUp.setOnClickListener(this);

    }

    @Override
    public void onClick (View view) {
        switch (view.getId()){
            case R.id.BtnSUp:
                Intent SUp = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(SUp);
                break;
        }
    }
}
