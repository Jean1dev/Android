package com.example.jean.sinca_2.database.DAO;

import android.content.ContentValues;
import android.content.Context;

import com.example.jean.sinca_2.model.DBOpenHelper;
import com.example.jean.sinca_2.model.PedidoModel;

/**
 * Created by Jean on 06/08/2017.
 */

public class PedidoDAO extends AbstractDAO {

    private Context io_context ;

    private String[] colunas = new String[]{
            PedidoModel.COLUNA_ID,
            PedidoModel.COLUNA_PRODUTO,
            PedidoModel.COLUNA_TOTAL,
            PedidoModel.COLUNA_QTD_TOTAL,
            PedidoModel.COLUNA_USUARIO
    };

    public PedidoDAO(final Context context){
        io_context = context ;
        db_helper = new DBOpenHelper(io_context);
    }

    public long Insert(String produto, Double total, Double qtd, String user){

        Open();
        ContentValues contentValues = new ContentValues();

        contentValues.put(PedidoModel.COLUNA_PRODUTO, produto);
        contentValues.put(PedidoModel.COLUNA_TOTAL, total);
        contentValues.put(PedidoModel.COLUNA_QTD_TOTAL, qtd);
        contentValues.put(PedidoModel.COLUNA_USUARIO, user);

        long linhas_retornadas = db.insert(PedidoModel.TABELA_NOME, null, contentValues);

        Close();
        return linhas_retornadas ;
    }
}
