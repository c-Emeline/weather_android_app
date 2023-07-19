package com.example.weather_emeline_creusot;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.math.BigDecimal;

public class City implements Serializable {

    private String name;
    private String id;
    private String country;
    private Weather weather;

    public City(JSONObject jsonObject) {
        this.fromJSONObject(jsonObject);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weather getWeather() {
        return weather;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public void fromJSONObject(JSONObject jsonObject) {
        try {
            this.id = jsonObject.getString("id");
            this.name = jsonObject.getString("name");
            JSONObject sys = jsonObject.getJSONObject("sys");
            this.country = sys.getString("country");
            JSONObject main = jsonObject.getJSONObject("main");
            float temp = BigDecimal.valueOf(main.getDouble("temp")).floatValue();
            int pressure = main.getInt("pressure");
            int humidity = main.getInt("humidity");
            this.weather= new Weather(temp, humidity, pressure);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
