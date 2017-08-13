package com.example.jean.sinca_2.database.DAO;

import android.database.sqlite.SQLiteDatabase;

import com.example.jean.sinca_2.model.DBOpenHelper;

/**
 * Created by Jean on 01/08/2017.
 */

public abstract class AbstractDAO {

    protected SQLiteDatabase db;
    protected DBOpenHelper db_helper;

    protected final void Open(){
        db = db_helper.getWritableDatabase();
    }
    protected final void Close(){
        db_helper.close();
    }
}
