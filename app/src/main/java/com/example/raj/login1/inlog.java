package com.example.raj.login1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class inlog extends AppCompatActivity {
    EditText eMobile,ePassword;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inlog);

        eMobile =(EditText)findViewById(R.id.editMobileNo);
        ePassword = (EditText)findViewById(R.id.editPassword);
        b=(Button)findViewById(R.id.buttonLogIn);
    }

    public void checkIn(View v){

    }
}
