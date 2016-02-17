package com.example.breadykid.rain.eatwhat;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.breadykid.rain.R;

/**
 * Created by breadykid on 16/1/18.
 */
public class DBControlFragment extends Fragment implements View.OnClickListener,AdapterView.OnItemClickListener {

    private DBHelper dbHelper;
    private Cursor mCursor;

    private Button btn_insert;
    private Button btn_delete;
    private Button btn_update;
    private Button btn_select;
    private EditText et_restaurant_name;
    private EditText et_restaurant_address;
    private EditText et_restaurant_tel;
    private EditText et_restaurant_favourite;
    private EditText et_restaurant_price;
    private ListView lv_restaurant;

    /**
     * 控件初始化
     * @param view
     */
    private void init(View view){
        btn_insert=(Button) view.findViewById(R.id.btn_insert);
        btn_delete=(Button) view.findViewById(R.id.btn_delete);
        btn_update=(Button) view.findViewById(R.id.btn_update);
        btn_select=(Button) view.findViewById(R.id.btn_select);
        et_restaurant_address=(EditText) view.findViewById(R.id.et_restaurant_address);
        et_restaurant_name=(EditText) view.findViewById(R.id.et_restaurant_name);
        et_restaurant_tel=(EditText) view.findViewById(R.id.et_restaurant_tel);
        et_restaurant_favourite=(EditText) view.findViewById(R.id.et_restaurant_favourite);
        et_restaurant_price=(EditText) view.findViewById(R.id.et_restaurant_price);
        lv_restaurant=(ListView) view.findViewById(R.id.lv_restaurant);
    }

    /**
     * 点击初始化
     * @param view
     */
    private void onClickInit(View view){
        btn_insert.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
        btn_update.setOnClickListener(this);
        btn_select.setOnClickListener(this);
        view.setOnClickListener(this);
        lv_restaurant.setOnItemClickListener(this);

    }

    /**
     * 创建view
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.input_info,container,false);
        dbHelper=new DBHelper(getContext());
        init(view);
        onClickInit(view);
//        lv_restaurant.setAdapter(new RestaurantListAdapter(mCursor,getContext()));
        return view;
    }

    /**
     * 按钮点击事件
     * @param v
     */
    @Override
    public void onClick(View v) {
        Restaurant restaurant=new Restaurant();
        switch (v.getId()){
            case R.id.btn_insert:
                if (!et_restaurant_name.getText().toString().equals("")){
                    restaurant.setName(et_restaurant_name.getText().toString().replace(" ",""));
                    restaurant.setAddress(et_restaurant_address.getText().toString().replace(" ",""));
                    restaurant.setTel(et_restaurant_tel.getText().toString().replace(" ",""));
                    restaurant.setFavourite(et_restaurant_price.getText().toString().replace(" ",""));
                    restaurant.setPrice(Integer.parseInt(et_restaurant_favourite.getText().toString().replace(" ","")));
                    dbHelper.insert(restaurant);
                }else{
                    Toast.makeText(getContext(),"pls input the restaurant's name first",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_delete:
                dbHelper.delete();
                break;
            case R.id.btn_update:
                dbHelper.update();
                break;
            case R.id.btn_select:
                if(!et_restaurant_name.getText().toString().equals("")){

                }else{
                    mCursor=dbHelper.seleteAll();
                }
                break;
            default:
                break;
        }
    }

    /**
     * 条目点击事件
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
