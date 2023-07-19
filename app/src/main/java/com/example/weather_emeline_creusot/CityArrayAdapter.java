package com.example.weather_emeline_creusot;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CityArrayAdapter extends ArrayAdapter<City> {

    private List<City> cities;
    private LayoutInflater inflater;

    public CityArrayAdapter(Context context, List<City> cities) {
        super(context, -1, cities);
        this.cities = cities;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View cityLine = inflater.inflate(R.layout.city_tv, parent, false);

        TextView cityName = cityLine.findViewById(R.id.cityName);

        City city = cities.get(position);

        cityName.setText(city.getName()+"    |"+city.getCountry()+"|");

        return cityLine;
    }
}
