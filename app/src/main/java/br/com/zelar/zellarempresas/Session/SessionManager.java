package br.com.zelar.zellarempresas.Session;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by enzo on 31/05/2016.
 */
public class SessionManager
{
    private Context context;

    public SessionManager(Context context)
    {
        this.context = context;
    }

    public void setPreferences(String key, String value)
    {
        SharedPreferences sharedPreferences = this.context.getSharedPreferences("empresas", this.context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String getPreferences(String key)
    {
        SharedPreferences preferences = this.context.getSharedPreferences("empresas", this.context.MODE_PRIVATE);
        String guid = preferences.getString(key, "");

        return guid;
    }
}
