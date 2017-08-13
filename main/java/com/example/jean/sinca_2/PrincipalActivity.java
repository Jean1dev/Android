package com.example.jean.sinca_2;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jean.sinca_2.database.DAO.PessoaDAO;

public class PrincipalActivity extends AppCompatActivity {

    private TextView log;
    private TextView status_connect;
    private Button Produto;
    private Button Sync;
    private Button Listar;
    private Button Excluir;
    private PessoaDAO mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        mydb = new PessoaDAO(this);

        final Intent intent = getIntent();

        log = (TextView) findViewById(R.id.logadoComo);
        log.setText("LOGADO COMO " + intent.getStringExtra("nome"));

        //BOTAO CADASTRAR PRODUTO
        Produto = (Button) findViewById(R.id.novo_produto);
        Produto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), CadastroProdutoActivity.class);
                startActivity(intent);
            }
        });

        //BOTAO LISTAR PRODUTO
        Listar = (Button) findViewById(R.id.listar);
        Listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ListaProdutosActivity.class);
                startActivity(intent);
            }
        });

        //BOTAO EXCLUIR USUARIO LOGADO
        Excluir = (Button) findViewById(R.id.excluir);
        Excluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydb.Delete(intent.getStringExtra("nome"));
                finish();
            }
        });

        //BOTAO EXPORTA CADASTRO PRODUTO
        Sync = (Button) findViewById(R.id.exporta_cadastro);
        Sync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent("VaiPorra"));
                //Toast.makeText(PrincipalActivity.this, "AINDA NAO IMPLEMENTADO", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        status_connect = (TextView) findViewById(R.id.conexao);

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        if(connectivityManager.getNetworkInfo(0).isConnected()){
            status_connect.setText("Status da conexao: 3G");
        }else if(connectivityManager.getNetworkInfo(1).isConnected()){
            status_connect.setText("Status da conexao : WIFI");
        }else{
            status_connect.setText("Status da conexao : DESCONECTADO");
        }
    }
}
