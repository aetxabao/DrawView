package com.pmdm.drawview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout layout = (RelativeLayout)findViewById(R.id.Layout);
        Lienzo fondo = new Lienzo(this);
        layout.addView(fondo);
    }

    class Lienzo extends View {

        public Lienzo(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas){
            canvas.drawRGB(0,0,255);
            int w = canvas.getWidth();
            int h = canvas.getHeight();
            Paint paint = new Paint();
            paint.setARGB(255, 255, 0, 0);
            canvas.drawLine(0, 0, w, h, paint);
            paint.setStrokeWidth(4);
            canvas.drawLine(w, 0, 0, h, paint);

            paint.setStyle(Paint.Style.STROKE);
            canvas.drawRect(10, 10, w-10, 40, paint);

            canvas.drawCircle(w/2, h/2, 50, paint);

            RectF rect = new RectF(0,0,w,h);
            canvas.drawOval(rect, paint);

            paint.setTextSize(60);
            paint.setTypeface(Typeface.MONOSPACE);
            canvas.drawText("Hello!", 20, 320, paint);

            Typeface tf = Typeface.createFromAsset(getAssets(), "Amburegul.ttf");
            paint.setTypeface(tf);
            paint.setTextSize(120);
            canvas.drawText("Hola!", 20, 220, paint);
        }
    }
}
