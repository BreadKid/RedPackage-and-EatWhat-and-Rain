package com.example.breadykid.rain.redpackage;

import android.text.InputFilter;
import android.text.Spanned;

/**
 * Created by breadykid on 16/2/14.
 * input price type
 */
public class PriceJudge implements InputFilter{

    /**
     * 单个红包最大值
     */
    public static final int MAX_VALUE=200;

    /**
     * 小数点后限定位数
     */
    public static final int POINTINT_LENGTH=2;

    /**
     *
     * @param source 新输入的字符串
     * @param start 新输入的字符串起始下标，0
     * @param end 新输入的字符串终点下标，source－1
     * @param dest 输入前原内容
     * @param dstart 输入前原内容起始下标，0
     * @param dend 输入前原内容终点下标，dest－1
     * @return
     */
    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

        String oldtext=dest.toString().replace(" ","");

        //非空验证
        if ("".equals(source.toString().replace(" ",""))){
            return null;
        }

        //非数字与小数验证
//        Matcher matcher=p.matcher(source);
//        if(oldtext.contains(".")){ //有小数点
//            if(!matcher.matches()){ //只可数字
//                return null;
//            }
//        }else{ //无小数点
//            if(!matcher.matches()&&!source.equals(".")){
//                return null;
//            }
//        }

        //金额验证
        if(!source.toString().replace(" ","").equals("")){
            double oldPrice=Double.parseDouble(oldtext+source.toString().replace(" ",""));
            if(oldPrice>MAX_VALUE){
                return dest.subSequence(dstart,dend);
            }else if(oldPrice==MAX_VALUE){
                if(source.toString().replace(" ","").equals(".")){
                    return dest.subSequence(dstart,dend);
                }
            }
        }

        //小数精度验证
        if(oldtext.contains(".")){
            int point=oldtext.indexOf(".");
            int length=dend-point;
            if(length>POINTINT_LENGTH){
                CharSequence newtext=dest.subSequence(dstart,dend);
                return newtext;
            }
        }
        return dest.subSequence(dstart,dend)+source.toString().replace(" ","");
    }
}
