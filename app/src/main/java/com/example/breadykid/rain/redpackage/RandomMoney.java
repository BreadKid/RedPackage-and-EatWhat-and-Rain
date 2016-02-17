package com.example.breadykid.rain.redpackage;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by breadykid on 16/2/15.
 */
public class RandomMoney {

    public static ArrayList<String> getRandomMoney(int numRemain, double moneyRemain) {

        Random r = new Random();
        final double min = 0.01;
        int num = numRemain;
        double money = moneyRemain;
        ArrayList<String> list = new ArrayList<String>();

        if (min * num == money) {
            for(int i=1;i<num;i++){
                list.add(min + "");
            }
        } else {
            for (int i = 1; i < numRemain + 1; i++) {
                if (num == 1) {
                    list.add((double) Math.round(money * 100) / 100 + "");
                }
                double max = money / num * 2;
                double per = r.nextDouble() * max;
                per = per <= min ? 0.01 : per;
                per = Math.floor(per * max * 100) / 100;
                num--;
                money -= per;
                list.add(per + "");
            }
        }
        return list;
    }
}
