package Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import br.com.zelar.zellarempresas.R;

/**
 * Created by Usuário on 08/06/2016.
 */
public class DetalhesVagaDialog extends Dialog
{
    private Context context;

    public DetalhesVagaDialog(Context context)
    {
        super(context);

        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhes_vaga);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }
}
