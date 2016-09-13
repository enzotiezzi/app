package br.com.zelar.zellarempresas.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import br.com.zelar.zellarempresas.Custom.DivulgacaoView;
import br.com.zelar.zellarempresas.Infrastructure.IBasic;
import br.com.zelar.zellarempresas.R;

/**
 * Created by Usuário on 05/09/2016.
 */
public class DivulgacaoDialog extends Dialog implements IBasic
{
    private DivulgacaoView divulgacaoViewTrabalheConosco;
    private DivulgacaoView divulgacaoViewZellar;

    private TextView textViewFecharDivulgacao;

    public DivulgacaoDialog(Context context)
    {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.form_dados_gestao);

        initialize();
    }

    public DivulgacaoView getDivulgacaoViewTrabalheConosco()
    {
        return divulgacaoViewTrabalheConosco;
    }

    public DivulgacaoView getDivulgacaoViewZellar()
    {
        return divulgacaoViewZellar;
    }

    @Override
    public void initialize()
    {
        textViewFecharDivulgacao = (TextView) findViewById(R.id.textViewFecharDivulgacao);

        divulgacaoViewTrabalheConosco = (DivulgacaoView) findViewById(R.id.divulgarViewTrabalheConosco);
        divulgacaoViewZellar = (DivulgacaoView) findViewById(R.id.divulgarViewZellar);

        textViewFecharDivulgacao.setOnClickListener(textViewFecharDivulgacao_click);
    }

    View.OnClickListener textViewFecharDivulgacao_click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            dismiss();
        }
    };
}
