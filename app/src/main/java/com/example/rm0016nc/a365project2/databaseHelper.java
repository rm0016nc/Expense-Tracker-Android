package com.example.rm0016nc.a365project2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.view.View;

public class databaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Expensetracer.db";
    public static final String TABLE_NAME = "expensetracker_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "FOOD";
    public static final String COL_3 = "HOUSEHOLDS";
    public static final String COL_4 = "MIS";

    public databaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 3);
//        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, FOOD DOUBLE, HOUSEHOLDS DOUBLE, MIS DOUBLE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String food, String households, String mis) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, food);
        contentValues.put(COL_3, households);
        contentValues.put(COL_4, mis);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public Boolean updateData(String id, String food, String households, String mis){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, food);
        contentValues.put(COL_3, households);
        contentValues.put(COL_4, mis);
        db.update(TABLE_NAME, contentValues,"id = ?", new String[] { id});
        return true;
    }
    public Integer deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"ID = ?" ,new String[] {id});
//        return db.delete(TABLE_NAME,null,null);
    }

    public Integer resetData() {
        SQLiteDatabase db = this.getWritableDatabase();
//        return db.delete(TABLE_NAME,"ID = ?" ,new String[] {id});
        return db.delete(TABLE_NAME,null,null);
    }
 }
