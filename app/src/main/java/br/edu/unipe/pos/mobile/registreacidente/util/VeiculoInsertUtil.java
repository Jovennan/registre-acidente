package br.edu.unipe.pos.mobile.registreacidente.util;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import br.edu.unipe.pos.mobile.registreacidente.R;
import br.edu.unipe.pos.mobile.registreacidente.model.Veiculo;

/**
 * Created by jovennan on 03/05/17.
 */

public class VeiculoInsertUtil {

    private EditText editTextmarca;
    private EditText editTextmodelo;
    private EditText editTextplaca;

    private ImageView imagePhoto;

    private Veiculo veiculo;

    public VeiculoInsertUtil(View view) {
        editTextmarca =(EditText) view.findViewById(R.id.veiculoInsert_editTextMarca);
        editTextmodelo = (EditText) view.findViewById(R.id.veiculoInsert_editTextModelo);
        editTextplaca = (EditText) view.findViewById(R.id.veiculoInsert_editTextPlaca);

        imagePhoto = (ImageView) view.findViewById(R.id.veiculoInsert_imageViewPhoto);

        veiculo = new Veiculo();
    }

//    public void addPhoto(String path){
//
//        veiculo.getCaminhoFotos().add(path);
//    }

    public Veiculo buildVeiculoForInsert() throws Exception {

        if (editTextmarca.getText().toString().equals("")) {
            throw new Exception("Campo 'marca' obrigatório!");
        }
        if (editTextmodelo.getText().toString().equals("")) {
            throw new Exception("Campo 'modelo' obrigatório!");
        }
        if (editTextplaca.getText().toString().equals("")) {
            throw new Exception("Campo 'placa' obrigatório!");
        }

        String marca = editTextmarca.getText().toString();
        String modelo = editTextmodelo.getText().toString();
        String placa = editTextplaca.getText().toString();

        this.veiculo.setMarca(marca);
        this.veiculo.setModelo(modelo);
        this.veiculo.setPlaca(placa);

        return this.veiculo;
    }
}
