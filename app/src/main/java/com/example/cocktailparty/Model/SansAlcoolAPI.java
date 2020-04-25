package com.example.cocktailparty.Model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SansAlcoolAPI {

    public static String base_url="https://raw.githubusercontent.com/DFerreira98/CocktailParty/master/app/src/main/java/com/example/cocktailparty/";

    public static Retrofit getClient(){
        Retrofit r = new Retrofit.Builder().baseUrl(base_url).addConverterFactory(GsonConverterFactory.create()).build();
        return  r;
    }

    public static CocktailApi interfaceAPI(){
        return  getClient().create(CocktailApi.class);

    }
}
