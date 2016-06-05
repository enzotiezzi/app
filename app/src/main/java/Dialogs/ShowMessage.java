package Dialogs;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.View;

/**
 * Created by enzo on 05/06/2016.
 */
public class ShowMessage
{
    public static void showDialog(Context context, String titulo, String mensagem, String textoBotao, View.OnClickListener clickListener)
    {
        new AlertDialog.Builder(context)
                .setTitle(titulo)
                .setMessage(mensagem)
                .setNeutralButton("OK", null)
                .show();
    }
}
