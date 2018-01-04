package com.xjy.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.xjy.adapter.MsgChatAdapter;
import com.xjy.entity.MsgInfo;
import com.xjy.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;
import retrofit2.http.Query;

public class MainActivity extends Activity implements View.OnClickListener {

    private Activity activity;
    private RecyclerView rv_msg;
    private EditText et_msg;
    private TextView tv_send;
    private MsgChatAdapter adapter;
    private List<MsgInfo> msgInfos;
    private static final String sendMsgPath = "http://www.tuling123.com/";
    private static final String rebootAPPKey = "2344a09d196542e9874b257b61cefc64";
    private String imei = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        setListener();
    }

    private void initData() {
        activity = this;
        msgInfos = new ArrayList<>();
        adapter = new MsgChatAdapter(activity, msgInfos);
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        imei = telephonyManager.getDeviceId();

    }

    private void initView() {

        rv_msg = (RecyclerView) findViewById(R.id.rv_msg);
        et_msg = (EditText) findViewById(R.id.et_msg);
        tv_send = (TextView) findViewById(R.id.tv_send);

        LinearLayoutManager layoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        rv_msg.setLayoutManager(layoutManager);
        rv_msg.setAdapter(adapter);
    }

    private void setListener() {
        tv_send.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_send:
                //发送消息c
                String str = et_msg.getText().toString().trim();
                if (!TextUtils.isEmpty(str)) {
                    //和机器人聊天
                    MsgInfo in = new MsgInfo();
                    in.setType(2);
                    in.setText(str);
                    msgInfos.add(in);
                    adapter.notifyDataSetChanged();
                    rv_msg.smoothScrollToPosition(msgInfos.size() - 1);
                    et_msg.setText("");
                    sendMsg(str);
                } else {
                    ToastUtil.showMessage(activity, "聊天内容不能为空！");
                }

                break;
            default:
                break;
        }
    }

    private interface SendMsgService {

        @POST("openapi/api")
        Call<MsgInfo> sendMsg(@Query("key") String key, @Query("info") String info, @Query("loc") String loc, @Query("userid") String userid);
    }

    private void sendMsg(String msg) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(sendMsgPath)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SendMsgService service = retrofit.create(SendMsgService.class);
        Log.e("aa", rebootAPPKey + "*" + msg + "*" + imei);
        Call<MsgInfo> call = service.sendMsg(rebootAPPKey, msg, null, imei);

        call.enqueue(new Callback<MsgInfo>() {
            @Override
            public void onResponse(Call<MsgInfo> call, Response<MsgInfo> response) {

                MsgInfo msg = response.body();
                msg.setType(1);

                msgInfos.add(msg);
                adapter.notifyDataSetChanged();
                rv_msg.smoothScrollToPosition(msgInfos.size() - 1);
            }

            @Override
            public void onFailure(Call<MsgInfo> call, Throwable t) {

                ToastUtil.showMessage(activity, "onFailure=" + t.getMessage() + t.hashCode());
            }
        });

    }
}
