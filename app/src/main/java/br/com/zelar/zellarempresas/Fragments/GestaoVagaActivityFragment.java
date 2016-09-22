package br.com.zelar.zellarempresas.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import br.com.zelar.zellarempresas.Custom.ExpandableTitleView;
import br.com.zelar.zellarempresas.Custom.ProcessoSeletivoView;
import br.com.zelar.zellarempresas.Empresas.CandidatoEmpresa;
import br.com.zelar.zellarempresas.Empresas.Vaga;
import br.com.zelar.zellarempresas.Empresas.VagaEtapa;
import br.com.zelar.zellarempresas.Http.HttpClientHelper;
import br.com.zelar.zellarempresas.Http.ICallback;
import br.com.zelar.zellarempresas.Infrastructure.IBasic;
import br.com.zelar.zellarempresas.R;
import br.com.zelar.zellarempresas.Session.SessionManager;
import br.com.zelar.zellarempresas.Utilities.Utils;

/**
 * A placeholder fragment containing a simple view.
 */
public class GestaoVagaActivityFragment extends Fragment implements IBasic
{
    private View v;

    private Vaga vaga;

    private ExpandableTitleView expandableTitleView;
    private ProcessoSeletivoView processoSeletivoView;

    private List<CandidatoEmpresa> descartados;
    private List<CandidatoEmpresa> naoDescartados;



    public GestaoVagaActivityFragment()
    {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        v = inflater.inflate(R.layout.fragment_gestao_vaga, container, false);

        carregarVaga();
        initialize();
        carregarProcessoSeletivo();

        return v;
    }

    @Override
    public void initialize()
    {
        descartados = new ArrayList<>();
        naoDescartados = new ArrayList<>();

        expandableTitleView = (ExpandableTitleView) v.findViewById(R.id.expandableTitleViewTitulo);
        processoSeletivoView = (ProcessoSeletivoView) v.findViewById(R.id.processoSeletivoView);

        expandableTitleView.setTitulo(vaga.getTitulo());
    }

    private void carregarVaga()
    {
        Bundle b = getArguments();
        vaga = new Vaga();

        if(b != null)
        {
            String vagaJson = b.getString("Vaga");

            vaga = new Gson().fromJson(vagaJson, Vaga.class);
        }
    }

    private void carregarProcessoSeletivo()
    {
        String idUsuario = new SessionManager(getContext()).getPreferences("idUsuario");
        String queryString = "?idUsuario=" + idUsuario + "&idVaga=" + vaga.getUniqueId();
        String url = Utils.buildURL(getContext(), "Mobile/ListarEtapas" + queryString);

        HttpClientHelper.sendRequest(getContext(), "get", url, new ICallback()
        {
            @Override
            public void onRequestEnd(int statusCode, Throwable t, String response)
            {
                if(statusCode == 200 && t == null)
                {
                    VagaEtapa[] vagaEtapas = new Gson().fromJson(response, VagaEtapa[].class);

                    if (vagaEtapas != null)
                    {
                        processoSeletivoView.setVagaEtapas(vagaEtapas);
                    }
                }
            }
        }, null);
    }
}
