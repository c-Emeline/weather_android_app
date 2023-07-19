package com.example.weather_emeline_creusot;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class APIService {

    private Context context;
    private RequestQueue requestQueue;

    private static APIService instance;

    private APIService(Context context) {
        this.context = context;
        requestQueue = Volley.newRequestQueue(context);
    }

    public static APIService getInstance(Context context) {
        if (instance == null) {
            instance = new APIService(context);
        }
        return instance;
    }

    public void getCityList(Response.Listener<JSONObject> responseListener, Response.ErrorListener errorListener, String citySearched) {

        String url = "https://api.openweathermap.org/data/2.5/find?q="+citySearched+"&units=metric&appid=d041897bb0e9ecf30de085339892ccc0";

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                responseListener,
                errorListener
        );

        requestQueue.add(request);
    }


    public void getCityMeteo(String citySearched, Response.Listener<JSONObject> responseListener, Response.ErrorListener errorListener) {
        String url = "https://api.openweathermap.org/data/2.5/find?q="+citySearched+"&units=metric&appid=d041897bb0e9ecf30de085339892ccc0";

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                responseListener,
                errorListener
        );

        requestQueue.add(request);
    }

}
