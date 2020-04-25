package com.example.cocktailparty.Model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.cocktailparty.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<String> values;


    class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtHeader;
        View layout;

        ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = v.findViewById(R.id.name);

        }
    }

    public void add(int position, String item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    private void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }


    public ListAdapter(List<String> Test) {
        values = Test;
    }


    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);

        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final String name = values.get(position);
        holder.txtHeader.setText(name);


    }


    @Override
    public int getItemCount() {
        return values.size();
    }
}

