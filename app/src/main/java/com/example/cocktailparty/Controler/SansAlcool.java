package com.example.cocktailparty.Controler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cocktailparty.Model.Cocktail;
import com.example.cocktailparty.Model.SansAlcoolAPI;
import com.example.cocktailparty.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SansAlcool extends AppCompatActivity {

    private GridView gridView;
    private CustomAdapter customAdapter;
    public static List<Cocktail> listeCocktail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sans_alcool);

        listeCocktail = new ArrayList<>();

        gridView = findViewById(R.id.gridview);

        Call<List<Cocktail>> call = SansAlcoolAPI.interfaceAPI().getCocktailSansAlcool();
        call.enqueue(new Callback<List<Cocktail>>() {
            @Override
            public void onResponse(Call<List<Cocktail>> call, Response<List<Cocktail>> response) {
                if(response.isSuccessful()){
                    customAdapter = new CustomAdapter(response.body(),SansAlcool.this);
                    gridView.setAdapter(customAdapter);

                    listeCocktail = response.body();
                    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                            startActivity(new Intent(getApplicationContext(),ClickActivity.class)
                                    .putExtra("strDrinkThumb",listeCocktail.get(position).getStrDrinkThumb())
                                    .putExtra("strDrink",listeCocktail.get(position).getStrDrink())
                                    .putExtra("ingredient",listeCocktail.get(position).getIngredients())

                            );
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<List<Cocktail>> call, Throwable t) {

            }
        });


    }



    public class CustomAdapter extends BaseAdapter {

        public List<Cocktail> list;
        public Context context;

        public CustomAdapter(List<Cocktail> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            View view = LayoutInflater.from(context).inflate(R.layout.row_data,null);

            TextView name  = view.findViewById(R.id.name_row_data);

            ImageView image = view.findViewById(R.id.imageView);


            Glide.with(context).load(list.get(position).getStrDrinkThumb()).into(image);

            name.setText(list.get(position).getStrDrink());




            return view;
        }
    }
}
