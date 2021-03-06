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

import br.com.zelar.zellarempresas.Adapters.VagasPendentesAdapter;
import br.com.zelar.zellarempresas.Dialogs.DetalhesVagasPendentesDialog;
import br.com.zelar.zellarempresas.Http.HttpClientHelper;
import br.com.zelar.zellarempresas.Http.ICallback;
import br.com.zelar.zellarempresas.Infrastructure.IBasic;
import br.com.zelar.zellarempresas.Infrastructure.IDialogActions;
import br.com.zelar.zellarempresas.Empresas.AprovacaoComVaga;
import br.com.zelar.zellarempresas.Session.SessionManager;
import br.com.zelar.zellarempresas.Utilities.Utils;
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
