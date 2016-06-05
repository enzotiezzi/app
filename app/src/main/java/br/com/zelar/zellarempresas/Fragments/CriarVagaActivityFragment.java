package br.com.zelar.zellarempresas.Fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import Dialogs.FormDadosEssenciaisDialog;
import Dialogs.FormDescricaoVagaDialog;
import Dialogs.FormSalarioBeneficiosDialog;
import Dialogs.ShowMessage;
import Http.HttpClientHelper;
import Http.ICallback;
import Infrastructure.IBasic;
import Models.Empresas.Vaga;
import Session.SessionManager;
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

    public CriarVagaActivityFragment()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        thisView = inflater.inflate(R.layout.fragment_criar_vaga, container, false);
        context = getContext();

        initialize();
        setupVaga();

        return thisView;
    }

    private void setupVaga()
    {
        vaga = new Vaga();
        vaga.setIdUsuario(new SessionManager(getActivity()).getPreferences("idEmpresa"));
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

    View.OnClickListener buttonCancelar_click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            ShowMessage.showDialog(getActivity(), "Aviso", "O criação de vaga foi cancelada", "OK", null);
            vaga = null;
        }
    };

    View.OnClickListener buttonPublicar_click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            setupVaga();

            HttpClientHelper.sendRequest(getActivity(), "post", "http://10.0.2.2/Zellar/Mobile/CriarVaga", new ICallback()
            {
                @Override
                public void onRequestEnd(int statusCode, Throwable t, String response)
                {
                   if (statusCode == 200 && t == null)
                   {
                       ShowMessage.showDialog(getActivity(), "Aviso", "Vaga publicada com sucesso", "OK", null);
                       vaga = null;
                   }
                }
            }, vaga);
        }
    };
}
