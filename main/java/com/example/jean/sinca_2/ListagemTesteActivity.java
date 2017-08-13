package com.example.jean.sinca_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jean.sinca_2.database.DAO.PessoaDAO;
import com.example.jean.sinca_2.model.PessoaModel;

import java.util.ArrayList;
import java.util.List;

public class ListagemTesteActivity extends AppCompatActivity {

    private ListView list;
    private PessoaDAO io_dao;
    EditText auxiliar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_teste);

        io_dao = new PessoaDAO(this);

        list = (ListView) findViewById(R.id.lista);

        List<PessoaModel> lista = io_dao.Select();
        ArrayList<String> io_list = new ArrayList<>();

        //PERCORRE A CLASSE PESSOA E ADICIONA EM UMA LISTA
        for (PessoaModel c : lista) {
            io_list.add(c.getNome());
        }


        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, io_list);

        // Assign adapter to ListView
        list.setAdapter(adapter);


        //RECUPERA O CURSOR COM OS DADOS NECESSARIOS
        //Cursor cursor = io_dao.getCursor();
        //String[] campos = {"_id,nome,login,senha"};


//        simpleCursorAdapter = new SimpleCursorAdapter(getBaseContext(), android.R.layout.simple_list_item_1,
        //               cursor, campos, null, 0);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String aux = null;

                aux = String.valueOf(adapter.getItem(position));
                Log.d(aux, "AKI******************************************************");
                Intent intent = new Intent(getBaseContext(), EditarActivity.class);
                Toast.makeText(getBaseContext(), "clique em " + adapter.getItem(position), Toast.LENGTH_SHORT).show();
                intent.putExtra("nome", aux);
                startActivity(intent);

            }
        });
    }
}