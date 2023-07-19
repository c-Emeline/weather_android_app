package com.example.weather_emeline_creusot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeWeather extends AppCompatActivity {

    ListView cityList;
    TextView cityTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_weather);

        TextView citySearched = findViewById(R.id.citySearched);

        String citySearchedName = getIntent().getStringExtra("city");
        citySearched.setText(citySearchedName);

        this.cityList = findViewById(R.id.cityList);

        APIService.getInstance(getApplicationContext()).getCityList(
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(HomeWeather.this, "Données reçues", Toast.LENGTH_SHORT).show();
                        showCities(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(HomeWeather.this, "CPT", Toast.LENGTH_SHORT).show();
                    }
                },
                citySearchedName
        );
    }

    private void showCities(JSONObject apiResponse) {
        List<City> cities = new ArrayList<>();

        try {
            JSONArray cityList = apiResponse.getJSONArray("list");

            for (int i=0; i<cityList.length(); i++) {
                JSONObject cityJson = cityList.getJSONObject(i);
                cities.add(new City(cityJson));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        CityArrayAdapter adapter = new CityArrayAdapter(getApplicationContext(), cities);
        cityList.setAdapter(adapter);

        cityList.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
                Intent intent = new Intent(getApplicationContext(), CityWeather.class);
                intent.putExtra("cityObject", cities.get(index));
                startActivity(intent);
            }
        });

    }

}