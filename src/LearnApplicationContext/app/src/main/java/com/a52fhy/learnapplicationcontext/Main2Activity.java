package com.a52fhy.learnapplicationcontext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        String name = ((App)getApplicationContext()).getDefaultName();
        ((TextView)findViewById(R.id.tv)).setText(name);

        findViewById(R.id.editText).setOnClickListener(this);
        findViewById(R.id.btnSave).setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.editText:

                break;

            case R.id.btnSave:
                String name = ((EditText)findViewById(R.id.editText)).getText().toString();
                ((App)getApplicationContext()).setDefaultName(name);

                ((TextView)findViewById(R.id.tv)).setText(name);
                break;
        }
    }
}
