package br.com.zelar.zellarempresas.Fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import br.com.zelar.zellarempresas.Dialogs.DetalhesVagaDialog;
import br.com.zelar.zellarempresas.Dialogs.FormDadosEssenciaisDialog;
import br.com.zelar.zellarempresas.Dialogs.FormDescricaoVagaDialog;
import br.com.zelar.zellarempresas.Dialogs.FormSalarioBeneficiosDialog;
import br.com.zelar.zellarempresas.Dialogs.ShowMessage;
import br.com.zelar.zellarempresas.Http.HttpClientHelper;
import br.com.zelar.zellarempresas.Http.ICallback;
import br.com.zelar.zellarempresas.Infrastructure.IBasic;
import br.com.zelar.zellarempresas.Empresas.Vaga;
import br.com.zelar.zellarempresas.Session.SessionManager;
import br.com.zelar.zellarempresas.Utilities.Utils;
import br.com.zelar.zellarempresas.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class CriarVagaActivityFragment extends Fragment implements IBasic
{
    // essa view em especifico
    private View thisView;
    private Context context;

    private TextView textViewVerEssenciais;
    private TextView textViewDescricaoAtividades;
    private TextView textViewResumoVaga;
    private TextView textViewSalarioBeneficios;

    private Button buttonCancelar;
    private Button buttonPublicar;

    private Vaga vaga;
    private Vaga vagaBundle = null;

    public CriarVagaActivityFragment()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        thisView = inflater.inflate(R.layout.fragment_criar_vaga, container, false);
        context = getContext();

        initialize();
        carregarBundle(getArguments());
        setupVaga();

        return thisView;
    }

    private void carregarBundle(Bundle b)
    {
        if(b != null)
        {
            String json = b.getString("vaga");

            if(json != null)
                vagaBundle = new Gson().fromJson(json, Vaga.class);
        }

    }

    private void setupVaga()
    {
        if(vagaBundle != null)
        {
            vaga = vagaBundle;
        }
        else
        {
            vaga = new Vaga();
            vaga.setIdUsuario(new SessionManager(getActivity()).getPreferences("idUsuario"));
        }
    }

    @Override
    public void initialize()
    {
        textViewDescricaoAtividades = (TextView) thisView.findViewById(R.id.textViewDescricaoAtividades);
        textViewVerEssenciais = (TextView) thisView.findViewById(R.id.textViewVerEssenciais);
        textViewResumoVaga = (TextView) thisView.findViewById(R.id.textViewResumoVaga);
        textViewSalarioBeneficios = (TextView) thisView.findViewById(R.id.textViewSalarioBeneficios);
        buttonCancelar = (Button) thisView.findViewById(R.id.buttonCancelar);
        buttonPublicar = (Button) thisView.findViewById(R.id.buttonPublicar);

        textViewVerEssenciais.setOnClickListener(textViewVerEssenciais_click);
        textViewSalarioBeneficios.setOnClickListener(textViewSalarioBeneficios_click);
        textViewDescricaoAtividades.setOnClickListener(textViewDescricaoAtividades_click);
        textViewResumoVaga.setOnClickListener(textViewResumoVaga_click);

        buttonCancelar.setOnClickListener(buttonCancelar_click);
        buttonPublicar.setOnClickListener(buttonPublicar_click);
    }

    View.OnClickListener textViewVerEssenciais_click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            FormDadosEssenciaisDialog formDadosEssenciaisDialog = new FormDadosEssenciaisDialog(context);
            formDadosEssenciaisDialog.setVaga(vaga);
            formDadosEssenciaisDialog.show();
            Window window = formDadosEssenciaisDialog.getWindow();
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    };

    View.OnClickListener textViewSalarioBeneficios_click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            FormSalarioBeneficiosDialog formSalarioBeneficiosDialog = new FormSalarioBeneficiosDialog(context);
            formSalarioBeneficiosDialog.setVaga(vaga);
            formSalarioBeneficiosDialog.show();
            Window window = formSalarioBeneficiosDialog.getWindow();
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    };

    View.OnClickListener textViewDescricaoAtividades_click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            FormDescricaoVagaDialog formDescricaoVagaDialog = new FormDescricaoVagaDialog(context);
            formDescricaoVagaDialog.setVaga(vaga);
            formDescricaoVagaDialog.show();
            Window window = formDescricaoVagaDialog.getWindow();
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    };

    View.OnClickListener textViewResumoVaga_click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            DetalhesVagaDialog detalhesVagaDialog = new DetalhesVagaDialog(context);
            detalhesVagaDialog.setVaga(vaga);
            detalhesVagaDialog.show();
            Window window = detalhesVagaDialog.getWindow();
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    };

    View.OnClickListener buttonCancelar_click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            ShowMessage.showDialog(getActivity(), "Aviso", "O criação de vaga foi cancelada", "OK", null);
            setupVaga();
        }
    };



    View.OnClickListener buttonPublicar_click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            String url = Utils.buildURL(context, "Mobile/CriarVaga");

            HttpClientHelper.sendRequest(getActivity(), "post", url, new ICallback()
            {
                @Override
                public void onRequestEnd(int statusCode, Throwable t, String response)
                {
                   if (statusCode == 200 && t == null)
                   {
                       ShowMessage.showDialog(getActivity(), "Aviso", "Vaga publicada com sucesso", "OK", null);
                       setupVaga();
                   }
                }
            }, vaga);
        }
    };
}
