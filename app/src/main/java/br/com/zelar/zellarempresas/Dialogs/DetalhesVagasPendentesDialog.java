package br.com.zelar.zellarempresas.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.zelar.zellarempresas.Http.HttpClientHelper;
import br.com.zelar.zellarempresas.Http.ICallback;
import br.com.zelar.zellarempresas.Infrastructure.IBasic;
import br.com.zelar.zellarempresas.Infrastructure.IDialogActions;
import br.com.zelar.zellarempresas.Empresas.AprovacaoComVaga;
import br.com.zelar.zellarempresas.Empresas.Vaga;
import br.com.zelar.zellarempresas.Utilities.ObjectUtilities;
import br.com.zelar.zellarempresas.Utilities.Utils;
import br.com.zelar.zellarempresas.R;

/**
 * Created by Usuário on 24/06/2016.
 */

public class DetalhesVagasPendentesDialog extends Dialog implements IBasic
{

    private Context context;
    private AprovacaoComVaga aprovacaoComVaga;
    private IDialogActions dialogActions;

    private TextView textViewVagaPendenteDetalhesNomeVaga;
    private ImageView imageVagasPendentesDetalhesFechar;

    private TextView textViewVagasPendentesDetalhesCargo;
    private TextView textViewVagasPendentesDetalhesLocal;
    private TextView textViewVagasPendentesDetalhesEscala;
    private TextView textViewVagasPendentesDetalhesHorario;
    private TextView textViewVagasPendentesDetalhesSalario;

    private ImageView imageViewVagasPendentesReprovar;
    private ImageView imageViewVagasPendentesAprovar;


    public DetalhesVagasPendentesDialog(Context context)
    {
        super(context);

        this.context = context;
    }

    public void setAprovacaoComVaga(AprovacaoComVaga aprovacaoComVaga)
    {
        this.aprovacaoComVaga = aprovacaoComVaga;
    }

    public void setDialogActions(IDialogActions dialogActions)
    {
        this.dialogActions = dialogActions;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.vagas_pendentes_detalhes);

        initialize();
        carregarCampos();
    }

    @Override
    public void initialize()
    {
        textViewVagaPendenteDetalhesNomeVaga = (TextView) findViewById(R.id.textViewVagaPendenteDetalhesNomeVaga);
        imageVagasPendentesDetalhesFechar = (ImageView) findViewById(R.id.imageVagasPendentesDetalhesFechar);

        textViewVagasPendentesDetalhesCargo = (TextView) findViewById(R.id.textViewVagasPendentesDetalhesCargo);
        textViewVagasPendentesDetalhesLocal = (TextView) findViewById(R.id.textViewVagasPendentesDetalhesLocal);
        textViewVagasPendentesDetalhesEscala = (TextView) findViewById(R.id.textViewVagasPendentesDetalhesEscala);
        textViewVagasPendentesDetalhesHorario = (TextView) findViewById(R.id.textViewVagasPendentesDetalhesHorario);
        textViewVagasPendentesDetalhesSalario = (TextView) findViewById(R.id.textViewVagasPendentesDetalhesSalario);

        imageViewVagasPendentesReprovar = (ImageView) findViewById(R.id.imageViewVagasPendentesReprovar);
        imageViewVagasPendentesAprovar = (ImageView) findViewById(R.id.imageViewVagasPendentesAprovar);

        imageVagasPendentesDetalhesFechar.setOnClickListener(imageVagasPendentesDetalhesFechar_click);
        imageViewVagasPendentesReprovar.setOnClickListener(imageViewVagasPendentesReprovar_click);
        imageViewVagasPendentesAprovar.setOnClickListener(imageViewVagasPendentesAprovar_click);
    }

    private void carregarCampos()
    {
        Vaga vaga = aprovacaoComVaga.getVaga();

        textViewVagaPendenteDetalhesNomeVaga.setText(ObjectUtilities.getValue(vaga.getTitulo()));

        textViewVagasPendentesDetalhesCargo.setText(ObjectUtilities.getValue(vaga.getFuncao()));
        textViewVagasPendentesDetalhesLocal.setText(ObjectUtilities.getValue(vaga.getLocalidade()));
        textViewVagasPendentesDetalhesEscala.setText(ObjectUtilities.getValue(vaga.getEscala()));
        textViewVagasPendentesDetalhesHorario.setText(ObjectUtilities.getValue(vaga.getHorarioEntradaHoras()) +":"+vaga.getHorarioEntradaMinutos() + " - " + vaga.getHorarioSaidaHoras()+":"+vaga.getHorarioSaidaMinutos());
        textViewVagasPendentesDetalhesSalario.setText(ObjectUtilities.getValue(vaga.getPretensao()));
    }

    View.OnClickListener imageVagasPendentesDetalhesFechar_click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            dismiss();
        }
    };

    View.OnClickListener imageViewVagasPendentesReprovar_click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            aprovarReprovarVaga(false);
        }
    };

    View.OnClickListener imageViewVagasPendentesAprovar_click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            aprovarReprovarVaga(true);
        }
    };

    private void aprovarReprovarVaga(final boolean aprovar)
    {
        String rota = "";

        if(aprovar)
            rota ="Mobile/AprovarVaga";
        else
            rota = "Mobile/ReprovarVaga";

        String url = Utils.buildURL(context, rota+"?idVaga=" + aprovacaoComVaga.getAprovacao().getUniqueId());

        HttpClientHelper.sendRequest(context, "get", url, new ICallback()
        {
            @Override
            public void onRequestEnd(int statusCode, Throwable t, String response)
            {
                if (statusCode == 200 && t == null)
                {
                    String msg = "";

                    if(aprovar)
                        msg = "Vaga aprovada com sucesso";
                    else
                        msg = "Vaga reprovada com sucesso";

                    ShowMessage.showDialog(context, "Aviso", msg, "Ok", null);

                    if(dialogActions != null)
                        dialogActions.onDialogActionEnd();

                    dismiss();
                }
            }
        }, null);
    }
}
