package com.example.sqlite_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "employees.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "employees";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_AGE = "age";

    public static final String query = "CREATE TABLE " + TABLE_NAME + " ( " + COLUMN_NAME + " TEXT NOT NULL, " + COLUMN_AGE + " INTEGER " + ")";


    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        onCreate(db);
    }

    // To insert data in the database

    public boolean insertData(String name, int age){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValue = new ContentValues();
        contentValue.put(COLUMN_NAME,name);
        contentValue.put(COLUMN_AGE,age);
        db.insert(TABLE_NAME,null,contentValue);
        return true;
    }

    // To retrieve all the data from the database

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res =  db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

}

