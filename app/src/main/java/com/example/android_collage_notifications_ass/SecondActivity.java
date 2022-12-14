package com.example.android_collage_notifications_ass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;

import android.content.Intent;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {
    NotificationManagerCompat notificationManagerCompat;
    int DEFAULT_NOT_ID=-1;
    Intent recevedIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        recevedIntent=getIntent();
        notificationManagerCompat=NotificationManagerCompat.from(this);
        clearNotification(recevedIntent.getIntExtra("nid",DEFAULT_NOT_ID));

    }

    private void clearNotification(int notificationId){
        if(notificationId==DEFAULT_NOT_ID){
            return;
        }
        notificationManagerCompat.cancel(notificationId);
    }
}