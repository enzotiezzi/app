package br.com.zelar.zellarempresas.Custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.com.zelar.zellarempresas.Empresas.VagaEtapa;
import br.com.zelar.zellarempresas.Infrastructure.IBasic;
import br.com.zelar.zellarempresas.R;
import br.com.zelar.zellarempresas.Utilities.Utils;

/**
 * Created by enzo on 20/09/2016.
 */
public class ItemEtapaView extends LinearLayout implements IBasic
{
    private View view;

    private Button buttonNumeroEtapa;

    private VagaEtapa vagaEtapa;

    private int skip = 0;

    public ItemEtapaView(Context context)
    {
        super(context);

        initialize();
    }

    public ItemEtapaView(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        initialize();
    }

    public ItemEtapaView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);

        initialize();
    }

    @Override
    public void initialize()
    {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = layoutInflater.inflate(R.layout.component_item_etapa, this);

        buttonNumeroEtapa = (Button) view.findViewById(R.id.buttonNumeroEtapa);

        buttonNumeroEtapa.setOnClickListener(buttonNumeroEtapa_click);
    }

    public void setNumeroEtapa(String numero)
    {
        buttonNumeroEtapa.setText(numero);
    }

    public void setVagaEtapa(VagaEtapa vagaEtapa)
    {
        this.vagaEtapa = vagaEtapa;
    }

    public VagaEtapa getVagaEtapa()
    {
        return vagaEtapa;
    }

    OnClickListener buttonNumeroEtapa_click = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            String queryString = "?idEtapa=" + vagaEtapa.getUniqueId() + "&idVaga=" + vagaEtapa.getIdVaga() + "&pagina=" + skip;
            String url = Utils.buildURL(getContext(), "");
        }
    };
}
