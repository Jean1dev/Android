package com.example.jean.sinca_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jean.sinca_2.database.DAO.PessoaDAO;
import com.example.jean.sinca_2.model.PessoaModel;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private EditText senha;
    private EditText login;
    private Button Sair;
    private Button Cadastrar;
    private Button Entrar;
    private Button Sobre;
    private PessoaDAO io_dao;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //CRIA BANCO
        io_dao = new PessoaDAO(getApplication());

        Entrar = (Button) findViewById(R.id.entrar);
        Entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                senha = (EditText) findViewById(R.id.senha);
                login = (EditText) findViewById(R.id.email);

                //AUXILIARES
                String a = login.getText().toString();
                String b = senha.getText().toString();
                int aux = 2;

                List<PessoaModel> listaPessoa = io_dao.Select();

                for (PessoaModel p : listaPessoa) {
                    if (a.equals(p.getNome()) && b.equals(p.getSenha())) {
                        Intent intent = new Intent(getBaseContext(), PrincipalActivity.class);
                        intent.putExtra("nome", a);
                        startActivity(intent);
                        aux = 1;
                        login.setText("");
                        senha.setText("");
                        break;
                    }

                }
                if (aux != 1) {
                    Toast.makeText(getBaseContext(), "Informações erradas", Toast.LENGTH_SHORT).show();
                }
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

        //BOTAO CADASTRAR
        Cadastrar = (Button) findViewById(R.id.cadastrar);
        Cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), CadastrarActivity.class);
                startActivity(i);
            }
        });

        //BOTAO SOBRE
        Sobre = (Button) findViewById(R.id.sobre);
        Sobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), ListagemTesteActivity.class));
            }
        });
    }
}

