package com.example.kushagra.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Kushagra on 21-10-2017.
 */

public class Databasehelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME="student.db";
    public static final String TABLE_NAME="student";
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="CONTACT";
    public static final String COL_4="WARD";
    public static final String COL_5="EMAIL";
    public static final String COL_6="PASS";
    SQLiteDatabase db;



    public Databasehelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,CONTACT TEXT,WARD TEXT,EMAIL TEXT,PASS TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+ TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String name,String contact,String ward,String email,String pass)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,contact);
        contentValues.put(COL_4,ward);
        contentValues.put(COL_5,email);
        contentValues.put(COL_6,pass);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;

    }

    public String searchPass(String name)
    {
        db=this.getReadableDatabase();
        String query ="select NAME, PASS from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a,b = "not found";
        if(cursor.moveToFirst())
        {
            do{
                a=cursor.getString(0);

                if(a.equals(name))
                {
                    b=cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }

        return b;
    }


   /** public Cursor getAllData()
    {
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }*/

}
