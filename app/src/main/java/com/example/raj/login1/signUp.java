package com.example.raj.login1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signUp extends AppCompatActivity {
    EditText firstname,lastname,mobile,password;
    dbmsAdapter help;
    Button sup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firstname=(EditText)findViewById(R.id.editFirstName);
        lastname=(EditText)findViewById(R.id.editLastName);
        mobile=(EditText)findViewById(R.id.editMobileNo);
        password=(EditText)findViewById(R.id.editPassword);
        sup=(Button)findViewById(R.id.signUp);
        help=new dbmsAdapter(this);

    }

    public void addUser(View view){
        String f= firstname.getText().toString();
        String l= lastname.getText().toString();
        String p = password.getText().toString();
        long m = Long.parseLong(mobile.getText().toString());
        Long id = help.insertData(f,l,p,m);

        if(id<0){
            Toast.makeText(this,"UnSuccesful",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"Succesful",Toast.LENGTH_LONG).show();
        }
    }
}
