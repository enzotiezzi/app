package br.com.zelar.zellarempresas.Fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import Adapters.VagasPendentesAdapter;
import Dialogs.DetalhesVagasPendentesDialog;
import Dialogs.ShowMessage;
import Http.HttpClientHelper;
import Http.ICallback;
import Infrastructure.IBasic;
import Infrastructure.IDialogActions;
import Models.Empresas.AprovacaoComVaga;
import Models.Empresas.Vaga;
import Session.SessionManager;
import Utilities.Utils;
import br.com.zelar.zellarempresas.R;
import br.com.zelar.zellarempresas.Views.VagasPendentesActivity;

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

        listViewVagasPendentes.setOnItemClickListener(listViewVagasPendentes_itemClick);
    }

    private void carregarVagasPendentes()
    {
        String idUsuario = new SessionManager(context).getPreferences("idUsuario");
        String url = Utils.buildURL(context, "Mobile/ListatVagasPendentesEmpresa?idUsuario="+idUsuario);

        HttpClientHelper.sendRequest(context, "get", url, new ICallback()
        {
            @Override
            public void onRequestEnd(int statusCode, Throwable t, String response)
            {
                if (statusCode == 200 && t == null)
                {
                    AprovacaoComVaga[] aprovacoes = new Gson().fromJson(response, AprovacaoComVaga[].class);

                    VagasPendentesAdapter vagasPendentesAdapter = new VagasPendentesAdapter(context, aprovacoes);

                    listViewVagasPendentes.setAdapter(vagasPendentesAdapter);

                    // TODO: colocar um textview para quando não haver vagas pendentes
                }
            }
        }, null);
    }


    AdapterView.OnItemClickListener listViewVagasPendentes_itemClick = new AdapterView.OnItemClickListener()
    {
        @Override
        public void onItemClick(final AdapterView<?> parent, View view, final int position, long id)
        {
            AprovacaoComVaga av = (AprovacaoComVaga) parent.getAdapter().getItem(position);

            DetalhesVagasPendentesDialog detalhesVagasPendentesDialog = new DetalhesVagasPendentesDialog(context);
            detalhesVagasPendentesDialog.setAprovacaoComVaga(av);
            detalhesVagasPendentesDialog.setDialogActions(new IDialogActions()
            {
                @Override
                public void onDialogActionEnd()
                {
                    carregarVagasPendentes();
                }
            });
            detalhesVagasPendentesDialog.show();
            Window window = detalhesVagasPendentesDialog.getWindow();
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    };


}
