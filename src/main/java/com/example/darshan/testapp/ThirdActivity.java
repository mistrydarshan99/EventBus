package com.example.darshan.testapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import event.CustomerEvent;
import event.MessageEvent;

public class ThirdActivity extends AppCompatActivity {

    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        tvTest = (TextView) findViewById(R.id.tvTest);
    }

    @Override
    protected void onResume() {
        BusProvider.instance().registerSticky(this);
        super.onResume();
    }

    public void onEventMainThread(CustomerEvent event) {
        tvTest.setText(event.getObj().getStats());


    }



    @Override
    protected void onStop() {

        BusProvider.instance().unregister(this);

        super.onStop();

        BusProvider.instance().postSticky(new MessageEvent("From Third"));

    }
}
