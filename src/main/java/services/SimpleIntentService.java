package services;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.text.format.DateFormat;
import android.util.Log;

import com.example.darshan.testapp.BusProvider;

import event.MessageEvent;

public class SimpleIntentService extends IntentService {
    public static final String PARAM_IN_MSG = "imsg";
    public static final String PARAM_OUT_MSG = "omsg";
 
    public SimpleIntentService() {
        super("SimpleIntentService");
    }
 
    @Override
    protected void onHandleIntent(Intent intent) {
 
        for (int i = 0 ; i < 50; i++){
            Log.e("Service", "test done");
        }

        BusProvider.instance().post(new MessageEvent("From Service Thread"));
    }
}