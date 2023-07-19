package com.example.weather_emeline_creusot;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class PressureView extends View {

    private Paint pressurePaint;
    private Paint pressureLowPaint;
    private Paint pressureHighPaint;
    private Weather weather;



    public PressureView(Context context){
        super(context);
        init();

    }


    public PressureView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
        init();
    }

    public PressureView(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        init();
    }

    protected void onDraw(Canvas canvas){

        int width = getWidth();
        int height = getHeight();

        float rectWidth = 30f;
        float gap = (width-4f*rectWidth)/3f;

        Paint paintToUse = pressureHighPaint;
        if (weather.getPressure()<990){
            paintToUse = pressureLowPaint;
        }

        float height1 = 30f;
        canvas.translate(0, height/2+height1/2);
        canvas.drawRect(0, -height1, rectWidth, 0 , pressurePaint);
        if (weather.getPressure()>960){
            canvas.drawRect(2, -height1+2, rectWidth-2, -2, paintToUse);
        }

        float height2 = height1+30f;
        canvas.translate(gap, 0);
        canvas.drawRect(0, -height2, rectWidth, 0 , pressurePaint);
        if (weather.getPressure()>990){
            canvas.drawRect(2, -height2+2, rectWidth-2, -2, paintToUse);
        }

        float height3 = height2+30f;
        canvas.translate(gap, 0);
        canvas.drawRect(0, -height3, rectWidth, 0 , pressurePaint);
        if (weather.getPressure()>1015){
            canvas.drawRect(2, -height3+2, rectWidth-2, -2, paintToUse);
        }

        float height4 = height3+30f;
        canvas.translate(gap, 0);
        canvas.drawRect(0,  -height4 , rectWidth,0 , pressurePaint);
        if (weather.getPressure()>1030){
            canvas.drawRect(2, -height4+2, rectWidth-2, -2, paintToUse);
        }

    }

    private void init(){

        Resources resources = getResources();

        this.pressurePaint = new Paint();
        pressurePaint.setColor(resources.getColor(R.color.light_grey));
        pressurePaint.setStyle(Paint.Style.STROKE);
        pressurePaint.setStrokeWidth(4);

        this.pressureHighPaint = new Paint();
        pressureHighPaint.setColor(resources.getColor(R.color.yellow));
        pressureHighPaint.setStyle(Paint.Style.FILL);

        this.pressureLowPaint = new Paint();
        pressureLowPaint.setColor(resources.getColor(R.color.pastel_red));
        pressureLowPaint.setStyle(Paint.Style.FILL);

    }

    public void setWeather(Weather weather){

        this.weather = weather;

    }


}
