package com.example.android_collage_notifications_ass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView center_image;
    NotificationManagerCompat notificationManagerCompat;
    private String CHANNEL_ID="id";
    private String CHANNEL_NAME="myChannel";
    private int NOTIFICATION_ID=11;
    private int NOTIFICATION_REQUEST=22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManagerCompat=NotificationManagerCompat.from(this);
        center_image=findViewById(R.id.center_image);
        center_image.setOnClickListener((view)->{
            Intent notificationIntent=new Intent(getApplicationContext(),SecondActivity.class);
            notificationIntent.putExtra("nid",NOTIFICATION_ID);
            createNotification("Message From Islam","PRESS TO GO TO OUT NEW ACTIVITY",notificationIntent);
        });
    }

    private void createNotification(String title,String contentText,Intent notificationIntent){
        //if version is equal or higher
        if(Build.VERSION.SDK_INT>=Build.VERSION.SDK_INT){
            if(notificationManagerCompat.getNotificationChannel(CHANNEL_ID)==null){
                //create channel
                NotificationChannel myChannel=new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT);
                notificationManagerCompat.createNotificationChannel(myChannel);
            }

            PendingIntent pendingIntent=PendingIntent.getActivity(getBaseContext(),NOTIFICATION_REQUEST,notificationIntent,0);

            NotificationCompat.Builder noBuilder=new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID);

            noBuilder.setContentTitle(title)
            .setContentText(contentText)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setPriority(NotificationManager.IMPORTANCE_DEFAULT)
            .setContentIntent(pendingIntent);

            notificationManagerCompat.notify(NOTIFICATION_ID,noBuilder.build());

        }
    }
}