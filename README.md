# RedPackage-and-EatWhat-and-Rain
## Demo
* ### About RedPackage
仿微信拼手气红包效果:  
![redGIF](http://f.picphotos.baidu.com/album/s%3D680%3Bq%3D90/sign=1e6c28a6f036afc30a0c3c6d83229af9/0df431adcbef76095615fcf929dda3cc7cd99ebd.jpg)	
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
![rainGIF](http://d.picphotos.baidu.com/album/s%3D680%3Bq%3D90/sign=e0fdfb32044f78f0840b99fb490a7b68/b3b7d0a20cf431add0ff265f4c36acaf2edd98a2.jpg)  	
用于其他界面:  	
![rainfrontsth](http://e.picphotos.baidu.com/album/s%3D680%3Bq%3D90/sign=a2b7545e2f381f309a198ea1993a3d35/8d5494eef01f3a29116db3a89e25bc315c607c2a.jpg)  	
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
  - #####rain only wiz transparent view:
  chenge Android.Mainifest.xml:
 
		android:theme="@android:style/Theme.Translucent.NoTitleBar.Fullscreen"
  change activity_main.xml:  	
  comment out all fragment and leave this only
 
		<!-- 撒花效果 -->
		<com.example.breadykid.rain.raining.RainView
            android:id="@+id/rain_view"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:background="@android:color/transparent"/>
            
  - #####rain over other fragment:
  chenge Android.Mainifest.xml:
 
		android:theme="@android:style/Theme.NoTitleBar.Fullscreen"
  comment out fragment except lucky_money:
  
  	    <!-- 抢红包 -->
        <fragment
           android:id="@+id/lucky_money"
           android:name="com.example.breadykid.rain.redpackage.RedPackageFragment"
           tools:layout="@layout/lucky_money"
           android:layout_width="match_parent"
           android:layout_height="match_parent"/>
  
## License
伦家是很有开源精神的啦，license神马的不需要啦～玩得开心～么么哒～


