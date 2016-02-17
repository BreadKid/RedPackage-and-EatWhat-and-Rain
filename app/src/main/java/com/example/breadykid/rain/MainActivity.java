package com.example.breadykid.rain;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.breadykid.rain.raining.RainView;

public class MainActivity extends FragmentActivity {

    public RainView rainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rainView =(RainView)findViewById(R.id.rain_view);
        rainView.setImages(R.drawable.star);
        rainView.startRain();
    }

}
