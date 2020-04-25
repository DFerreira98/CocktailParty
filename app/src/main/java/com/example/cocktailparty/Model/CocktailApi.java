package com.example.cocktailparty.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CocktailApi {

    @GET("")
    Call<List<Cocktail>> getCocktail();
}
