package Utilities;

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
}
