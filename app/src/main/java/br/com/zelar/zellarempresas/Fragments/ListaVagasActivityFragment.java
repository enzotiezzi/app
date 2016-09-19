package br.com.zelar.zellarempresas.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.List;

import br.com.zelar.zellarempresas.Adapters.ItemVagaAdapter;
import br.com.zelar.zellarempresas.Empresas.Vaga;
import br.com.zelar.zellarempresas.GestaoVagaActivityFragment;
import br.com.zelar.zellarempresas.Http.HttpClientHelper;
import br.com.zelar.zellarempresas.Http.ICallback;
import br.com.zelar.zellarempresas.Infrastructure.IBasic;
import br.com.zelar.zellarempresas.R;
import br.com.zelar.zellarempresas.Session.SessionManager;
import br.com.zelar.zellarempresas.Utilities.Utils;

/**
 * A placeholder fragment containing a simple view.
 */
public class ListaVagasActivityFragment extends Fragment implements IBasic
{

    private View v;

    private ListView listViewListaVagas;

    // paginação

    private int skip = 0;

    public ListaVagasActivityFragment()
    {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        v =  inflater.inflate(R.layout.fragment_lista_vagas, container, false);

        initialize();
        carregarVagas();

        return v;
    }

    @Override
    public void initialize()
    {
        listViewListaVagas = (ListView) v.findViewById(R.id.listViewListaVagas);

        listViewListaVagas.setOnItemClickListener(listViewListaVagas_itemClick);
    }

    private void carregarVagas()
    {
        String url = Utils.buildURL(getContext(), "Mobile/ListarVagas");
        String idUsuario = new SessionManager(getContext()).getPreferences("idUsuario");

        VagaRequest vagaRequest = new VagaRequest();
        vagaRequest.idUsuairo = idUsuario;
        vagaRequest.skip = skip;

        HttpClientHelper.sendRequest(getContext(), "post", url, new ICallback()
        {
            @Override
            public void onRequestEnd(int statusCode, Throwable t, String response)
            {
                if(statusCode == 200 && t == null)
                {
                    Vaga[] vagas = new Gson().fromJson(response, Vaga[].class);

                    if(vagas != null && vagas.length > 0)
                    {
                        listViewListaVagas.setAdapter(new ItemVagaAdapter(getContext(), vagas));
                        skip += 50;
                    }
                }
            }
        }, vagaRequest);
    }

    AdapterView.OnItemClickListener listViewListaVagas_itemClick = new AdapterView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            Vaga v = (Vaga) parent.getAdapter().getItem(position);

            Bundle b = new Bundle();
            b.putString("idVaga", v.getUniqueId());

            GestaoVagaActivityFragment gestaoVagaActivityFragment = new GestaoVagaActivityFragment();
            gestaoVagaActivityFragment.setArguments(b);

            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, gestaoVagaActivityFragment)
                    .commit();
        }
    };

    class VagaRequest
    {
        String idUsuairo;
        List<String> clusters;
        String idLocal;
        String status = "Abertagit";
        String dataAberturaDe;
        String dataAberturaAte;
        String dataFechamentoDe;
        String dataFechamentoAte;
        int skip = 0;
        int take = 50;
        String ordenarPor = "na";
        String tipoOrdenacao = "na";
    }
}
