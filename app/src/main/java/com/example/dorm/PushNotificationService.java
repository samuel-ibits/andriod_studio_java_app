package com.example.dorm;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class PushNotificationService extends FirebaseMessagingService {
    private CharSequence name;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
String title=remoteMessage.getNotification().getTitle();
String text=remoteMessage.getNotification().getBody();
        final String CHANNEL_ID = "DORM_NOTIFICATION";
        NotificationChannel channel= new NotificationChannel(
                CHANNEL_ID,
                "DORM_NOTIFICATION",
                NotificationManager.IMPORTANCE_HIGH
        );
        getSystemService(NotificationManager.class).createNotificationChannel(channel);
        Notification.Builder notification= new Notification.Builder(this,CHANNEL_ID)
        .setContentTitle(title)
                .setContentTitle(text)
                .setSmallIcon(R.drawable.dorm)
                .setAutoCancel(true);
        NotificationManagerCompat.from(this).notify(1,notification.build());
        super.onMessageReceived(remoteMessage);
    }
}
