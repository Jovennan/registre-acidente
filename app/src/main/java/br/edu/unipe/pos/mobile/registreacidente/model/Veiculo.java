package br.edu.unipe.pos.mobile.registreacidente.model;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jovennan on 28/04/17.
 */

public class Veiculo extends SugarRecord{

    private String marca;
    private String modelo;
    @Unique
    private String placa;

    public Veiculo() {
    }

    public Veiculo(String marca, String modelo, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public List<FotoVeiculo> getFotos(){
        List<FotoVeiculo> listaFotos;
        if(this.getId() != null){
            String veiculoId=  this.getId().toString();
            listaFotos = FotoVeiculo.find(FotoVeiculo.class, "veiculo = ?", new String[]{veiculoId});
        }else{
            listaFotos = new ArrayList<FotoVeiculo>();
        }
        return listaFotos;
    }
}
