package br.com.zelar.zellarempresas.PushNotification;

import android.content.Intent;
import android.util.Log;

import com.google.android.gms.iid.InstanceIDListenerService;

/**
 * Created by Usuário on 28/06/2016.
 */
public class MyInstanceIDService extends InstanceIDListenerService
{
    private static final String TAG = "MyInstanceIDService";

    @Override
    public void onTokenRefresh()
    {
        Log.i(TAG, "Refreshing GCM Registration Token");

        Intent intent = new Intent(this, RegistrationIntentService.class);
        startService(intent);
    }
}
