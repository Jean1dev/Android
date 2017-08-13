package com.example.jean.sinca_2.model;

/**
 * Created by Jean on 01/08/2017.
 */

public class PessoaModel {

    //TABELA
    public static final String TABELA_NOME = "pessoa";
    public static final String COLUNA_ID = "_id",
            COLUNA_NOME = "nome",
            COLUNA_SENHA = "senha",
            COLUNA_LOGIN = "login";

    public static final String CREAT_TABLE = " create table " + TABELA_NOME
            + "("
            + COLUNA_ID + " integer primary key autoincrement,"
            + COLUNA_NOME + " text not null,"
            + COLUNA_SENHA + " text not null,"
            + COLUNA_LOGIN + " text not null)";

    public static final String DROP_TABLE = "drop table if exists" + TABELA_NOME;
    //FIM DA TABELA

    private long id;
    private String nome;
    private String senha;
    private String login;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String senha) {
        this.login = login;
    }


}
