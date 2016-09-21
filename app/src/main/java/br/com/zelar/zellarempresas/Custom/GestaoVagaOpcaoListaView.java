package br.com.zelar.zellarempresas.Custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.com.zelar.zellarempresas.Infrastructure.IBasic;
import br.com.zelar.zellarempresas.R;

/**
 * Created by enzo on 21/09/2016.
 */
public class GestaoVagaOpcaoListaView extends LinearLayout implements IBasic
{
    private View v;

    private TextView textViewNaoDescartados;
    private TextView textViewDescartados;

    private View viewNaoDescartados;
    private View viewDescartados;

    public GestaoVagaOpcaoListaView(Context context)
    {
        super(context);

        initialize();
    }

    public GestaoVagaOpcaoListaView(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        initialize();
    }

    public GestaoVagaOpcaoListaView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);

        initialize();
    }

    @Override
    public void initialize()
    {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        v = layoutInflater.inflate(R.layout.component_gestao_vaga_opcao_lista_candidatos, this);

        textViewNaoDescartados = (TextView) v.findViewById(R.id.textViewNaoDescartados);
        textViewDescartados = (TextView) v.findViewById(R.id.textViewDescartados);

        viewDescartados = v.findViewById(R.id.viewDescartados);
        viewNaoDescartados = v.findViewById(R.id.viewNaoDescartados);

        textViewNaoDescartados.setOnClickListener(textViewNaoDescartados_click);
        textViewDescartados.setOnClickListener(textViewDescartados_click);
    }

    OnClickListener textViewNaoDescartados_click = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            // TODO: trocar pra lista de não descartados
            toggleUnderline(false);
        }
    };

    OnClickListener textViewDescartados_click = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            // TODO: trocar para lista de descartados
            toggleUnderline(true);
        }
    };

    private void toggleUnderline(boolean descartado)
    {
        if(descartado)
        {
            viewNaoDescartados.setVisibility(GONE);
            viewDescartados.setVisibility(VISIBLE);
        }
        else
        {
            viewNaoDescartados.setVisibility(VISIBLE);
            viewDescartados.setVisibility(GONE);
        }
    }
}
