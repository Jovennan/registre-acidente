package br.edu.unipe.pos.mobile.registreacidente.util;

import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import br.edu.unipe.pos.mobile.registreacidente.R;

/**
 * Created by jovennan on 30/04/17.
 */

public class PessoaInsertUtil {

    private EditText editTextnome;
    private EditText editTextcnh;
    private EditText editTextcpf;
    private EditText editTextemail;

    public PessoaInsertUtil(AppCompatActivity appCompatActivity) {
        editTextnome =(EditText) appCompatActivity.findViewById(R.id.pessoaInsert_editTextNome);
        editTextcnh = (EditText) appCompatActivity.findViewById(R.id.pessoaInsert_editTextCnh);
        editTextcpf = (EditText) appCompatActivity.findViewById(R.id.pessoaInsert_editTextCpf);
        editTextemail = (EditText) appCompatActivity.findViewById(R.id.pessoaInsert_editTextEmail);
    }
}
