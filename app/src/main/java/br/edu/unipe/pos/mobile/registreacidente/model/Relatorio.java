package br.edu.unipe.pos.mobile.registreacidente.model;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by jovennan on 28/04/17.
 */

public class Relatorio extends SugarRecord {
    private String local;
    private Date dataAcidente;
    private String relato;

    public Relatorio() {
    }

    public Relatorio(String local, Date dataAcidente, String relato) {

        this.local = local;
        this.dataAcidente = dataAcidente;
        this.relato = relato;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Date getDataAcidente() {
        return dataAcidente;
    }

    public void setDataAcidente(Date dataAcidente) {
        this.dataAcidente = dataAcidente;
    }

    public String getRelato() {
        return relato;
    }

    public void setRelato(String relato) {
        this.relato = relato;
    }
}
