package com.xjy.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 徐静钰 on 2017/9/8.
 */
public class Lq6FuctionActivity extends Activity implements View.OnClickListener {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.fuc1)
    LinearLayout fuc1;
    @Bind(R.id.fuc3)
    LinearLayout fuc3;
    @Bind(R.id.fuc5)
    LinearLayout fuc5;
    @Bind(R.id.fuc2)
    LinearLayout fuc2;
    @Bind(R.id.fuc4)
    LinearLayout fuc4;
    @Bind(R.id.fuc6)
    LinearLayout fuc6;

    private Activity activity;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lq6_fuction);
        ButterKnife.bind(this);
        activity = this;
        intent = new Intent();
        fuc1.setOnClickListener(this);
        fuc2.setOnClickListener(this);
        fuc3.setOnClickListener(this);
        fuc4.setOnClickListener(this);
        fuc5.setOnClickListener(this);
        fuc6.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fuc1:
                intent.setClass(activity, Lq1Activity.class);
                startActivity(intent);
                break;

            case R.id.fuc2:
                intent.setClass(activity, Lq2Activity.class);
                startActivity(intent);
                break;

            case R.id.fuc3:
                intent.setClass(activity, Lq3Activity.class);
                startActivity(intent);
                break;


            case R.id.fuc4:
                intent.setClass(activity, Lq4Activity.class);
                startActivity(intent);
                break;


            case R.id.fuc5:
                intent.setClass(activity, Lq5Activity.class);
                startActivity(intent);
                break;


            case R.id.fuc6:
                intent.setClass(activity, Lq6LoginActivity.class);
                startActivity(intent);
                break;


            default:
                break;


        }
    }
}
