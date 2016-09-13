package br.com.zelar.zellarempresas.Fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import br.com.zelar.zellarempresas.Dialogs.DivulgacaoDialog;
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
import br.com.zelar.zellarempresas.Validators.VagaValidator;

/**
 * A placeholder fragment containing a simple view.
 */
public class CriarVagaActivityFragment extends Fragment implements IBasic
{
    // essa view em especifico
    private View thisView;
    private Context context;

    private FormDadosEssenciaisDialog formDadosEssenciaisDialog;
    private FormSalarioBeneficiosDialog formSalarioBeneficiosDialog;
    private FormDescricaoVagaDialog formDescricaoVagaDialog;

    // porcentagens
    private TextView textViewPorcDadosEssenc;
    private TextView textViewPorcSalarioBeneficios;
    private TextView textViewPorcDescricaoAtividades;

    private TextView textViewVerEssenciais;
    private TextView textViewDescricaoAtividades;
    private TextView textViewResumoVaga;
    private TextView textViewSalarioBeneficios;

    private View viewDadosEssenciais;
    private View viewDescricaoAtividades;
    private View viewResumoVaga;
    private View viewSalarioBeneficios;
    private View viewCanalDivulgacao;

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

        formDadosEssenciaisDialog.unsave();
        formSalarioBeneficiosDialog.unsave();
        formDescricaoVagaDialog.unsave();

        zerarPorcentagens();
    }

    @Override
    public void initialize()
    {

        formDadosEssenciaisDialog = new FormDadosEssenciaisDialog(context);
        formSalarioBeneficiosDialog = new FormSalarioBeneficiosDialog(context);
        formDescricaoVagaDialog = new FormDescricaoVagaDialog(context);

        // porcentagens
        textViewPorcDadosEssenc = (TextView) thisView.findViewById(R.id.textViewPorcDadosEssenc);
        textViewPorcSalarioBeneficios = (TextView) thisView.findViewById(R.id.textViewPorcSalarioBeneficios);
        textViewPorcDescricaoAtividades = (TextView) thisView.findViewById(R.id.textViewPorcDescricaoAtividades);

        viewDadosEssenciais = thisView.findViewById(R.id.dadosEssenciais);
        viewDescricaoAtividades = thisView.findViewById(R.id.descicaoAtividades);
        viewSalarioBeneficios = thisView.findViewById(R.id.salarioBeneficios);
        viewCanalDivulgacao = thisView.findViewById(R.id.canalDivulgacao);
        viewResumoVaga = thisView.findViewById(R.id.resumo);

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

        viewDadosEssenciais.setOnClickListener(textViewVerEssenciais_click);
        viewDescricaoAtividades.setOnClickListener(textViewDescricaoAtividades_click);
        viewSalarioBeneficios.setOnClickListener(textViewSalarioBeneficios_click);
        viewCanalDivulgacao.setOnClickListener(viewCanalDivulgacao_click);
        viewResumoVaga.setOnClickListener(textViewResumoVaga_click);


        buttonCancelar.setOnClickListener(buttonCancelar_click);
        buttonPublicar.setOnClickListener(buttonPublicar_click);
    }

    View.OnClickListener textViewVerEssenciais_click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            formDadosEssenciaisDialog.setVaga(vaga);
            formDadosEssenciaisDialog.show();
            formDadosEssenciaisDialog.setOnDismissListener(new DialogInterface.OnDismissListener()
            {
                @Override
                public void onDismiss(DialogInterface dialog)
                {
                    int p = formDadosEssenciaisDialog.calcularPorcentagem();
                    textViewPorcDadosEssenc.setText(p + "%");
                }
            });
            Window window = formDadosEssenciaisDialog.getWindow();
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    };

    View.OnClickListener textViewSalarioBeneficios_click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            formSalarioBeneficiosDialog.setVaga(vaga);
            formSalarioBeneficiosDialog.show();
            formSalarioBeneficiosDialog.setOnDismissListener(new DialogInterface.OnDismissListener()
            {
                @Override
                public void onDismiss(DialogInterface dialog)
                {
                    int p = formSalarioBeneficiosDialog.calcularPorcentagem();
                    textViewPorcSalarioBeneficios.setText(p + "%");
                }
            });
            Window window = formSalarioBeneficiosDialog.getWindow();
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    };

    View.OnClickListener textViewDescricaoAtividades_click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            formDescricaoVagaDialog.setVaga(vaga);
            formDescricaoVagaDialog.show();
            formDescricaoVagaDialog.setOnDismissListener(new DialogInterface.OnDismissListener()
            {
                @Override
                public void onDismiss(DialogInterface dialog)
                {
                    int p = formDescricaoVagaDialog.calcularPorcentagem();
                    textViewPorcDescricaoAtividades.setText(p + "%");
                }
            });
            Window window = formDescricaoVagaDialog.getWindow();
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    };

    View.OnClickListener viewCanalDivulgacao_click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            DivulgacaoDialog divulgacaoDialog = new DivulgacaoDialog(context);
            divulgacaoDialog.show();
            divulgacaoDialog.getDivulgacaoViewTrabalheConosco().setTitulo("Trabalhe Conosco");
            divulgacaoDialog.getDivulgacaoViewZellar().setTitulo("Zellar RH");
            Window window = divulgacaoDialog.getWindow();
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
            changeFragment();
        }
    };

    private void zerarPorcentagens()
    {
        textViewPorcDescricaoAtividades.setText("0%");
        textViewPorcSalarioBeneficios.setText("0%");
        textViewPorcDadosEssenc.setText("0%");
    }

    private void changeFragment()
    {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new EscolherMetodoCriacaoActivityFragment())
                .commit();
    }

    View.OnClickListener buttonPublicar_click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            if(validar())
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
                            changeFragment();
                        }
                    }
                }, vaga);
            }
        }
    };

    private boolean validar()
    {
        boolean valid = true;

        VagaValidator vagaValidator = new VagaValidator(context);

        // valida horarios

        if(!vagaValidator.validateHourMin(vaga.getHorarioEntrada()))
        {
            valid = false;
            ShowMessage.showDialog(context, "Aviso", "O horário de entrada é inválido", "Ok", null);
        }

        if(!vagaValidator.validateHourMin(vaga.getHorarioSaida()))
        {
            valid = false;
            ShowMessage.showDialog(context, "Aviso", "O horário de saída é inválido", "Ok", null);
        }

        return valid;
    }
}
