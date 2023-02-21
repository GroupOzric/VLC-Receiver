package com.example.opencvapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String Dbname = "vlc_db";
    private static final int dbver = 1;

    private static final String tablename = "my_library";
    private static final String columnid = "_id";
    private static final String columnTitle = "message";
    private static final String columnTime = "time";


    public MyDatabaseHelper(@Nullable Context context){
        super(context, Dbname, null, dbver);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE "+ tablename +
                        " ("+ columnid + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                            columnTitle + " TEXT, "+
                            columnTime + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ tablename);
        onCreate(sqLiteDatabase);
    }
}
