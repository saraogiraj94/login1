package com.example.raj.login1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by raj on 5/11/15.
 */
public class dbmsAdapter {

    dbms helper;
    public dbmsAdapter(Context context){
        helper=new dbms(context);
    }

    public long insertData(String f,String l,String p,long m) {
        SQLiteDatabase db=helper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(dbms.FIRST_NAME, f);
        contentValues.put(dbms.SECOND_NAME,l);
        contentValues.put(dbms.MOBILE, m);
        contentValues.put(dbms.PASSWORD, p);

        long id = db.insert(dbms.TABLE_NAME,null,contentValues);
        return  id;

    }

    public long check(Long m,String p){
        SQLiteDatabase db = helper.getWritableDatabase();
        String [] column = {dbms.MOBILE};
        Log.d("check", "check() called with: " + "m = [" + m + "], p = [" + p + "]");
        long flag=0;
        Cursor cursor=db.query(dbms.TABLE_NAME,column,dbms.PASSWORD + " = '"+p+"'" ,null,null,null,null,null);
        Log.d("check", "check111() called with: " + "m = [" + m + "], p = [" + p + "]");
       while(cursor.moveToNext()){
           Integer index1=cursor.getColumnIndex(dbms.MOBILE);
           long mo = Long.parseLong(cursor.getString(index1));
           if(mo==m)
               flag=1;
       }
        return flag;
    }

    public String getAllData(){

        SQLiteDatabase db = helper.getWritableDatabase();
        String [] column = {dbms.SECOND_NAME,dbms.PASSWORD,dbms.FIRST_NAME,dbms.MOBILE};
        StringBuffer buffer = new StringBuffer();
        Cursor cursor=db.query(dbms.TABLE_NAME,column,null,null,null,null,null);
        while(cursor.moveToNext()) {
            int i1= cursor.getColumnIndex(dbms.SECOND_NAME);
            int i3= cursor.getColumnIndex(dbms.FIRST_NAME);
            int i2= cursor.getColumnIndex(dbms.PASSWORD);
            int i4= cursor.getColumnIndex(dbms.MOBILE);
            String s = cursor.getString(i1);
            String p = cursor.getString(i2);
            String f = cursor.getString(i3);
            long i = cursor.getLong(i4);

            buffer.append(f + " " + s + " " + " " + i + " " + p + "\n");
        }
            return buffer.toString();

    }

   static class dbms  extends SQLiteOpenHelper{
        private static final String DATABASE_NAME = "dbmsAdapter1.db";
        private static final String TABLE_NAME = "user";
        private static final int DATABASE_VERSION = 11;
        private static final String FIRST_NAME="FIRST_NAME";
        private static final String SECOND_NAME ="SECOND_NAME";
        private static final String PASSWORD = "PASSWORD";
        private static final String MOBILE="MOBILE_NO";
        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME + " ( "+SECOND_NAME +" VARCHAR(200) ," + PASSWORD +" VARCHAR(20) ," + FIRST_NAME + " VARCHAR(200) ,"+ MOBILE +" INTEGER(15) PRIMARY KEY );";

        Context context;

        public dbms(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context=context;
            Toast.makeText(context,"Constructor called",Toast.LENGTH_LONG).show();
          }
        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(CREATE_TABLE);
                Toast.makeText(context, "Table called", Toast.LENGTH_LONG).show();

            }catch (SQLException e){
                Toast.makeText(context,"ssage",Toast.LENGTH_LONG).show();}
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            try {
                db.execSQL("Drop table if exists " + TABLE_NAME + " ; ");
                Toast.makeText(context, "Table called on upgrade", Toast.LENGTH_LONG).show();
                onCreate(db);
            }catch (SQLException e){
                Toast.makeText(context,"Error",Toast.LENGTH_LONG).show();
            }


        }
    }
}



