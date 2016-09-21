package br.com.zelar.zellarempresas.Custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import br.com.zelar.zellarempresas.Empresas.VagaEtapa;
import br.com.zelar.zellarempresas.Infrastructure.IBasic;
import br.com.zelar.zellarempresas.R;

/**
 * Created by enzo on 21/09/2016.
 */
public class ProcessoSeletivoView extends LinearLayout implements IBasic
{
    private View view;
    private LinearLayout linearLayoutProcessoSeletivo;

    private VagaEtapa[] vagaEtapas;

    public ProcessoSeletivoView(Context context)
    {
        super(context);

        initialize();
    }

    public ProcessoSeletivoView(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        initialize();
    }

    public ProcessoSeletivoView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);

        initialize();
    }

    @Override
    public void initialize()
    {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = layoutInflater.inflate(R.layout.component_processo_seletivo, this);

        linearLayoutProcessoSeletivo = (LinearLayout) view.findViewById(R.id.processoSeletivo);
    }

    public void setVagaEtapas(VagaEtapa[] vagaEtapas)
    {
        this.vagaEtapas = vagaEtapas;

        montarProcessoSeletivo();
    }

    private void montarProcessoSeletivo()
    {
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, vagaEtapas.length);
        linearLayoutProcessoSeletivo.setLayoutParams(layoutParams);

        for (int i = 0; i < vagaEtapas.length; i++)
        {
            ItemEtapaView itemEtapaView = new ItemEtapaView(getContext());
            itemEtapaView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
            itemEtapaView.setNumeroEtapa(String.valueOf((i+1)));
            itemEtapaView.setVagaEtapa(vagaEtapas[i]);

            linearLayoutProcessoSeletivo.addView(itemEtapaView, i);
        }
    }
}
