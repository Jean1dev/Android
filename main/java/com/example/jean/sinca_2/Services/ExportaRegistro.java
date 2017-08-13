package com.example.jean.sinca_2.Services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.example.jean.sinca_2.model.DBOpenHelper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExportaRegistro extends Service implements Runnable {

    private SQLiteDatabase sqLiteDatabase = null    ;
    private Cursor cursor = null                    ;

    public ExportaRegistro() {
    }

    @Override
    public void onCreate() {
        new Thread(ExportaRegistro.this).start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void run() {

        sqLiteDatabase = openOrCreateDatabase(DBOpenHelper.BANCO_NOME, Context.MODE_PRIVATE, null);
        cursor = sqLiteDatabase.rawQuery("SELECT * FROM produto", null);

        int Contador_total = cursor.getCount();
        int Contador_iterator = 0 ;
        String linha_retorno = null ;

        while(cursor.moveToNext()){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("http://localhost/my_project/conect.php?nome=");
            stringBuilder.append(cursor.getString(1));
            stringBuilder.append("&preco=");
            stringBuilder.append(cursor.getFloat(2));
            stringBuilder.append("&quantidade=");
            stringBuilder.append(cursor.getFloat(3));

            Log.d(stringBuilder.toString(),"*******************************");

            try {
                URL url = new URL(stringBuilder.toString());
                HttpURLConnection http = (HttpURLConnection) url.openConnection();
                InputStreamReader inputStreamReader = new InputStreamReader(http.getInputStream());
                BufferedReader buffer = new BufferedReader(inputStreamReader);

                linha_retorno = buffer.readLine();

                if(linha_retorno.equals("sucess")){
                    Toast.makeText(getBaseContext(), "Sucesso ao exportar", Toast.LENGTH_SHORT).show();
                    sqLiteDatabase.delete("produto", "_id=?", new String[]{String.valueOf(cursor.getInt(0))});
                }

            }catch (Exception exception){
                Log.d("ERRO AKI **************",exception.getMessage());
            }
        }
    }
}
