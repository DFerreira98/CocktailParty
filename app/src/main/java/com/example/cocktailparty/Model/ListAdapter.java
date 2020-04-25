package com.example.cocktailparty.Model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.cocktailparty.Controler.ClickActivity;
import com.example.cocktailparty.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<Cocktail> values;

    private ImageView imageView;
    private Context context;


    class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout relative;
        TextView txtHeader;
        View layout;

        ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = v.findViewById(R.id.name);
            imageView = v.findViewById(R.id.image);
            relative =v.findViewById(R.id.relative);

        }
    }




    public ListAdapter(List<Cocktail> Test,Context context) {
        values = Test;
        this.context=context;
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

        final Cocktail name = values.get(position);
        holder.txtHeader.setText(name.getStrDrink());
        holder.relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ClickActivity.class);
                i.putExtra("strDrinkThumb",name.getStrDrinkThumb());
                i.putExtra("ingredients",name.getIngredients());
                context.startActivity(i);
            }
        });



        Glide.with(context).load(values.get(position).getStrDrinkThumb()).into(imageView);


    }


    @Override
    public int getItemCount() {
        return values.size();
    }
}

