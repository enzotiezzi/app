package br.com.zelar.zellarempresas.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import br.com.zelar.zellarempresas.R;

/**
 * Created by Usuário on 05/09/2016.
 */
public class DadosGestaoDialog extends Dialog
{
    public DadosGestaoDialog(Context context)
    {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.form_dados_gestao);
    }
}
