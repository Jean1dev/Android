package com.example.jean.sinca_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jean.sinca_2.database.DAO.PessoaDAO;

public class EditarActivity extends AppCompatActivity {

    private EditText nome;
    private EditText login;
    private EditText senha;
    private Button Editar;
    private Button Sair;
    private String Inome;
    private PessoaDAO mydb;
    final Intent intent = getIntent();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        mydb = new PessoaDAO(this);

//        Inome = intent.getStringExtra("nome");

        System.out.println("nome");

        nome = (EditText) findViewById(R.id.nome);
        login = (EditText) findViewById(R.id.login);
        senha = (EditText) findViewById(R.id.senha);


        nome.setText(Inome);

        //BOTAO EDITAR
        Editar = (Button) findViewById(R.id.editar);
        Editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydb.Update(
                        intent.getStringExtra("nome"),
                        login.getText().toString(),
                        senha.getText().toString()
                );

                Toast.makeText(getBaseContext(), "ATUALIZADO", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        //BOTAO SAIR
        Sair = (Button) findViewById(R.id.sair);
        Sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}