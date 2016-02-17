package com.example.breadykid.rain.eatwhat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by breadykid on 16/1/18.
 */
public class DBHelper extends SQLiteOpenHelper{

    private Context mContext;
    private ContentValues contentValues=new ContentValues();

    public DBHelper(Context context) {
        super(context, SQLUtil.DB_NAME, null, 1);
        mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLUtil.CREATE_RESTAURANT);
        Toast.makeText(mContext,"create succeed",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * insert management : to insert data
     */
    public long insert(Restaurant restaurant){
            if(restaurant!=null&&!restaurant.toString().equals("")){
                SQLiteDatabase db=getWritableDatabase();
                contentValues.put(SQLUtil.RESTAURANT_NAME,restaurant.getName());
                contentValues.put(SQLUtil.RESTAURANT_ADDRESS,restaurant.getAddress());
                contentValues.put(SQLUtil.RESTAURANT_TEL,restaurant.getTel());
                contentValues.put(SQLUtil.RESTAURANT_PRICE,restaurant.getPrice());
                contentValues.put(SQLUtil.RESTAURANT_FAVOURITE,restaurant.getFavourite());
                long row=db.insert("restaurant",null,contentValues);
                Toast.makeText(mContext, "Add Successed!", Toast.LENGTH_SHORT).show();
                return row;
            }else{
                Toast.makeText(mContext,"this restaurant has been existed,if u need,pls update",Toast.LENGTH_SHORT).show();
                return 0000;
            }
    }

    /**
     * delete management : to delete data
     */
    public void delete(){

    }

    /**
     * update management : to update data
     */
    public void update(){

    }

    /**
     * selete management : to select all data
     */
    public Cursor seleteAll(){
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=db.query(SQLUtil.TABLE_NAME,null,null,null,null,null,null);
        return cursor;
    }

    /**
     * selete management : to select some
     */
    public Cursor selectBySth(){
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=db.query(SQLUtil.TABLE_NAME,null,null,null,null,null,null);
        return cursor;
    }
}
