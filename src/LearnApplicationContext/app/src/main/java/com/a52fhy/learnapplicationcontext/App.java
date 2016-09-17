package com.a52fhy.learnapplicationcontext;

import android.app.Application;
import android.widget.Toast;

/**
 * Created by YJC on 2016/9/14 014.
 */
public class App extends Application {

    protected String defaultName = "default";

    public String getDefaultName() {
        return defaultName;
    }

    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Toast.makeText(App.this, "Application:onCreate", Toast.LENGTH_SHORT).show();
    }
}
