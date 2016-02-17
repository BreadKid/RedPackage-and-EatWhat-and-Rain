package com.example.breadykid.rain.eatwhat;

/**
 * Created by breadykid on 16/1/18.
 */
public class SQLUtil {

    public static final String CREATE_RESTAURANT = "CREATE TABLE restaurant ("
            + "id INTEGER primary key autoincrement, "
            + "name text, "
            + "address text, "
            + "tel integer, "
            + "price real, "
            + "favourite text)";

    public static final String DB_NAME="restaurant";
    public static final String TABLE_NAME="restaurant";
    public static final String RESTAURANT_NAME="name";
    public static final String RESTAURANT_ADDRESS="address";
    public static final String RESTAURANT_TEL="tel";
    public static final String RESTAURANT_PRICE="price";
    public static final String RESTAURANT_FAVOURITE="favourite";

}
