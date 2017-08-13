package com.example.jean.sinca_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jean.sinca_2.database.DAO.ProdutoDAO;

public class CadastroProdutoActivity extends AppCompatActivity {

    private Button Sair;
    private Button Cadastrar;
    private EditText nome;
    private EditText valor;
    private EditText qtd;
    private ProdutoDAO mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);

        mydb = new ProdutoDAO(this); //OPEN DATABASE

        Cadastrar = (Button) findViewById(R.id.cadastrar);
        Cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nome = (EditText) findViewById(R.id.nome);
                valor = (EditText) findViewById(R.id.login);
                qtd = (EditText) findViewById(R.id.senha);

                if (mydb.Insert(
                        nome.getText().toString()) > 1) {
                    Toast.makeText(getApplicationContext(), "Cadastro realizado com sucesso", Toast.LENGTH_SHORT).show();
                    finish();

                } else
                    Toast.makeText(getBaseContext(), "LAMENTO", Toast.LENGTH_SHORT).show();
                finish();

            }

            //BOTAO CADASTRAR
/*        Cadastrar = (Button) findViewById(R.id.novo_produto);
        Cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nome = (EditText) findViewById(R.id.nome);
                valor = (EditText) findViewById(R.id.valor);
                qtd = (EditText) findViewById(R.id.qtd);
                mydb.Insert(
                        nome.getText().toString(),
                        Double.parseDouble(valor.getText().toString()),
                        Double.parseDouble(qtd.getText().toString())
                );

                if (mydb.Insert(
                        nome.getText().toString(),
                        Double.parseDouble(valor.getText().toString()),
                        Double.parseDouble(qtd.getText().toString())
                ) > 1) {
                    Toast.makeText(getBaseContext(), "Sucesso", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(getBaseContext(), "Desculpe", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });*/
        });

        Sair = (Button) findViewById(R.id.sair);
        Sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
