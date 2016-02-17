package com.example.breadykid.rain.eatwhat;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by breadykid on 16/1/28.
 */
public class RestaurantListAdapter extends BaseAdapter {

    private Cursor mCursor;
    private Context mContext;

    public RestaurantListAdapter(Cursor Cursor, Context Context) {
        this.mCursor = Cursor;
        this.mContext = Context;
    }

    @Override
    public int getCount() {
        return mCursor.getCount();
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
        mCursor.moveToPosition(position);

        return null;
    }

}
