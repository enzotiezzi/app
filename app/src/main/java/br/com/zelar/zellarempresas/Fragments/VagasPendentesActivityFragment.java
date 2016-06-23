package br.com.zelar.zellarempresas.Fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;

import Adapters.VagasPendentesAdapter;
import Http.HttpClientHelper;
import Http.ICallback;
import Infrastructure.IBasic;
import Models.Empresas.Vaga;
import Utilities.Utils;
import br.com.zelar.zellarempresas.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class VagasPendentesActivityFragment extends Fragment implements IBasic
{
    private View view;
    private Context context;

    private ListView listViewVagasPendentes;

    public VagasPendentesActivityFragment()
    {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_vagas_pendentes, container, false);

        initialize();
        carregarVagasPendentes();

        return view;
    }

    @Override
    public void initialize()
    {
        context = getContext();

        listViewVagasPendentes = (ListView) view.findViewById(R.id.listViewVagaPendentes);
    }

    private void carregarVagasPendentes()
    {
        String url = Utils.buildURL(context, "Mobile/ListarVagasPendentes");

        HttpClientHelper.sendRequest(context, "get", url, new ICallback()
        {
            @Override
            public void onRequestEnd(int statusCode, Throwable t, String response)
            {
                if (statusCode == 200 && t == null)
                {
                    Vaga[] vagas = new Gson().fromJson(response, Vaga[].class);

                    VagasPendentesAdapter vagasPendentesAdapter = new VagasPendentesAdapter(context, vagas);

                    listViewVagasPendentes.setAdapter(vagasPendentesAdapter);
                }
            }
        }, null);
    }
}
