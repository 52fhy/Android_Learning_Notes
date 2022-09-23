package com.a52fhy.learnbroadcastreciver;

import android.content.Intent;
import android.content.IntentFilter;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MyReceiver receiver = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //sendBroadcast(new Intent(MainActivity.this, MyReceiver.class));

        findViewById(R.id.btnSendMsg).setOnClickListener(this);
        findViewById(R.id.btnReg).setOnClickListener(this);
        findViewById(R.id.btnUnreg).setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSendMsg:
                Intent i = new Intent(MyReceiver.ACTION);
                i.putExtra("msg","新消息！");
                sendBroadcast(i);
                break;

            case R.id.btnReg:
                if(receiver == null){
                    receiver = new MyReceiver();
                    registerReceiver(receiver, new IntentFilter(MyReceiver.ACTION));
                }
                break;

            case R.id.btnUnreg:
                if(receiver != null){
                    unregisterReceiver(receiver);
                    receiver = null;
                }
                break;
        }
    }
}
