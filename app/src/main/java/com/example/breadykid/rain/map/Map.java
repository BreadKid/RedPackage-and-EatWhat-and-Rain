package com.example.breadykid.rain.map;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.example.breadykid.rain.R;

/**
 * Created by breadykid on 16/2/18.
 */
public class Map extends Fragment implements View.OnClickListener {

    public MyLocationListenner myLocationListenner = new MyLocationListenner();
    private MapView mMapView;
    private BaiduMap mBaiduMap;
    private LocationClient mLocClient;
    private BitmapDescriptor mCurrentMarker;
    private MyLocationConfiguration.LocationMode mCurrentMode;

    private ImageView iv_btn_menu;

    private int mapType = 0; //地图类型

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.map, container, false);
        //获取地图控件引用
        mMapView = (MapView) view.findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();
        //普通地图
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        //开启定位图层
        mBaiduMap.setMyLocationEnabled(true);
        mCurrentMode = MyLocationConfiguration.LocationMode.NORMAL; // 普通状态
//        mCurrentMarker=null; // 传入null则，恢复默认图标
        mCurrentMarker = BitmapDescriptorFactory.fromResource(R.drawable.star); //自定义图标
        mBaiduMap.setMyLocationConfigeration(new MyLocationConfiguration(mCurrentMode, true, mCurrentMarker));
        // 定位初始化
        mLocClient = new LocationClient(getActivity());
        mLocClient.registerLocationListener(myLocationListenner);
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 开GPS
        option.setCoorType("bd09ll"); //坐标类型 正常
//        option.setCoorType("bd09"); //坐标类型 nothing
//        option.setCoorType("gcj02"); //坐标类型 坐标位置错误
        option.setScanSpan(1000);
        mLocClient.setLocOption(option);

        iv_btn_menu = (ImageView) view.findViewById(R.id.iv_btn_menu);
        iv_btn_menu.setOnClickListener(this);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // 退出时销毁定位
        mLocClient.stop();
        // 关闭定位图层
        mBaiduMap.setMyLocationEnabled(false);
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
        mMapView = null;
    }

    @Override
    public void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }

    /**
     * 星星按钮
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (mapType) {
            case 0:
                //普通地图
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                break;
            case 1:
                //卫星地图
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
                break;
//            case 2:
//                //空白地图, 基础地图瓦片将不会被渲染。在地图类型中设置为NONE，将不会使用流量下载基础地图瓦片图层。
//                //使用场景：与瓦片图层一起使用，节省流量，提升自定义瓦片图下载速度。
//                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NONE);
//                break;
            case 2:
                mLocClient.start(); // 开始定位
                break;

            default:
                break;
        }

        mapType++;
        if (mapType == 3) { // 循环按钮
            mapType = 0;
        }

    }

    /**
     * Created by breadykid on 16/2/22.
     * 定位SDK监听函数
     */
    public class MyLocationListenner implements BDLocationListener {

        private boolean isFirstLoc = true; // 是否首次定位

        @Override
        public void onReceiveLocation(BDLocation location) {
            // map view 销毁后不在处理新接收的位置
            if (location == null || mMapView == null) {
                return;
            }
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(100).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            mBaiduMap.setMyLocationData(locData);
            if (isFirstLoc) {
                isFirstLoc = false;
                LatLng ll = new LatLng(location.getLatitude(),
                        location.getLongitude());
                MapStatus.Builder builder = new MapStatus.Builder();
                builder.target(ll).zoom(18.0f);
                mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
            }
        }

        public void onReceivePoi(BDLocation poiLocation) {

        }

    }
}
