package com.example.cocktailparty.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CocktailApi {

    @GET("api.json")
    Call<List<Cocktail>> getCocktail();

    @GET("apiSansAlcool.json")
    Call<List<Cocktail>> getCocktailSansAlcool();
}
