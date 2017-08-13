package com.example.jean.sinca_2.model;

/**
 * Created by Jean on 01/08/2017.
 */

public class ProdutoModel {

    //TABELA
    public static final String TABELA_NOME = "produto";
    public static final String COLUNA_ID = "_id";
    public static final String COLUNA_NOME = "nome";
    public static final String COLUNA_VALOR = "valor";
    public static final String COLUNA_ESTOQUE = "estoque";

    public static final String CREATE_TABLE = "create table if not exists " + TABELA_NOME +
            "(" +
            COLUNA_ID + " integer primary key autoincrement," +
            COLUNA_NOME + " text," +
            COLUNA_VALOR + " real," +
            COLUNA_ESTOQUE + " real)";

    public static final String DROP_TABLE = "drop table if exists " + TABELA_NOME;
    //FIM DA TABELA

    private long id;
    private String nome;
    private double valor;
    private double estoque;

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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getEstoque() {
        return estoque;
    }

    public void setEstoque(double estoque) {
        this.estoque = estoque;
    }
}
