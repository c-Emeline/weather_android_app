package com.example.weather_emeline_creusot;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class HumidityView extends View {

    private Paint fullCirclePaint;
    private Paint circlePaint;
    private Weather weather;



    public HumidityView(Context context){
        super(context);
        init();
    }

    public HumidityView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
        init();
    }

    public HumidityView(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        init();
    }

    protected void onDraw(Canvas canvas){

        int width = getWidth();
        int height = getHeight();

        float circleRadius = width/2-20;
        canvas.translate(width/2, height/2);
        canvas.drawCircle(0, 0, circleRadius, circlePaint);

        Resources resources = getResources();
        fullCirclePaint.setColor(resources.getColor(R.color.yellow));
        if (weather.getHumidity()>80){
            fullCirclePaint.setColor(resources.getColor(R.color.pastel_red));
        }


        float fullCircleRadius = (weather.getHumidity()/100f)*(circleRadius);
        canvas.drawCircle(0, 0, fullCircleRadius, fullCirclePaint);

    }

    private void init(){

        Resources resources = getResources();

        this.circlePaint = new Paint();
        circlePaint.setColor(resources.getColor(R.color.light_grey));
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setStrokeWidth(4);

        this.fullCirclePaint = new Paint();
        fullCirclePaint.setStyle(Paint.Style.FILL);

    }

    public void setWeather(Weather weather){

        this.weather = weather;

    }

}
