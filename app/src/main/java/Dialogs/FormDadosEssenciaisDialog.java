package Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import br.com.zelar.zellarempresas.R;

/**
 * Created by enzo on 02/06/2016.
 */
public class FormDadosEssenciaisDialog extends Dialog
{
    private Context context;

    public FormDadosEssenciaisDialog(Context context)
    {
        super(context);

        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.form_main_dados_essenciais);
    }
}
