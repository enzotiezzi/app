package br.com.zelar.zellarempresas.Custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.gson.Gson;

import java.util.List;

import br.com.zelar.zellarempresas.Empresas.CandidatoEmpresa;
import br.com.zelar.zellarempresas.Empresas.VagaEtapa;
import br.com.zelar.zellarempresas.Http.HttpClientHelper;
import br.com.zelar.zellarempresas.Http.ICallback;
import br.com.zelar.zellarempresas.Infrastructure.IBasic;
import br.com.zelar.zellarempresas.R;
import br.com.zelar.zellarempresas.Utilities.Utils;

public class ProcessoSeletivoView extends LinearLayout implements IBasic
{
    private View view;
    private LinearLayout linearLayoutProcessoSeletivo;

    private OnLoadEnd onLoadEnd;

    private VagaEtapa[] vagaEtapas;

    private int skipDescartados = 0;
    private int skipNaoDescartados = 0;

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

    public void setOnLoadEnd(OnLoadEnd onLoadEnd)
    {
        this.onLoadEnd = onLoadEnd;
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
            itemEtapaView.getButtonNumeroEtapa().setTag(itemEtapaView);
            itemEtapaView.getButtonNumeroEtapa().setOnClickListener(itemEtapa_click);

            linearLayoutProcessoSeletivo.addView(itemEtapaView, i);
        }
    }

    OnClickListener itemEtapa_click = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            ItemEtapaView itemEtapaView = (ItemEtapaView) v.getTag();

            VagaEtapa vagaEtapa = itemEtapaView.getVagaEtapa();

            carregarCandidatosNaoDescartados(vagaEtapa.getUniqueId(), vagaEtapa.getIdVaga());
        }
    };

    private void carregarCandidatosNaoDescartados(final String idEtapa, final String idVaga)
    {
        String queryString = "?idEtapa=" + idEtapa + "&idVaga=" + idVaga + "&pagina=" + skipNaoDescartados;
        String url = Utils.buildURL(getContext(), "Mobile/ListarCandidatosEtapa" + queryString);

        HttpClientHelper.sendRequest(getContext(), "get", url, new ICallback()
        {
            @Override
            public void onRequestEnd(int statusCode, Throwable t, String response)
            {
               if(statusCode == 200 && t == null)
               {
                   CandidatoEmpresa[] candidatos = new Gson().fromJson(response, CandidatoEmpresa[].class);

                   if(candidatos != null)
                   {
                       onLoadEnd.carregarListaNaoDescartados(candidatos);
                       //skipNaoDescartados += candidatos.length;
                   }

                   carregarCandidatosDescartados(idEtapa, idVaga);
               }
            }
        }, null);
    }

    private void carregarCandidatosDescartados(String idEtapa, String idVaga)
    {
        String queryString = "?idEtapa=" + idEtapa + "&idVaga=" + idVaga + "&pagina=" + skipDescartados;
        String url = Utils.buildURL(getContext(), "Mobile/ListarCandidatosReprovadosEtapa" + queryString);

        HttpClientHelper.sendRequest(getContext(), "get", url, new ICallback()
        {
            @Override
            public void onRequestEnd(int statusCode, Throwable t, String response)
            {
                if(statusCode == 200 && t == null)
                {
                    CandidatoEmpresa[] candidatos = new Gson().fromJson(response, CandidatoEmpresa[].class);

                        if(candidatos != null)
                    {
                        onLoadEnd.carregarListaDescartados(candidatos);
                        //skipNaoDescartados += candidatos.length;
                    }
                }
            }
        }, null);
    }
}
