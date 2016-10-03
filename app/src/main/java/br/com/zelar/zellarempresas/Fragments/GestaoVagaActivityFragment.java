package br.com.zelar.zellarempresas.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.zelar.zellarempresas.Adapters.CandidatoVagaAdapter;
import br.com.zelar.zellarempresas.Adapters.OnItemCheckedListener;
import br.com.zelar.zellarempresas.Custom.ExpandableTitleView;
import br.com.zelar.zellarempresas.Custom.GestaoVagaOpcaoListaView;
import br.com.zelar.zellarempresas.Custom.GestaoVagaQuickActionsView;
import br.com.zelar.zellarempresas.Custom.OnListToggleListener;
import br.com.zelar.zellarempresas.Custom.OnLoadEnd;
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
    private GestaoVagaQuickActionsView gestaoVagaQuickActionsView;
    private GestaoVagaOpcaoListaView gestaoVagaOpcaoListaView;
    private ListView listViewCandidatos;

    private List<CandidatoEmpresa> descartados;
    private List<CandidatoEmpresa> naoDescartados;

    private CandidatoVagaAdapter candidatoVagaAdapter;
    private CandidatoVagaAdapter candidatoVagaAdapterNaoDescartados;


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
        gestaoVagaQuickActionsView = (GestaoVagaQuickActionsView) v.findViewById(R.id.gestaoVagaQuickActionsView);
        gestaoVagaOpcaoListaView = (GestaoVagaOpcaoListaView) v.findViewById(R.id.gestaoVagaOpcaoListaView);
        listViewCandidatos = (ListView) v.findViewById(R.id.listViewCandidatos);

        expandableTitleView.setTitulo(vaga.getTitulo());

        processoSeletivoView.setOnLoadEnd(onLoadEnd);
        gestaoVagaOpcaoListaView.setOnListToggleListener(onListToggleListener);

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

    OnLoadEnd onLoadEnd = new OnLoadEnd()
    {
        @Override
        public void carregarListaDescartados(CandidatoEmpresa[] candidatos)
        {
            descartados = new ArrayList<>();
            descartados.addAll(Arrays.asList(candidatos));

            CandidatoEmpresa[] c = new CandidatoEmpresa[candidatos.length];
            descartados.toArray(c);

            candidatoVagaAdapter = new CandidatoVagaAdapter(getContext(), c);
            candidatoVagaAdapter.setOnItemCheckedListener(onItemCheckListener);
        }

        @Override
        public void carregarListaNaoDescartados(CandidatoEmpresa[] candidatos)
        {
            naoDescartados = new ArrayList<>();
            naoDescartados.addAll(Arrays.asList(candidatos));

            CandidatoEmpresa[] c = new CandidatoEmpresa[candidatos.length];
            naoDescartados.toArray(c);

            gestaoVagaOpcaoListaView.setQuantidadeNaoDescartados(String.valueOf(naoDescartados  .size()));

            candidatoVagaAdapterNaoDescartados = new CandidatoVagaAdapter(getContext(), c);
            candidatoVagaAdapterNaoDescartados.setOnItemCheckedListener(onItemCheckListener);
            listViewCandidatos.setAdapter(candidatoVagaAdapterNaoDescartados);
        }
    };

    OnItemCheckedListener onItemCheckListener =  new OnItemCheckedListener()
    {
        @Override
        public void onItemCheck(String id)
        {
            gestaoVagaQuickActionsView.adicionarCandidato(id);
        }

        @Override
        public void onItemDischeck(String id)
        {
            gestaoVagaQuickActionsView.removerCandidato(id);
        }
    };

    OnListToggleListener onListToggleListener = new OnListToggleListener()
    {
        @Override
        public void toggleDescartados()
        {
            listViewCandidatos.setAdapter(candidatoVagaAdapter);
            gestaoVagaQuickActionsView.limparLista();
        }

        @Override
        public void toggleNaoDescartados()
        {
            listViewCandidatos.setAdapter(candidatoVagaAdapterNaoDescartados);
            gestaoVagaQuickActionsView.limparLista();
        }
    };
}
