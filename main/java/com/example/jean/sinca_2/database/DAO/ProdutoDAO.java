package com.example.jean.sinca_2.database.DAO;

import android.content.ContentValues;
import android.content.Context;

import com.example.jean.sinca_2.model.DBOpenHelper;
import com.example.jean.sinca_2.model.ProdutoModel;

/**
 * Created by Jean on 01/08/2017.
 */

public class ProdutoDAO extends AbstractDAO {

    private Context io_context;

    private String[] colunas = {
            ProdutoModel.COLUNA_ID,
            ProdutoModel.COLUNA_NOME,
            ProdutoModel.COLUNA_VALOR,
            ProdutoModel.COLUNA_ESTOQUE
    };

    public ProdutoDAO(final Context context) {
        io_context = context;
        db_helper = new DBOpenHelper(io_context);
    }

    public long Insert(final String nome, final String valor, final String qtd) {

        Open();

        ContentValues contentValues = new ContentValues();
        contentValues.put(ProdutoModel.COLUNA_NOME, nome);
        contentValues.put(ProdutoModel.COLUNA_VALOR, valor);
        contentValues.put(ProdutoModel.COLUNA_ESTOQUE, qtd);

        long linhas_retornadas = db.insert(ProdutoModel.TABELA_NOME, null, contentValues);

        Close();
        return linhas_retornadas;
    }

    public long Insert(final String nome) { // AFIM DE TESTES

        Open();

        ContentValues contentValues = new ContentValues();
        contentValues.put(ProdutoModel.COLUNA_NOME, nome);
        long linhas_retornadas = db.insert(ProdutoModel.TABELA_NOME, null, contentValues);

        Close();
        return linhas_retornadas;
    }

    public long Delete(final String nome) {

        Open();

        long linhas_retornadas = db.delete(ProdutoModel.TABELA_NOME, ProdutoModel.COLUNA_NOME + " = '" + nome + "'", null);
        Close();

        return linhas_retornadas;
    }
}
