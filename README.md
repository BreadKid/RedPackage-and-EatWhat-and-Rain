# RedPackage-and-EatWhat-and-Rain
## Demo
* ### About RedPackage
仿微信拼手气红包效果:  
![redGIF](http://i11.tietuku.com/fec69920910cef27.gif)	
实现靠后方差大的随机数效果，参考[知乎链接](https://www.zhihu.com/question/22625187);		
红包总金额限定200元，并有限定设置;		
各种非空判定，每人最低抢到0.01元限定;

* ### About EatWhat
随机出已存入的餐厅来决定今天吃什么:  	
调用Random.org的API（对于小量数据的随机而言并没有什么卵用～）;  	
选用百度地图API，实现餐厅位置查找;

* ### About Rain
仿微信撒花效果:  	
透明界面:  	
![rainGIF](http://i12.tietuku.com/8db73c3583fc4a86.gif)  	
用于其他界面:  	
![rainfrontsth](http://i12.tietuku.com/9a8d8bb036db8f77.gif)  	
撒落图片可选;

## Usage
* ### About RedPackage
wizout rain:  	
comment out these in MainActivity.java:  	

	    /**
	     *撒花效果
	     */
        rainView =(RainView)findViewById(R.id.rain_view);
        rainView.setImages(R.drawable.star);
        rainView.startRain();        
comment out these in activity_main.xml:
 
		<!-- 撒花效果 -->
		<com.example.breadykid.rain.raining.RainView
            android:id="@+id/rain_view"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:background="@android:color/transparent"/>
            

* ### About EatWhat
To be continued

* ### About Rain
  - #####rain only wiz transparent view
  change Android.Mainifest.xml:  
  
  	    android:theme="@android:style/Theme.Translucent.NoTitleBar.Fullscreen"
  change activity_main.xml:  
  comment out all fragment and leave this only  
  
    	    <!-- 撒花效果 -->
		<com.example.breadykid.rain.raining.RainView
            android:id="@+id/rain_view"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:background="@android:color/transparent"/>  
  
  - ##### rain over other fragment  
  change Android.Mainifest.xml:  
  
  	    android:theme="@android:style/Theme.NoTitleBar.Fullscreen"
  comment out fragment except lucky_money:
 
		<!-- 抢红包 -->
		<fragment
            android:id="@+id/lucky_money"
            android:name="com.example.breadykid.rain.redpackage.RedPackageFragment"
            tools:layout="@layout/lucky_money
            android:layout_width="match_parent"
            android:layout_height="match_parent"/>  
              
## License
伦家是很有开源精神的啦，license神马的不需要啦～玩得开心～么么哒～


