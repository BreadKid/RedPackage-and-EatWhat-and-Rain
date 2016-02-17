package com.example.breadykid.rain.redpackage;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.breadykid.rain.R;

/**
 * Created by breadykid on 16/2/14.
 */
public class RedPackageFragment extends Fragment implements View.OnClickListener {

    private Button btn_send_money;
    private EditText et_num;
    private EditText et_money;
    private EditText et_blessing;
    private ListView lv_redpackage;

    private Cursor mCursor;

    private void init(View view) {
        btn_send_money = (Button) view.findViewById(R.id.btn_send_money);
        et_num = (EditText) view.findViewById(R.id.et_num);
        et_money = (EditText) view.findViewById(R.id.et_money);
        et_blessing = (EditText) view.findViewById(R.id.et_blessing);
        lv_redpackage = (ListView) view.findViewById(R.id.lv_redpackage);
    }

    private void onClickInit() {
        btn_send_money.setOnClickListener(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lucky_money, container, false);
        init(view);
        onClickInit();
        InputFilter[] inputFilters = {new PriceJudge()};
        et_money.setFilters(inputFilters);

        return view;

    }


    @Override
    public void onClick(View v) {
        String sNum = et_num.getText().toString().replace(" ", "");
        String sMoney = et_money.getText().toString().replace(" ", "");
        if (!"".equals(sNum) && !"".equals(sMoney)) {
            int num = Integer.parseInt(sNum);
            double money = Double.parseDouble(sMoney);
            if (0.01 * num > money) {
                Toast.makeText(getContext(), "人均不得低于0.01元", Toast.LENGTH_SHORT).show();
            } else {
                Log.i(getClass().getName(),RandomMoney.getRandomMoney(num, money).toString());
                lv_redpackage.setAdapter(new RedPackageAdapter(RandomMoney.getRandomMoney(num, money),getContext()));
                Toast.makeText(getContext(), "生成完", Toast.LENGTH_SHORT).show();
                lv_redpackage.setVisibility(View.VISIBLE);
            }
        } else {
            Toast.makeText(getContext(), "请输入完整", Toast.LENGTH_SHORT).show();
        }

    }
}
