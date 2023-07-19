package com.example.weather_emeline_creusot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class CityWeather extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_weather);


        City city = (City) getIntent().getSerializableExtra("cityObject");

        TempView tempView = findViewById(R.id.tempView);
        tempView.setWeather(city.getWeather());
        HumidityView humView = findViewById(R.id.humidityView);
        humView.setWeather(city.getWeather());
        PressureView presView = findViewById(R.id.pressureView);
        presView.setWeather(city.getWeather());


        TextView name = findViewById(R.id.cityNameWeather);
        TextView temp = findViewById(R.id.tempWeather);
        TextView pressure = findViewById(R.id.pressureWeather);
        TextView humidity = findViewById(R.id.humidityWeather);

        name.setText(city.getName());

        Weather weather = city.getWeather();
        String tempString =" ";
        String tempS = tempString.valueOf(weather.getTemp());
        temp.setText(temp.getText()+"  "+tempS+" °C");

        String presString =" ";
        String presS = tempString.valueOf(weather.getPressure());
        pressure.setText(pressure.getText()+"  "+presS+" hPa");

        String humidString =" ";
        String humidS = humidString.valueOf(weather.getHumidity());
        humidity.setText(humidity.getText()+"  "+humidS+"%");




    }
}