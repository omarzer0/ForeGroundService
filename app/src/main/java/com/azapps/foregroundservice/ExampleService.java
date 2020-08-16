package com.azapps.foregroundservice;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import static com.azapps.foregroundservice.App.CHANNEL_ID;

public class ExampleService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String input = intent.getStringExtra("input");

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0, notificationIntent, 0);

        // extra

        Intent broadcastIntent = new Intent(this, NotificationReceiver.class);
        broadcastIntent.setAction("yes");
        PendingIntent actionIntent = PendingIntent.getBroadcast(this, 0,broadcastIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        Intent broadcastIntent2 = new Intent(this, NotificationReceiver.class);
        broadcastIntent2.setAction("no");
        PendingIntent actionIntent222 = PendingIntent.getBroadcast(this, 0,broadcastIntent2,PendingIntent.FLAG_UPDATE_CURRENT);


        // ---------------------------------------


        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Music Service")
                .setContentText(input)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.ic_baseline_play_arrow_24,"play",actionIntent)
                .addAction(R.drawable.ic_baseline_skip_previous_24,"previous",actionIntent222)
                .build();

        startForeground(10 , notification);
//        stopSelf();

        return START_NOT_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
