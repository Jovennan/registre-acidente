package br.edu.unipe.pos.mobile.registreacidente.model;

import com.orm.SugarRecord;

/**
 * Created by jovennan on 04/05/17.
 */

public class FotoVeiculo extends SugarRecord {
    private String caminho;
    private String perspectiva;
    private Veiculo veiculo;

    public FotoVeiculo() {
    }

    public FotoVeiculo(String caminho, String perspectiva, Veiculo veiculo) {
        this.caminho = caminho;
        this.perspectiva = perspectiva;
        this.veiculo = veiculo;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public String getPerspectiva() {
        return perspectiva;
    }

    public void setPerspectiva(String perspectiva) {
        this.perspectiva = perspectiva;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}
