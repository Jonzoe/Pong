package com.example.pong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MyCanvas extends View {

    // Variabler
    private int cornerRadius = 50;

    float xPos;
    float yPos;
    float xPos2;
    float yPos2;

    private int xDelta;
    private int yDelta;

    Paint paint;

    RectF r = new RectF(200,350,250,600);

    Paint fillPaint = new Paint();
    Paint strokePaint = new Paint();

    public MyCanvas(Context context) {
        super(context);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        paint = new Paint(); // Skapar "Paint"
        paint.setColor(Color.RED); // Sätter "Paint" till röd
        paint.setStrokeWidth(10); // Sätter konturer
        paint.setStyle(Paint.Style.STROKE); // Ritar ut konturer
        canvas.drawCircle(xPos,yPos,100,paint); // Ritar en cirkel för första touchen
        canvas.drawCircle(xPos2,yPos2,100,paint); // Ritar en cirkel för andra touchen

        // Ritar ut rektanglarna
        fillPaint.setStyle(Paint.Style.FILL);
        fillPaint.setColor(Color.GREEN); // Sätter fyllnaden till grön

        // Kanten
        strokePaint.setStyle(Paint.Style.STROKE);
        strokePaint.setColor(Color.BLACK);
        strokePaint.setStrokeWidth(10);

        // Första rektangeln
        canvas.drawRoundRect(r, cornerRadius, cornerRadius, fillPaint); // fill
        canvas.drawRoundRect(r, cornerRadius, cornerRadius, strokePaint); // stroke

        canvas.translate(1800, 0);

        // Andra rektangeln
        canvas.drawRoundRect(r, cornerRadius, cornerRadius, fillPaint);    // fill
        canvas.drawRoundRect(r, cornerRadius, cornerRadius, strokePaint);  // stroke
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Log.d("fu", "onTouchEvent: "+this.getWidth());
                final int X = (int) event.getRawX();
                final int Y = (int) event.getRawY();

            switch (event.getAction() & MotionEvent.ACTION_MASK) {

                case MotionEvent.ACTION_DOWN:
                case MotionEvent.ACTION_MOVE: {

                    if (event.getPointerCount() > 1) {
                        Log.d("Touch 2","Multitouch event");
                        if (event.getX(0) <= this.getWidth()/2){
                            xPos = event.getX(0);
                            yPos = event.getY(0);
                        }
                        if (event.getX(1) >= this.getWidth()/2) {
                            xPos2 = event.getX(1);
                            yPos2 = event.getY(1);
                        }
                        invalidate();
                    } else {
                        // Single touch event
                        Log.d("Single Touch","Single touch event");
                        if (event.getX() <= this.getWidth()/2){
                            xPos = event.getX();
                            yPos = event.getY();
                        }
                        if (event.getX() >= this.getWidth()/2){
                            xPos2 = event.getX();
                            yPos2 = event.getY();
                        }
                        invalidate();
                    }
                }
            }
            return true;
        }
}