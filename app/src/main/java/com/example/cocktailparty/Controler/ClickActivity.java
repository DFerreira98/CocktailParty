package com.example.cocktailparty.Controler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cocktailparty.R;

import org.w3c.dom.Text;

public class ClickActivity extends AppCompatActivity {

    private ImageView imageViewIngredient;
    private TextView textViewName,textViewIngredient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);

        textViewName = findViewById(R.id.name);
        imageViewIngredient = findViewById(R.id.image);
        textViewIngredient = findViewById(R.id.ingredient);

        Intent i = getIntent();

        String name = i.getStringExtra("strDrink");
        String ingredient = i.getStringExtra("ingredient");
        String image = i.getStringExtra("strDrinkThumb");

        textViewName.setText("Name : " + name);
        textViewIngredient.setText("Ingrédients " + ingredient);

        Glide.with(this).load(image).into(imageViewIngredient);


    }
}
