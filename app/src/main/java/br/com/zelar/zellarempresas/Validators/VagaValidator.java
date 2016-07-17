package br.com.zelar.zellarempresas.Validators;

import android.content.Context;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.zelar.zellarempresas.Dialogs.ShowMessage;

/**
 * Created by enzo on 17/07/2016.
 */
public class VagaValidator extends Validator
{
    public VagaValidator(Context context)
    {
        super(context);
    }

    public boolean validateHourMin(String hourMin)
    {
        boolean valid = true;

        if(hourMin == null)
            return false;

        String TIME24HOURS_PATTERN = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
        Pattern pattern = Pattern.compile(TIME24HOURS_PATTERN);

        Matcher matcherEntrada = pattern.matcher(hourMin);

        if(validateRequiredString(hourMin))
        {
            if(!matcherEntrada.matches())
                valid = false;
        }
        else
            valid = false;

        return valid;
    }
}
