package br.edu.unipe.pos.mobile.registreacidente.model;

import com.orm.SugarRecord;

/**
 * Created by jovennan on 28/04/17.
 */

public class Pessoa  extends SugarRecord {

    private String nome;
    private String cnh;
    private String cpf;
    private String email;

    public Pessoa() {
    }

    public Pessoa(String nome, String cnh, String cpf, String email) {
        this.nome = nome;
        this.cnh = cnh;
        this.cpf = cpf;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
