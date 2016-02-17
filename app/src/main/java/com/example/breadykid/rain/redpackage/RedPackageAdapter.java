package com.example.breadykid.rain.redpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by breadykid on 16/2/15.
 */
public class RedPackageAdapter extends BaseAdapter{

    private ArrayList<String> mList;
    private Context mContext;
    private TextView tv;

    public RedPackageAdapter(ArrayList<String> list, Context Context) {
        this.mList = list;
        this.mContext = Context;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        tv=new TextView(mContext);
        tv.setText(mList.get(position).toString());
        return tv;
    }
}
