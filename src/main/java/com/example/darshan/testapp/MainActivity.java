package com.example.darshan.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import bean.CustomerBean;
import event.CustomerEvent;
import event.MessageEvent;

public class MainActivity extends AppCompatActivity {

    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTest = (TextView) findViewById(R.id.tvTest);
        tvTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BusProvider.instance().postSticky(new MessageEvent("From MainActivity"));

                CustomerBean obj = new CustomerBean();
                obj.setStats("Direct Third");

                BusProvider.instance().postSticky(new CustomerEvent(obj));

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }


}
