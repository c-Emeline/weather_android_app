package com.example.weather_emeline_creusot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartClick(View view){

        TextInputLayout cityTextInput = findViewById(R.id.cityTextInput);
        Editable cityInput = cityTextInput.getEditText().getText();

        Intent intent = new Intent(getApplicationContext(), HomeWeather.class);
        intent.putExtra("city", cityInput.toString());
        startActivity(intent);
    }
}