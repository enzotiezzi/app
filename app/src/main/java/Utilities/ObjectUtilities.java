package Utilities;

import android.widget.SpinnerAdapter;

import Models.Empresas.Entidade;

/**
 * Created by Usuário on 13/06/2016.
 */
public class ObjectUtilities
{
    public static String getValue(Object object)
    {
        if (object != null)
            return object.toString();

        return "";
    }

    public static int getPositionByValue(String value, SpinnerAdapter spinnerAdapter)
    {
        int position = -1;

        for (int i = 0; i < spinnerAdapter.getCount(); i++)
        {
            String item = spinnerAdapter.getItem(i).toString();

            if(item == value)
            {
                position = i;
                break;
            }
        }

        return position;
    }
}
