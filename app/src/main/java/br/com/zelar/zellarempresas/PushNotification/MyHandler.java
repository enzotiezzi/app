package br.com.zelar.zellarempresas.PushNotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import com.microsoft.windowsazure.notifications.NotificationsHandler;

import br.com.zelar.zellarempresas.R;
import br.com.zelar.zellarempresas.Views.MainActivity;

/**
 * Created by Usuário on 28/06/2016.
 */
public class MyHandler extends NotificationsHandler
{
    public static final int NOTIFICATION_ID = 1;
    private NotificationManager mNotificationManager;
    NotificationCompat.Builder builder;
    Context ctx;

    @Override
    public void onReceive(Context context, Bundle bundle) {
        ctx = context;
        String nhMessage = bundle.getString("message");
        String nhTitle = bundle.getString("title");
        sendNotification(nhMessage, nhTitle);
    }

    private void sendNotification(String msg, String title) {

        //TODO: switch com as classes que a mensagem vai
        Intent intent = new Intent(ctx, MainActivity.class);
        intent.putExtra("fromPush", true);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        mNotificationManager = (NotificationManager)
                ctx.getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent contentIntent = PendingIntent.getActivity(ctx, 0,
                intent, PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(ctx)
                        .setAutoCancel(true)
                        .setColor(0x83379c)
                        .setSmallIcon(R.drawable.notification_small_icon)
                        .setContentTitle(title)
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .bigText(msg))
                        .setSound(defaultSoundUri)
                        .setPriority(Notification.PRIORITY_MAX)
                        .setContentText(msg);

        mBuilder.setContentIntent(contentIntent);
        mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
    }
}
