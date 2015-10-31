package com.example.darshan.testapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by Kushan.shah on 10/9/15.
 */
public abstract class BaseActivity extends AppCompatActivity {

    public static final String TAG = "Test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(getContentView());

        initViews();

        loadData();

    }

    protected abstract void loadData();

    protected abstract void initViews();

    protected abstract int getContentView();


}
