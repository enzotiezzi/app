package br.com.zelar.zellarempresas.Fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.google.gson.Gson;

import br.com.zelar.zellarempresas.Custom.ExpandableItem;
import br.com.zelar.zellarempresas.Custom.ExpandableView;
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

    private ExpandableView expandableView;

    public HomeActivityFragment()
    {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        context = getContext();
        PushManager.initialize(context);

        initialize();
        carregarRelatorio();

        return view;
    }

    @Override
    public void initialize()
    {

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
                    View[] views = montarLista(relatorioVagas);

                    ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.appendPart);

                    for (int i = 0; i < views.length; i++)
                            viewGroup.addView(views[i], i);
                }
            }
        }, null);
    }

    private ExpandableItem[] montarItens(RelatorioVaga[] relatorioVagas)
    {
        ExpandableItem[] views = new ExpandableItem[relatorioVagas.length];

        for (int i = 0; i < relatorioVagas.length; i++)
        {
            ExpandableItem e = new ExpandableItem();

            View contentView = montarView(relatorioVagas[i]);

            e.setTitle(relatorioVagas[i].getSemana());
            e.setV(contentView);

            views[i] = e;
        }

        return views;
    }

    private View[] montarLista(RelatorioVaga[] relatorioVagas)
    {
        View[] views = new View[relatorioVagas.length];

        for (int i = 0; i < relatorioVagas.length; i++)
        {

            View contentView = montarView(relatorioVagas[i]);
            View expandView = montarExpandable(relatorioVagas[i].getSemana(), contentView);

            views[i] = expandView;
        }

        return views;
    }

    private View montarExpandable(String title, final View contentView)
    {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = layoutInflater.inflate(R.layout.expandable_view_item, null);
        final ViewGroup viewGroup = (ViewGroup) v.findViewById(R.id.appendPoint);

        TextView textViewTitle = (TextView) v.findViewById(R.id.textViewTitle);

        textViewTitle.setText(title);

        // adiciona relatorio_vagas
        textViewTitle.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                toggle_contents(viewGroup);
            }
        });

        viewGroup.addView(contentView, 0);

        return v;
    }

    private View montarView(RelatorioVaga relatorioVaga)
    {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = layoutInflater.inflate(R.layout.relatorio_vagas_semana, null);

        TextView textViewRelatorioAbertas = (TextView) v.findViewById(R.id.textViewRelatorioAbertas);
        TextView textViewRelatorioFechadas = (TextView) v.findViewById(R.id.textViewRelatorioFechadas);
        TextView textViewRelatorioEmAberto = (TextView) v.findViewById(R.id.textViewRelatorioEmAberto);
        TextView textViewRelatorioTempoMedio = (TextView) v.findViewById(R.id.textViewRelatorioTempoMedio);

        textViewRelatorioAbertas.setText(String.valueOf(relatorioVaga.getQtdeVagasAbertas()));
        textViewRelatorioFechadas.setText(String.valueOf(relatorioVaga.getQtdeVagasFechadas()));
        textViewRelatorioEmAberto.setText(String.valueOf(relatorioVaga.getVagasEmAberto()));
        textViewRelatorioTempoMedio.setText(String.valueOf(relatorioVaga.getTempoMedio()));

        return v;
    }

    private void toggle_contents(View v)
    {
        if(v.isShown())
        {
            slide_up(context, v);
            v.setVisibility(View.GONE);
        }
        else{
            v.setVisibility(View.VISIBLE);
            slide_down(context, v);
        }
    }

    private static void slide_down(Context ctx, View v)
    {
        Animation a = AnimationUtils.loadAnimation(ctx, R.anim.slide_down);
        if(a != null)
        {
            a.reset();
            if(v != null)
            {
                v.clearAnimation();
                v.startAnimation(a);
            }
        }
    }

    private static void slide_up(Context ctx, View v)
    {
        Animation a = AnimationUtils.loadAnimation(ctx, R.anim.slide_down);
        if(a != null)
        {
            a.reset();
            if(v != null)
            {
                v.clearAnimation();
                v.startAnimation(a);
            }
        }
    }
}
