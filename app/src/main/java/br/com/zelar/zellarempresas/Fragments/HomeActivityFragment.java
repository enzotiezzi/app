package br.com.zelar.zellarempresas.Fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.gson.Gson;

import br.com.zelar.zellarempresas.Empresas.RelatorioVaga;
import br.com.zelar.zellarempresas.Http.HttpClientHelper;
import br.com.zelar.zellarempresas.Http.ICallback;
import br.com.zelar.zellarempresas.Infrastructure.IBasic;
import br.com.zelar.zellarempresas.PushNotification.PushManager;
import br.com.zelar.zellarempresas.R;
import br.com.zelar.zellarempresas.Session.SessionManager;
import br.com.zelar.zellarempresas.Utilities.Utils;

/**
 * A placeholder fragment containing a simple view.
 */
public class HomeActivityFragment extends Fragment implements IBasic
{
    private Context context;
    private View view;

    private Spinner spinnerGrupo;

    public HomeActivityFragment()
    {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        context = getContext();
        PushManager.initialize(context);
        view = inflater.inflate(R.layout.fragment_home, container, false);

        initialize();
        carregarGrupos();

        return view;
    }

    @Override
    public void initialize()
    {
        spinnerGrupo = (Spinner) view.findViewById(R.id.spinnerGrupo);
    }

    public void carregarGrupos()
    {
        String idUsuario = new SessionManager(context).getPreferences("idUsuario");

        String url = Utils.buildURL(context, "Mobile/ListarGruposUsuario?idUsuario="+idUsuario);

g        HttpClientHelper.sendRequest(context, "get", url, new ICallback()
        {
            @Override
            public void onRequestEnd(int statusCode, Throwable t, String response)
            {
                if(statusCode == 200 && t == null)
                {
                    String[] grupos = new Gson().fromJson(response, String[].class);

                    if (grupos.length > 0)
                        spinnerGrupo.setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, grupos));
                }
            }
        }, null);
    }

    AdapterView.OnItemSelectedListener spinnerGrupo_selectedItem = new AdapterView.OnItemSelectedListener()
    {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
        {
            String grupo = (String) parent.getAdapter().getItem(position);
            String idUsuario = new SessionManager(context).getPreferences("idUsuario");

            String url = Utils.buildURL(context, "Mobile/BuscarRelatorioVaga?idUsuario="+idUsuario+"&grupo="+grupo);

            HttpClientHelper.sendRequest(context, "get", url, new ICallback()
            {
                @Override
                public void onRequestEnd(int statusCode, Throwable t, String response)
                {
                    if (statusCode == 200 && t == null)
                    {
                        RelatorioVaga[] relatorioVagas = new Gson().fromJson(response, RelatorioVaga[].class);

                        // TODO: Como apresentar essas informações  
                    }
                }
            }, null);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent)
        {}
    };
}
