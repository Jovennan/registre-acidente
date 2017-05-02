package br.edu.unipe.pos.mobile.registreacidente;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.edu.unipe.pos.mobile.registreacidente.PessoaFragment.OnListFragmentInteractionListener;
import br.edu.unipe.pos.mobile.registreacidente.model.Pessoa;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Pessoa} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyPessoaRecyclerViewAdapter extends RecyclerView.Adapter<MyPessoaRecyclerViewAdapter.ViewHolder> {

    private final List<Pessoa> pessoas;
    private final OnListFragmentInteractionListener mListener;

    public MyPessoaRecyclerViewAdapter(List<Pessoa> pessoas, OnListFragmentInteractionListener listener) {
        this.pessoas = pessoas;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_pessoa, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = pessoas.get(position);
        holder.mIdView.setText(pessoas.get(position).getCpf());
        holder.mContentView.setText(pessoas.get(position).getNome());

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
        return pessoas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public Pessoa mItem;

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
