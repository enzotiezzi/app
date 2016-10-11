package br.com.zelar.zellarempresas.Custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.zelar.zellarempresas.Empresas.AvaliacaoCandidato;
import br.com.zelar.zellarempresas.Empresas.CandidatoEmpresa;
import br.com.zelar.zellarempresas.Http.HttpClientHelper;
import br.com.zelar.zellarempresas.Http.ICallback;
import br.com.zelar.zellarempresas.Infrastructure.IBasic;
import br.com.zelar.zellarempresas.R;
import br.com.zelar.zellarempresas.Session.SessionManager;
import br.com.zelar.zellarempresas.Utilities.Utils;

/**
 * Created by enzo on 21/09/2016.
 */
public class GestaoVagaQuickActionsView extends LinearLayout implements IBasic
{
    private View v;

    private ImageView imageViewReprovar;
    private ImageView imageViewAprovar;
    private ImageView imageViewFavoritar;

    private List<String> candidatos;
    private List<View> viewCandidatos;

    private String idVaga;
    private String idEtapa;

    private OnReproveListener onReproveListener;


    public GestaoVagaQuickActionsView(Context context)
    {
        super(context);

        initialize();
    }

    public GestaoVagaQuickActionsView(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        initialize();
    }

    public GestaoVagaQuickActionsView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);

        initialize();
    }

    @Override
    public void initialize()
    {
        candidatos = new ArrayList<String>();
        viewCandidatos = new ArrayList<>();

        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        v = layoutInflater.inflate(R.layout.component_gestao_vaga_quickactions, this);

        imageViewReprovar = (ImageView) v.findViewById(R.id.imageViewReprovar);
        imageViewAprovar = (ImageView) v.findViewById(R.id.imageViewAprovar);
        imageViewFavoritar = (ImageView) v.findViewById(R.id.imageViewFavoritar);

        imageViewReprovar.setOnClickListener(imageViewReprovar_click);
        imageViewAprovar.setOnClickListener(imageViewAprovar_click);
        imageViewFavoritar.setOnClickListener(imageViewFavoritar_click);
    }

    public void setOnReproveListener(OnReproveListener onReproveListener)
    {
        this.onReproveListener = onReproveListener;
    }

    public void setIdEtapa(String idEtapa)
    {
        this.idEtapa = idEtapa;
    }

    public void setIdVaga(String idVaga)
    {
        this.idVaga = idVaga;
    }

    public String getIdEtapa()
    {
        return idEtapa;
    }

    public String getIdVaga()
    {
        return idVaga;
    }

    public void adicionarCandidato(View v)
    {
        CandidatoEmpresa candidatoEmpresa = (CandidatoEmpresa) v.getTag(0);
        candidatos.add(candidatoEmpresa.getUniqueId());
        viewCandidatos.add(v);
    }

    public void removerCandidato(View v)
    {
        CandidatoEmpresa candidatoEmpresa = (CandidatoEmpresa) v.getTag(0);
        candidatos.remove(candidatoEmpresa.getUniqueId());
        int posicao = removerCandidatoPosicao(candidatoEmpresa.getUniqueId());
        viewCandidatos.remove(posicao);
    }

    private int removerCandidatoPosicao(String id)
    {
        for(int i = 0; i < viewCandidatos.size(); i++)
        {
            CandidatoEmpresa c = (CandidatoEmpresa) viewCandidatos.get(i).getTag(0);

            if (id.equals(c.getUniqueId()))
                return i;
        }

        return -1;
    }

    public void limparLista()
    {
        candidatos = new ArrayList<>();
    }

    OnClickListener imageViewReprovar_click = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            AvaliacaoCandidato avaliacaoCandidato = new AvaliacaoCandidato();
            avaliacaoCandidato.setIdVaga(idVaga);
            avaliacaoCandidato.setIdEtapa(idEtapa);
            avaliacaoCandidato.setCandidatos(candidatos);

            String url = Utils.buildURL(getContext(), "Mobile/ReprovarCandidato");

            HttpClientHelper.sendRequest(getContext(), "post", url, new ICallback()
            {
                @Override
                public void onRequestEnd(int statusCode, Throwable t, String response)
                {
                    if (statusCode == 200 && t == null)
                    {
                        Toast.makeText(getContext(), "Candidatos reprovados com sucesso", Toast.LENGTH_LONG).show();

                        if (onReproveListener != null)
                            onReproveListener.reprovarCandidato(candidatos);

                        limparLista();
                    }
                }
            }, avaliacaoCandidato);
        }
    };

    OnClickListener imageViewAprovar_click = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            AvaliacaoCandidato avaliacaoCandidato = new AvaliacaoCandidato();
            avaliacaoCandidato.setIdVaga(idVaga);
            avaliacaoCandidato.setIdEtapa(idEtapa);
            avaliacaoCandidato.setCandidatos(candidatos);

            String url = Utils.buildURL(getContext(), "Mobile/AprovarCandidatoEtapa");

            HttpClientHelper.sendRequest(getContext(), "post", url, new ICallback()
            {
                @Override
                public void onRequestEnd(int statusCode, Throwable t, String response)
                {
                    if (statusCode == 200 && t == null)
                    {
                        Toast.makeText(getContext(), "Candidatos aprovados com sucesso", Toast.LENGTH_LONG).show();

                        limparLista();
                    }
                }
            }, avaliacaoCandidato);
        }
    };

    OnClickListener imageViewFavoritar_click = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            AvaliacaoCandidato avaliacaoCandidato = new AvaliacaoCandidato();
            avaliacaoCandidato.setLoginUsuario(new SessionManager(getContext()).getPreferences("idUsuario"));
            avaliacaoCandidato.setCandidatos(candidatos);

            String url = Utils.buildURL(getContext(), "Mobile/AdicionarFavoritos");

            HttpClientHelper.sendRequest(getContext(), "post", url, new ICallback()
            {
                @Override
                public void onRequestEnd(int statusCode, Throwable t, String response)
                {
                    if (statusCode == 200 && t == null)
                    {
                        Toast.makeText(getContext(), "Candidatos favoritados com sucesso", Toast.LENGTH_LONG).show();

                        limparLista();
                    }
                }
            }, avaliacaoCandidato);
        }
    };
}
