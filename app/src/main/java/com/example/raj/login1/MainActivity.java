package com.example.raj.login1;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login,sgnup,getall;
    dbmsAdapter hel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=(Button)findViewById(R.id.logIn);
        sgnup=(Button)findViewById(R.id.signUp);
        getall=(Button)findViewById(R.id.getAll);
        hel=new dbmsAdapter(this);
    }

    public void signup(View v){
        Intent in = new Intent(this,signUp.class);
        startActivity(in);
    }

    public void getAll(View v){
        String s= hel.getAllData();
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }

   public void login(View v) {
       Intent i = new Intent(this, inlog.class);
       startActivity(i);

   }
}
