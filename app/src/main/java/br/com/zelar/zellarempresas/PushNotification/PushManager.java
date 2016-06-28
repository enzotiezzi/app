package br.com.zelar.zellarempresas.PushNotification;

import android.content.Context;
import android.content.Intent;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.microsoft.windowsazure.notifications.NotificationsManager;

/**
 * Created by Usuário on 28/06/2016.
 */
public class PushManager
{
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;

    private static boolean checkPlayServices(Context context)
    {
        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        int resultCode = apiAvailability.isGooglePlayServicesAvailable(context);
        if (resultCode != ConnectionResult.SUCCESS)
            return false;

        return true;
    }

    private static void registerWithNotificationHubs(Context context)
    {
        if (checkPlayServices(context))
        {
            // Start IntentService to register this application with GCM.
            Intent intent = new Intent(context, RegistrationIntentService.class);
            context.startService(intent);
        }
    }

    public static void initialize(Context context)
    {
        NotificationsManager.handleNotifications(context, NotificationSettings.SenderId, MyHandler.class);
        registerWithNotificationHubs(context);
    }
}
