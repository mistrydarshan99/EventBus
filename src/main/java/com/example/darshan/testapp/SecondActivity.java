package com.example.darshan.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import event.MessageEvent;
import services.SimpleIntentService;

public class SecondActivity extends AppCompatActivity {

    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTest = (TextView) findViewById(R.id.tvTest);

        tvTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

       /* Intent intent = new Intent(this, SimpleIntentService.class);
        startService(intent);*/
    }

    @Override
    protected void onResume() {
        BusProvider.instance().registerSticky(this);
        super.onResume();
    }

    public void onEventMainThread(MessageEvent event) {
        tvTest.setText(event.getStrMsg());

        BusProvider.instance().removeStickyEvent(event);
    }



    @Override
    protected void onStop() {

        BusProvider.instance().unregister(this);

        super.onStop();

    }
}
