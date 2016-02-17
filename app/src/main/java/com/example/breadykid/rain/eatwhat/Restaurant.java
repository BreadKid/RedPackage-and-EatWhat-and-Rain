package com.example.breadykid.rain.eatwhat;

/**
 * Created by breadykid on 16/1/18.
 */
public class Restaurant {
    private String name;
    private String address;
    private String tel;
    private String favourite;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFavourite() {
        return favourite;
    }

    public void setFavourite(String favourite) {
        this.favourite = favourite;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tel=" + tel +
                ", favourite='" + favourite + '\'' +
                ", price=" + price +
                '}';
    }
}
