package com.example.cocktailparty.Controler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cocktailparty.R;

import org.w3c.dom.Text;

public class ClickActivity extends AppCompatActivity {


    private TextView textViewIngredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);

        textViewIngredients = findViewById(R.id.ingredients);
       Intent i = getIntent();

       String ingredients = i.getStringExtra("ingredients");

       textViewIngredients.setText("Ingredients : " + ingredients);


    }
}
