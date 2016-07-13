package br.com.zelar.zellarempresas.Fragments;

import android.content.ContentProvider;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import br.com.zelar.zellarempresas.Custom.GroupItemView;
import br.com.zelar.zellarempresas.Empresas.GestaoEmpresaTreeViewModel;
import br.com.zelar.zellarempresas.Http.HttpClientHelper;
import br.com.zelar.zellarempresas.Http.ICallback;
import br.com.zelar.zellarempresas.Infrastructure.IBasic;
import br.com.zelar.zellarempresas.R;
import br.com.zelar.zellarempresas.Session.SessionManager;
import br.com.zelar.zellarempresas.Utilities.Utils;

/**
 * A placeholder fragment containing a simple view.
 */
public class GestaoEmpresaActivityFragment extends Fragment implements IBasic
{
    private Context context;
    private View view;

    private ViewGroup viewGroup;

    public GestaoEmpresaActivityFragment()
    {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_gestao_empresa, container, false);
        context = getContext();

        initialize();
        carregarEmpresas();

        return view;
    }

    @Override
    public void initialize()
    {
        viewGroup = (ViewGroup) view.findViewById(R.id.appendGroupItem);

    }

    private void carregarEmpresas()
    {
        String idUsuario = new SessionManager(context).getPreferences("idUsuario");
        String url = Utils.buildURL(context, "Mobile/BuscarEmpresasUsuario?idUsuario="+idUsuario);
        HttpClientHelper.sendRequest(context, "get", url, new ICallback()
        {
            @Override
            public void onRequestEnd(int statusCode, Throwable t, String response)
            {
                if(statusCode == 200 && t == null)
                {
                    GestaoEmpresaTreeViewModel[] empresas = new Gson().fromJson(response, GestaoEmpresaTreeViewModel[].class);

                    if(empresas.length > 0)
                    {
                        for(int i = 0; i < empresas.length; i++)
                        {
                            GroupItemView groupItemView = new GroupItemView(context);
                            groupItemView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                            groupItemView.setGestaoEmpresaTreeViewModel(empresas[i]);

                            viewGroup.addView(groupItemView, i);
                        }
                    }
                }
            }
        }, null);
    }
}
