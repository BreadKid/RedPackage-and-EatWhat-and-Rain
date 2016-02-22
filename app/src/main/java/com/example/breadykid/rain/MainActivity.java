package com.example.breadykid.rain;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

import com.baidu.mapapi.SDKInitializer;
import com.example.breadykid.rain.raining.RainView;

public class MainActivity extends FragmentActivity {

    private RainView rainView;
    private Button btn;
    private boolean flag=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.btn_star_rain);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag){
                    rainView.stopRainDely(); //下完这阵再关
//                    rainView.stopRainNow(); //立马关
                    btn.setText("open star rain");
                    flag=false;
                }else{
                    rainView.startRain();
                    btn.setText("close star rain");
                    flag=true;
                }
            }
        });

        //撒花效果
        rainView =(RainView)findViewById(R.id.rain_view);
        rainView.setImages(R.drawable.star);
        rainView.startRain();
    }

}
