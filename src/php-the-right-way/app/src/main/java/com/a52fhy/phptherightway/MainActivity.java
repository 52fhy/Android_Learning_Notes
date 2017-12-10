package com.a52fhy.phptherightway;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.webkit.WebView;
import android.view.Window;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        //隐藏标题和最上面的电池电量及信号栏（全屏），可选
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //获取webview实例
        wv = new WebView(this);
        wv.getSettings().setJavaScriptEnabled(true);//支持JavaScript功能，建议开启

        //设置子链接使用webview打开。如果不设置，会调用系统其它浏览器打开
        wv.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //return super.shouldOverrideUrlLoading(view, url);
                view.loadUrl(url);
                return  true;
            }
        });

        //加载链接
//        wv.loadUrl("http://www.52fhy.com/");//链接
        wv.loadUrl("file:///android_asset/www/index.html");//本地html，存放在assets/www目录里

        setContentView(wv);
    }

    //避免按返回键直接退出了
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 如果按下的是后退键，并且webview可以后退，则webview后退
        if (keyCode==KeyEvent.KEYCODE_BACK && wv.canGoBack()) {
            wv.goBack();
            return true;
        }
        //return super.onKeyDown(keyCode, event);
        finish();
        // 退出程序
        return true;
    }
}
