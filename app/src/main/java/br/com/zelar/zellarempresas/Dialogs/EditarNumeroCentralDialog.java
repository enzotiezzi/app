package br.com.zelar.zellarempresas.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.zelar.zellarempresas.Infrastructure.IBasic;
import br.com.zelar.zellarempresas.R;
import br.com.zelar.zellarempresas.Session.SessionManager;

/**
 * Created by Usuário on 18/07/2016.
 */
public class EditarNumeroCentralDialog extends Dialog implements IBasic
{
    private TextView textViewFechar;
    private EditText editTextTelefoneCentral;
    private Button buttonRegistrarTelefoneCentral;

    public EditarNumeroCentralDialog(Context context)
    {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.editar_telefone_central);

        initialize();
        carregarNumeroPreRegistrado();
    }

    @Override
    public void initialize()
    {
        textViewFechar = (TextView) findViewById(R.id.textViewFechar);
        editTextTelefoneCentral = (EditText) findViewById(R.id.editTextTelefoneCentral);
        buttonRegistrarTelefoneCentral = (Button) findViewById(R.id.buttonGravarTelefoneCentral);

        textViewFechar.setOnClickListener(textViewFechar_click);
        buttonRegistrarTelefoneCentral.setOnClickListener(buttonRegistrarTelefoneCentral_click);
    }

    private void carregarNumeroPreRegistrado()
    {
        String numero = new SessionManager(getContext()).getPreferences("telefoneCentral");

        if(numero != null)
            editTextTelefoneCentral.setText(numero);
    }

    View.OnClickListener buttonRegistrarTelefoneCentral_click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            String numero = editTextTelefoneCentral.getText().toString();

            if(numero != null)
                new SessionManager(getContext()).setPreferences("telefoneCentral", numero);

            dismiss();
        }
    };

    View.OnClickListener textViewFechar_click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            dismiss();
        }
    };
}
