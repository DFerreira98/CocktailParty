package com.example.cocktailparty.Controler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.cocktailparty.Model.Cocktail;
import com.example.cocktailparty.Model.CocktailApi;
import com.example.cocktailparty.Model.ListAdapter;
import com.example.cocktailparty.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AvecAlcool extends AppCompatActivity {

    private final String BASE_URL = "https://raw.githubusercontent.com/DFerreira98/CocktailParty/master/app/src/main/java/com/example/cocktailparty/";

    private RecyclerView recyclerView;
    private ListAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private SharedPreferences sharedPreferences;
    private Gson gson;
    private List<Cocktail> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avec_alcool);

        sharedPreferences = getSharedPreferences("Cocktail Party ", Context.MODE_PRIVATE);

        gson = new GsonBuilder().setLenient().create();


        List<Cocktail> cocktailList = donneeEnCache();
        if(cocktailList != null){
            showList(cocktailList);
        }else{
            makeApiCall();
        }


    }
    private void showList(List<Cocktail> liste) {
        recyclerView =  findViewById(R.id.avecAlcool_recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new ListAdapter(liste,getApplicationContext());

        recyclerView.setAdapter(mAdapter);
    }

    private void makeApiCall() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        CocktailApi cocktailApi = retrofit.create(CocktailApi.class);

        Call<List<Cocktail>> call = cocktailApi.getCocktail();

        call.enqueue(new Callback<List<Cocktail>>() {
            @Override
            public void onResponse(Call<List<Cocktail>> call, Response<List<Cocktail>> response) {
                if(response.isSuccessful()){
                     list = response.body();
                    sauvegardeListe(list);
                    showList(list);
                    Toast.makeText(getApplicationContext(),"API SUCCESS",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"API ERROR on response",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Cocktail>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"API ERROR",Toast.LENGTH_LONG).show();
            }
        });


    }

    private void sauvegardeListe(List<Cocktail> liste){
        String jsonCocktail = gson.toJson(liste);


        sharedPreferences.edit().putString("jsonCocktail",jsonCocktail).apply();
        Toast.makeText(getApplicationContext(),"Liste sauvegardée",Toast.LENGTH_LONG).show();

    }

    private List<Cocktail> donneeEnCache(){

        String jsonCocktail = sharedPreferences.getString("jsonCocktail",null);
        if(jsonCocktail == null){
            return null;
        }else{
            Type listeType = new TypeToken<List<Cocktail>>(){}.getType();
            return gson.fromJson(jsonCocktail,listeType);
        }


    }

  
}
