package com.example.jean.sinca_2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.jean.sinca_2.model.DBOpenHelper;

public class ListaProdutosActivity extends AppCompatActivity {

    private SQLiteDatabase mydb = null;
    private SimpleCursorAdapter simpleCursorAdapter = null;
    private Cursor cursor;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);

        mydb = openOrCreateDatabase(DBOpenHelper.BANCO_NOME, SQLiteDatabase.CREATE_IF_NECESSARY, null);

        cursor = mydb.rawQuery("SELECT _id, nome FROM produto ORDER BY _id ASC", null);

        String[] campos = {"_id", "nome"};
        int[] ids = {R.id.id, R.id.nome};

        simpleCursorAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.model_produto, cursor, campos, ids, 0);

        listView = (ListView) findViewById(R.id.lista);
        listView.setAdapter(simpleCursorAdapter);

    }
}