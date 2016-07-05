package br.com.zelar.zellarempresas.Fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.gson.Gson;

import java.util.List;

import br.com.zelar.zellarempresas.Custom.ExpandableItem;
import br.com.zelar.zellarempresas.Custom.ExpandableLayout;
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

    private ExpandableLayout expandableLayout;

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
        carregarRelatorio();

        return view;
    }

    @Override
    public void initialize()
    {
        expandableLayout = (ExpandableLayout) view.findViewById(R.id.expandableView);
    }

    public void carregarRelatorio()
    {
        String grupo = "NA";
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

    private View[] montarViews(RelatorioVaga[] relatorioVagas)
    {
        View[] views = new View[relatorioVagas.length];

        for (int i = 0; i < relatorioVagas.length; i++)
        {
            ExpandableItem e = new ExpandableItem();
            e.setTitle(relatorioVagas[i].getSemana());

        }

        return views;
    }

    private View montarView(RelatorioVaga relatorioVaga)
    {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = layoutInflater.inflate(R.layout.relatorio_vagas_semana, null);

        return v;
    }
}
