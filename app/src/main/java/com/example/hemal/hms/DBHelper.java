package com.example.hemal.hms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hemal on 16/10/17.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "User.db";
    public static final String MAIN_TABLE =  "UserTable";
    public static final String CID = "ID";
    public static final String CNAME = "FullName";
    public static final String CMAIL = "Email";
    public static final String CAGE = "Age";
    public static final String CSEX = "Sex";
    public static final String CWEIGHT = "Weight";
    public static final String CHEIGHT = "Height";
    public static final String CPWD = "Pwd";


    public DBHelper(Context context) {
        super(context, DB_NAME , null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " +MAIN_TABLE+
                   " (ID INTEGER PRIMARY KEY AUTOINCREMENT,FULLNAME TEXT " +
                   ", EMAIL TEXT " +
                   ", AGE INTEGER " +
                   ", SEX TEXT " +
                   ", WEIGHT REAL " +
                   ", HEIGHT REAL " +
                   ", PWD TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+ MAIN_TABLE) ;
    }

    public boolean insertData(String n,String m,String p,String a,String s,String w,String h){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cV = new ContentValues();
        cV.put(CNAME,n);
        cV.put(CMAIL,m);
        cV.put(CPWD,p);
        cV.put(CAGE,a);
        cV.put(CSEX,s);
        cV.put(CWEIGHT,w);
        cV.put(CHEIGHT,h);
        long r = db.insert(MAIN_TABLE,null,cV);
        if(r==-1) return false;
        else return true;
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("Select * from "+MAIN_TABLE,null);
        return res;
    }
}
