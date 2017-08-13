package com.example.jean.sinca_2.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jean on 01/08/2017.
 */

public class DBOpenHelper extends SQLiteOpenHelper {

    public static final String BANCO_NOME = "mydb.db";
    private static final int BANCO_VERSAO = 1;


    public DBOpenHelper(Context context) {
        super(context, BANCO_NOME, null, BANCO_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PessoaModel.CREAT_TABLE);
        db.execSQL(ProdutoModel.CREATE_TABLE);
        db.execSQL(PedidoModel.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
