package com.example.raj.login1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class inlog extends AppCompatActivity {
    EditText eMobile,ePassword;
    Button b;
    dbmsAdapter help;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inlog);

        eMobile =(EditText)findViewById(R.id.editMobileNo);
        ePassword = (EditText)findViewById(R.id.editPassword);
        b=(Button)findViewById(R.id.buttonLogIn);
        help=new dbmsAdapter(this);
    }

    public void checkIn(View v){

        String pass = ePassword.getText().toString();
        Long no = Long.parseLong(eMobile.getText().toString());
        Log.d("checkin", "checkIn() returned: " + pass +" " + no);

       Long flag = help.check(no,pass);

        if(flag == 0) {
            Toast.makeText(this, "Data Not Correct", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this,"Successful Login",Toast.LENGTH_LONG).show();
        }
    }
}





