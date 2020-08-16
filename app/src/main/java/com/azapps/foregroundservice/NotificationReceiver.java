package com.azapps.foregroundservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NotificationReceiver extends BroadcastReceiver {
    public static final String MESSAGE_EXTRA_KEY = "message extra key";
//    public static final String MESSAGE_EXTRA_KEY2 = "message extra key 2";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String message="";

        if (action.equals("yes")) message = "yes";
        else if (action.equals("no")) message = "no";

        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
