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

    private ImageView imageView;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);

        imageView = findViewById(R.id.image);
        textView = findViewById(R.id.ingredients);

        Intent intent = getIntent();

        String ingredients = intent.getStringExtra("ingredients");
        textView.setText("Ingrédients : "+ingredients);

        String image = intent.getStringExtra("strDrinkThumb");
        Glide.with(this).load(image).into(imageView);
    }
}
