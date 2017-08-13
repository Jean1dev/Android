package com.example.jean.sinca_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jean.sinca_2.database.DAO.PessoaDAO;

public class CadastrarActivity extends AppCompatActivity {

    private Button mCadastrar;
    private Button mSair;
    private EditText mNome;
    private EditText mLogin;
    private EditText mSenha;
    private PessoaDAO io_dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        io_dao = new PessoaDAO(this);// OPEN DATABASE

        //BOTAO SAIR
        mSair = (Button) findViewById(R.id.sair);
        mSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        //BOTAO CADASTRAR
        mCadastrar = (Button) findViewById(R.id.cadastrar);
        mCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNome = (EditText) findViewById(R.id.nome);
                mLogin = (EditText) findViewById(R.id.login);
                mSenha = (EditText) findViewById(R.id.senha);

                io_dao.Insert(
                        mNome.getText().toString(),
                        mLogin.getText().toString(),
                        mSenha.getText().toString());

                mNome.setText("");
                mSenha.setText("");
                mLogin.setText("");

                Toast.makeText(getApplicationContext(), "Cadastro realizado com sucesso", Toast.LENGTH_SHORT).show();
                finish();

            }

        });
    }
}
