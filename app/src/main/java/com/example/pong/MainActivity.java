package com.example.pong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MyCanvas myCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myCanvas = new MyCanvas(this);
        setContentView(myCanvas);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
    }
}