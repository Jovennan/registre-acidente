package br.edu.unipe.pos.mobile.registreacidente;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.edu.unipe.pos.mobile.registreacidente.VeiculoFragment.OnListFragmentInteractionListener;
import br.edu.unipe.pos.mobile.registreacidente.dummy.DummyContent.DummyItem;
import br.edu.unipe.pos.mobile.registreacidente.model.Veiculo;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Veiculo} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyVeiculoRecyclerViewAdapter extends RecyclerView.Adapter<MyVeiculoRecyclerViewAdapter.ViewHolder> {

    private final List<Veiculo> veiculos;
    private final OnListFragmentInteractionListener mListener;

    public MyVeiculoRecyclerViewAdapter(List<Veiculo> items, OnListFragmentInteractionListener listener) {
        veiculos = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_veiculo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = veiculos.get(position);
        holder.mIdView.setText(veiculos.get(position).getPlaca());
        holder.mContentView.setText(veiculos.get(position).getModelo());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return veiculos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public Veiculo mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
