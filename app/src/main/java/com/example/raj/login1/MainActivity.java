package com.example.raj.login1;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button login,signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=(Button)findViewById(R.id.logIn);
        signup=(Button)findViewById(R.id.signUp);
    }

    public void signup(View v){
        Intent i = new Intent(this,signUp.class);
        startActivity(i);
    }

    public void login(View v){
        Intent i = new Intent(this,inlog.class);
        startActivity(i);
    }

}
