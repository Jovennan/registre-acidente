package br.edu.unipe.pos.mobile.registreacidente.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.edu.unipe.pos.mobile.registreacidente.R;
import br.edu.unipe.pos.mobile.registreacidente.model.FotoVeiculo;

/**
 * Created by jovennan on 04/05/17.
 */

public class FotoVeiculoAdapter extends BaseAdapter {
    private final Context context;
    private final List<FotoVeiculo> listFotos;

    public FotoVeiculoAdapter(Context context, List<FotoVeiculo> listFotos) {
        this.context = context;
        this.listFotos = listFotos;
    }

    @Override
    public int getCount() {
        return listFotos.size();
    }

    @Override
    public Object getItem(int i) {
        return listFotos.get(i);
    }

    @Override
    public long getItemId(int i) {

        return listFotos.get(i).getId();
    }

    @Override
    public View getView(int i, View contextView, ViewGroup parent) {
        FotoVeiculo fotoVeiculo = this.listFotos.get(i);
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = contextView;
        if(view == null){
            view = inflater.inflate(R.layout.foto_veiculo_item_list, parent, false);
        }

        TextView placaVeiculoTextView = (TextView) view.findViewById(R.id.fotoVeiculoItemTextViewPlaca);
        TextView perspectivaFotoTextView = (TextView)view.findViewById(R.id.fotoVeiculoItemTextViewPerspectiva);

        ImageView fotoVeiculoImageView = (ImageView) view.findViewById((R.id.fotoVeiculoItemImageView));
        if(fotoVeiculo.getCaminho() != null) {

            Bitmap bitmap = BitmapFactory.decodeFile(fotoVeiculo.getCaminho());
            Bitmap bitmapReduce = Bitmap.createScaledBitmap(bitmap, 300, 300, true);
            fotoVeiculoImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            fotoVeiculoImageView.setImageBitmap(bitmapReduce);
        }

        return view;
    }
}