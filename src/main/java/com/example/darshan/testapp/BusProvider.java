package com.example.darshan.testapp;

import de.greenrobot.event.EventBus;

/**
 * Created by darshan.mistry on 10/30/2015.
 */
public class BusProvider {

    private static final EventBus BUS = EventBus.getDefault();

    public static EventBus instance() {
        return BUS;
    }

    private BusProvider() {

    }
}
