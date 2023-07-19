package com.example.weather_emeline_creusot;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class TempView extends View{

    private Paint redThermoPaint;
    private Paint thermoPaint;
    private Weather weather;



    public TempView(Context context){
        super(context);
        init();

    }

    public TempView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
        init();
    }

    public TempView(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        init();
    }

    protected void onDraw(Canvas canvas){

        int width = getWidth();
        int height = getHeight();

        float rectHeightThermo = 200f;
        float rectWidth = 80f;
        canvas.translate(width/2, height/2);
        canvas.drawRect(-rectWidth/2, rectHeightThermo/2, rectWidth/2, -rectHeightThermo/2 , thermoPaint);

        float tempRange = 60f;
        float rectHeightRed = ((weather.getTemp()+20f)/tempRange)*(rectHeightThermo);
        canvas.translate(0, rectHeightThermo/2);
        canvas.drawRect(-rectWidth/2+2, -rectHeightRed , rectWidth/2-2, -2, redThermoPaint);



        }

        private void init(){

            Resources resources = getResources();

            this.thermoPaint = new Paint();
            thermoPaint.setColor(resources.getColor(R.color.yellow));
            thermoPaint.setStyle(Paint.Style.STROKE);
            thermoPaint.setStrokeWidth(4);

            this.redThermoPaint = new Paint();
            redThermoPaint.setColor(resources.getColor(R.color.pastel_red));
            redThermoPaint.setStyle(Paint.Style.FILL);

        }

        public void setWeather(Weather weather){

            this.weather = weather;

        }

    }
