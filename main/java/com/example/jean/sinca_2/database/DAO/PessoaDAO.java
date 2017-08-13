package com.example.jean.sinca_2.database.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.jean.sinca_2.model.DBOpenHelper;
import com.example.jean.sinca_2.model.PessoaModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jean on 01/08/2017.
 */

public class PessoaDAO extends AbstractDAO {

    private Context io_context;

    private String[] colunas = new String[]{
            PessoaModel.COLUNA_ID,
            PessoaModel.COLUNA_NOME,
            PessoaModel.COLUNA_LOGIN,
            PessoaModel.COLUNA_SENHA,
    };

    public PessoaDAO(final Context ao_context) {
        io_context = ao_context;
        db_helper = new DBOpenHelper(io_context);
    }

    public long Insert(final String nome, final String login, final String senha) {

        Open();

        ContentValues values = new ContentValues();
        values.put(PessoaModel.COLUNA_NOME, nome);
        values.put(PessoaModel.COLUNA_LOGIN, login);
        values.put(PessoaModel.COLUNA_SENHA, senha);
        long linhas_retornadas = db.insert(PessoaModel.TABELA_NOME, null, values);

        Close();

        return linhas_retornadas;
    }

    public long Delete(final String nome) {

        Open();
        long linhas_retornadas = db.delete(PessoaModel.TABELA_NOME, PessoaModel.COLUNA_NOME + " = '" + nome + "'", null);
        Close();
        return linhas_retornadas;
    }

    public long Update(final String nome, final String login, final String senha) {

        Open();

        ContentValues values = new ContentValues();
        values.put(PessoaModel.COLUNA_NOME, nome);
        values.put(PessoaModel.COLUNA_LOGIN, login);
        values.put(PessoaModel.COLUNA_SENHA, senha);
        long linhas_retornadas = db.update(
                PessoaModel.TABELA_NOME, values, PessoaModel.COLUNA_NOME + " = '" + nome + "'", null);

        Close();
        return linhas_retornadas;
    }

    public List<PessoaModel> Select() {

        Open();

        ArrayList<PessoaModel> lo_arl_pessoa = new ArrayList<PessoaModel>();

        Cursor cursor = db.query(PessoaModel.TABELA_NOME, colunas, null, null, PessoaModel.COLUNA_NOME, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            lo_arl_pessoa.add(CursorToPeople(cursor));
            cursor.moveToNext();
        }
        cursor.close();

        Close();
        return lo_arl_pessoa;
    }

    public PessoaModel CursorToPeople(final Cursor ao_cursor) {
        PessoaModel pessoa = new PessoaModel();
        pessoa.setId(ao_cursor.getLong(0));
        pessoa.setNome(ao_cursor.getString(1));
        pessoa.setSenha(ao_cursor.getString(2));
        pessoa.setSenha(ao_cursor.getString(3));

        return pessoa;
    }

    public Cursor getCursor() {

        Open();

        Cursor cursor = db.rawQuery("SELECT _id, nome, login, senha FROM pessoa", null);

        Close();
        return cursor;
    }
}