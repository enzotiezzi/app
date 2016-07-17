package br.com.zelar.zellarempresas.Validators;

import android.content.Context;

/**
 * Created by enzo on 17/07/2016.
 */
public class Validator
{
    private Context mContext;

    public Validator(Context context)
    {
        this.mContext = context;
    }

    public boolean validateRequiredString(String text)
    {
        return text != null ? text.length() != 0 : false;
    }

    public Context getContext()
    {
        return mContext;
    }
}
