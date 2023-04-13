package com.ahmed.test2sqldatabase;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDbHelper extends SQLiteOpenHelper
{
    private final static Integer DATABASE_VERSION=1;
    private final static String DATABASE_NAME="MyDatabase";
    private final static String TABLE_NAME="students";
    private final static String STUDENT_ID="id";
    private final static String STUDENT_NAME="name";
    private final static String STUDENT_PHONE="phone";
    private final static String STUDENT_ADDRESS="address";
    private final static String STUDENT_IMAGE="image";
    private final static String STUDENT_RATE="rate";

    public MyDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_QUERY= "CREATE TABLE "+ TABLE_NAME+ "("+ STUDENT_ID+" INTEGER PRIMARY KEY,"+ STUDENT_NAME +" VARCHAT(50),"+
                STUDENT_PHONE+ " VARCHAR(50),"+ STUDENT_ADDRESS+" VARCHAR(50),"+ STUDENT_IMAGE+ " INTEGER,"+
                STUDENT_RATE +" FLOAT);";
        db.execSQL(SQL_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL_QUERY="DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(SQL_QUERY);
        onCreate(db);
    }

    void addStudent (student student)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(STUDENT_NAME,student.getName());
        contentValues.put(STUDENT_ADDRESS,student.getAddress());
        contentValues.put(STUDENT_PHONE,student.getPhone());
        contentValues.put(STUDENT_RATE,student.getRate());
        contentValues.put(STUDENT_IMAGE,student.getImage());

        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
    }


    ArrayList<student> getAllStuednts(){
        ArrayList<student> studentLst= new ArrayList<>();
        SQLiteDatabase sqLiteDatabase= this.getReadableDatabase();
        String SQL_QUERY="SELECT * FROM "+TABLE_NAME;
        Cursor cursor= sqLiteDatabase.rawQuery(SQL_QUERY, null);
        if (cursor.moveToFirst()){
            do {
             @SuppressLint("Range") Integer id= cursor.getInt(cursor.getColumnIndex(STUDENT_ID));
             @SuppressLint("Range")    String name= cursor.getString(cursor.getColumnIndex(STUDENT_NAME));
             @SuppressLint("Range")    String address= cursor.getString(cursor.getColumnIndex(STUDENT_ADDRESS));
             @SuppressLint("Range")    String phone= cursor.getString(cursor.getColumnIndex(STUDENT_PHONE));
             @SuppressLint("Range")    Integer image= cursor.getInt(cursor.getColumnIndex(STUDENT_IMAGE));
             @SuppressLint("Range")    Float rate= cursor.getFloat(cursor.getColumnIndex(STUDENT_RATE));

             student myStudent= new student(id,name,address,phone,rate,image);
             studentLst.add(myStudent);
            }while (cursor.moveToNext());
        }



        return studentLst;
    }

}
