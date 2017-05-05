package br.edu.unipe.pos.mobile.registreacidente.util;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import br.edu.unipe.pos.mobile.registreacidente.R;
import br.edu.unipe.pos.mobile.registreacidente.model.Pessoa;

/**
 * Created by jovennan on 30/04/17.
 */

public class PessoaInsertUtil {

    private EditText editTextnome;
    private EditText editTextcnh;
    private EditText editTextcpf;
    private EditText editTextemail;

    private Pessoa pessoa;

    public PessoaInsertUtil(View view) {
        editTextnome =(EditText) view.findViewById(R.id.pessoaInsert_editTextNome);
        editTextcnh = (EditText) view.findViewById(R.id.pessoaInsert_editTextCnh);
        editTextcpf = (EditText) view.findViewById(R.id.pessoaInsert_editTextCpf);
        editTextemail = (EditText) view.findViewById(R.id.pessoaInsert_editTextEmail);

        pessoa = new Pessoa();
    }

    public Pessoa buildPessoaForInsert() throws Exception{

        if (editTextnome.getText().toString().equals("")) {
            throw new Exception("Campo 'nome' obrigatório!");
        }

        if (editTextcnh.getText().toString().equals("")) {
            throw new Exception("Campo 'CNH' obrigatório!");
        }

        if (editTextcpf.getText().toString().equals("")) {
            throw new Exception("Campo 'CPF' obrigatório!");
        }

        if (editTextemail.getText().toString().equals("")) {
            throw new Exception("Camnpo 'email' obrigatório!");
        }

        String nome = editTextnome.getText().toString();

        String cnh = editTextcnh.getText().toString();

        String cpf = editTextcpf.getText().toString();

        String email = editTextemail.getText().toString();

        this.pessoa.setNome(nome);
        this.pessoa.setCnh(cnh);
        this.pessoa.setCpf(cpf);
        this.pessoa.setEmail(email);

        return pessoa;
    }

    public void buildEditPessoa(Pessoa editPessoa) {

        editTextnome.setText(editPessoa.getNome());
        editTextcnh.setText(editPessoa.getCnh());
        editTextcpf.setText(editPessoa.getCpf());
        editTextemail.setText(editPessoa.getEmail());

        this.pessoa = editPessoa;
    }
}
