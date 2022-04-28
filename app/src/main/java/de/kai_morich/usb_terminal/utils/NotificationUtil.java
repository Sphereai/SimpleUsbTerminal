package de.kai_morich.usb_terminal.utils;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import de.kai_morich.usb_terminal.Constants;
import de.kai_morich.usb_terminal.R;

public class NotificationUtil {

    private final NotificationManager notificationManager;
    private NotificationCompat.Builder builder;

    public NotificationUtil(Context context) {
        notificationManager = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                ? context.getSystemService(NotificationManager.class)
                : (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        builder = new NotificationCompat.Builder(context, Constants.Notification.CHANNEL_ID);
        builder.setContentTitle("USB Terminal")
                .setContentText("Please wait...")
                .setSmallIcon(R.drawable.ic_notification)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setProgress(100, 0, false)
                .setAutoCancel(false);

        createNotificationChannel();
    }

    public void setTitleAndContent(String title, String content) {
        builder.setContentTitle(title).setContentText(content);
    }

    public void updateProgress(int percent) {
        builder.setOngoing(true)
                .setContentInfo(percent + "%")
                .setProgress(100, percent, false);

        notificationManager.notify(Constants.Notification.NOTIFICATION_ID, builder.build());
    }

    public void setCompletion(String completionText) {
        builder.setContentText(completionText).setProgress(0, 0, false);
        notificationManager.notify(Constants.Notification.NOTIFICATION_ID, builder.build());
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(Constants.Notification.CHANNEL_ID, Constants.Notification.CHANNEL_NAME, NotificationManager.IMPORTANCE_LOW);
            channel.setDescription(Constants.Notification.CHANNEL_DESCRIPTION);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
