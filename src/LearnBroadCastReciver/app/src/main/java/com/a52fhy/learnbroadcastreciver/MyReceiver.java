package com.a52fhy.learnbroadcastreciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {

    public final static String ACTION = "com.a52fhy.learnbroadcastreciver.intent.action.MyReceiver";

    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        System.out.println("收到的信息是：" + intent.getStringExtra("msg").toString());
        System.err.print("ff");

    }
}
