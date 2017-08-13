package com.example.jean.sinca_2.model;

/**
 * Created by Jean on 06/08/2017.
 */

public class PedidoModel {

    //TABELA
    public static final String TABELA_NOME = "pedido"   ;
    public static final String COLUNA_ID = "_id"        ,
            COLUNA_PRODUTO = "produto"                  ,
            COLUNA_TOTAL = "total"                      ,
            COLUNA_QTD_TOTAL = "quantidade"             ,
            COLUNA_USUARIO = "usuario"                  ;

    public static final String CREATE_TABLE = " create table " + TABELA_NOME
            + "("
            + COLUNA_ID + " integer primary key auto incremente, "
            + COLUNA_PRODUTO + " text, "
            + COLUNA_TOTAL + " real, "
            + COLUNA_QTD_TOTAL + " real, "
            + COLUNA_USUARIO + " text) ";

    public static final String DROP_TABLE = " drop table if not exists " + TABELA_NOME ;
    //FIM DA TABELA

    private long id ;
    private String produto ;
    private String usuario ;
    private Double total ;
    private Double quantiade ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getQuantiade() {
        return quantiade;
    }

    public void setQuantiade(Double quantiade) {
        this.quantiade = quantiade;
    }
}
