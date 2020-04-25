package com.example.cocktailparty.Controler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cocktailparty.Controler.AvecAlcool;
import com.example.cocktailparty.R;

public class MainActivity extends AppCompatActivity {

    private Button avecAlcool;
    private Button sansAlcool;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        avecAlcool = findViewById(R.id.avec_alcool);
        sansAlcool = findViewById(R.id.sans_alcool);

        avecAlcool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                cliqueAlcool();
            }
        });
        sansAlcool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cliqueSansAlcool();
            }
        });



    }

    private void cliqueAlcool(){
        Intent i = new Intent (getApplicationContext(), AvecAlcool.class);
        startActivity(i);
        finish();
    }

    private void cliqueSansAlcool(){
        Intent i = new Intent (getApplicationContext(), SansAlcool.class);
        startActivity(i);
        finish();
    }


}
