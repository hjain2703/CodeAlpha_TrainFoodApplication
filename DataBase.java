package com.example.new_one;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {
    public static final String PASSWORD_TABLE = "PASSWORD_TABLE";
    public static final String USERNAME = "username";
    public static final String PASS = "pass";
    public static final String EMAIL = "email";

    public DataBase(Context context) {
        super(context, "delivery.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + PASSWORD_TABLE + " (" + USERNAME + " text " +
                "PRIMARY KEY NOT NULL, " + PASS + " VARCHAR(10) NOT NULL, " + EMAIL + " VARCHAR(20) NOT NULL);";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean addOne(Model model){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(USERNAME,model.getUsername());
        cv.put(PASS,model.getPass());
        cv.put(EMAIL, model.getEmail());
        long insert = db.insert(PASSWORD_TABLE,null,cv);
        if(insert == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public List<Model> get_cred(){
        List<Model> list = new ArrayList<>();
        String query = "SELECT "+USERNAME+", "+PASS+", "+EMAIL+" FROM "+PASSWORD_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            //Loop through cursor
            do{
                String name = cursor.getString(0);
                String pass = cursor.getString(1);
                String email = cursor.getString(2);
                Model model = new Model(name,pass,email);
                list.add(model);
            }while (cursor.moveToNext());
        }
        else{

        }
        return list;
    }

}

