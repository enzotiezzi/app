package br.com.zelar.zellarempresas.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import br.com.zelar.zellarempresas.Custom.GestaoVagaQuickActionsView;
import br.com.zelar.zellarempresas.Empresas.CandidatoEmpresa;
import br.com.zelar.zellarempresas.Empresas.CandidatoEmpresaCurso;
import br.com.zelar.zellarempresas.Empresas.CandidatoEmpresaExperiencia;
import br.com.zelar.zellarempresas.Http.HttpClientHelper;
import br.com.zelar.zellarempresas.Http.ICallback;
import br.com.zelar.zellarempresas.Infrastructure.IBasic;
import br.com.zelar.zellarempresas.R;
import br.com.zelar.zellarempresas.Session.SessionManager;
import br.com.zelar.zellarempresas.Utilities.ObjectUtilities;
import br.com.zelar.zellarempresas.Utilities.Utils;

public class CurriculoCandidatoActivity extends AppCompatActivity implements IBasic
{
    private CandidatoEmpresa candidatoEmpresa;
    private String idEtapa;
    private String idVaga;

    // header
    private TextView textViewNomeCandidatoCV;
    private TextView textViewTelefoneEmail;

    private GestaoVagaQuickActionsView quickActionsViewCV;

    // objetivos profissionais
    private TextView textViewCargosDesejados;
    private TextView textViewPretSalarial;
    private TextView textViewRestriViagem;
    private TextView textViewRestriDias;
    private TextView textViewRestriPeriodo;

    // experiencias
    private TextView textViewNomeEmpresaCV;
    private TextView textViewSalarioCV;
    private TextView textViewCargoCV;
    private TextView textViewPeriodoCV;

    // formacao
    private TextView textViewInstituicaoCV;
    private TextView textViewCursoCV;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curriculo_candidato);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initialize();
        carregarCandidato();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_curriculo_candidato, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case android.R.id.home:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void initialize()
    {
        textViewNomeCandidatoCV = (TextView) findViewById(R.id.textViewNomeCandidatoCV);
        textViewTelefoneEmail = (TextView) findViewById(R.id.textViewTelefoneEmail);

        quickActionsViewCV = (GestaoVagaQuickActionsView) findViewById(R.id.quickActionsViewCV);

        textViewCargosDesejados = (TextView) findViewById(R.id.textViewCargosDesejados);
        textViewPretSalarial = (TextView) findViewById(R.id.textViewPretSalarial);
        textViewRestriViagem = (TextView) findViewById(R.id.textViewRestriViagem);
        textViewRestriDias = (TextView) findViewById(R.id.textViewRestriDias);
        textViewRestriPeriodo = (TextView) findViewById(R.id.textViewRestriPeriodo);

        textViewNomeEmpresaCV = (TextView) findViewById(R.id.textViewNomeEmpresaCV);
        textViewSalarioCV = (TextView) findViewById(R.id.textViewSalarioCV);
        textViewCargoCV = (TextView) findViewById(R.id.textViewCargoCV);
        textViewPeriodoCV = (TextView) findViewById(R.id.textViewPeriodoCV);

        textViewInstituicaoCV = (TextView) findViewById(R.id.textViewInstituicaoCV);
        textViewCursoCV = (TextView) findViewById(R.id.textViewCursoCV);
    }

    private void carregarCandidato()
    {
        Intent i = getIntent();

        String jsonCandidato = i.getStringExtra("candidato");

        if (jsonCandidato != null)
        {
            candidatoEmpresa = new Gson().fromJson(jsonCandidato, CandidatoEmpresa.class);

            textViewNomeCandidatoCV.setText(ObjectUtilities.getValue(candidatoEmpresa.getNome()));
            String telefoneEmail = ObjectUtilities.getValue(candidatoEmpresa.getTelefonePrincipal())  + ", " + ObjectUtilities.getValue(candidatoEmpresa.getEmail()) ;
            textViewTelefoneEmail.setText(telefoneEmail);
            textViewPretSalarial.setText(ObjectUtilities.getValue(candidatoEmpresa.getPretensao()));
            textViewRestriViagem.setText(ObjectUtilities.getValue(candidatoEmpresa.getRestricaoViajar()));
            textViewRestriDias.setText(ObjectUtilities.getValue(candidatoEmpresa.getRestricaoDiaTrabalho()));
            textViewRestriPeriodo.setText(ObjectUtilities.getValue(candidatoEmpresa.getRestricaoHorarioTrabalho()));

            idEtapa = i.getStringExtra("idEtapa");
            idVaga = i.getStringExtra("idVaga");

            quickActionsViewCV.setIdVaga(idVaga);
            quickActionsViewCV.setIdEtapa(idEtapa);

            quickActionsViewCV.adicionarCandidato(candidatoEmpresa.getUniqueId());

            carregarExperienciaCurso();
        }
    }

    private void carregarExperienciaCurso()
    {
        String queryString = "?idCandidato=" + candidatoEmpresa.getUniqueId();
        String url = Utils.buildURL(this, "Mobile/BuscarFormacaoExperienciaCandidade" + queryString);

        HttpClientHelper.sendRequest(this, "get", url, new ICallback()
        {
            @Override
            public void onRequestEnd(int statusCode, Throwable t, String response)
            {
                if (statusCode == 200 && t == null)
                {
                    ExperienciaFormacaoViewModel experienciaFormacaoViewModel = new Gson().fromJson(response, ExperienciaFormacaoViewModel.class);

                    if (experienciaFormacaoViewModel != null)
                    {
                        // TODO: todas experiencias e cursos
                        if (experienciaFormacaoViewModel.Experiencias != null && experienciaFormacaoViewModel.Experiencias.size() > 0)
                        {
                            CandidatoEmpresaExperiencia candidatoEmpresaExperiencia = experienciaFormacaoViewModel.Experiencias.get(0);

                            textViewNomeEmpresaCV.setText(ObjectUtilities.getValue(candidatoEmpresaExperiencia.getEmpresa()));
                            textViewSalarioCV.setText(ObjectUtilities.getValue(candidatoEmpresaExperiencia.getSalarioInicial()));
                            textViewCargoCV.setText(ObjectUtilities.getValue(candidatoEmpresaExperiencia.getFuncao()));
                            // TODO: FALTA PERIODO
                        }

                        if (experienciaFormacaoViewModel.Cursos != null && experienciaFormacaoViewModel.Cursos.size() > 0)
                        {
                            CandidatoEmpresaCurso candidatoEmpresaCurso = experienciaFormacaoViewModel.Cursos.get(0);

                            textViewInstituicaoCV.setText(ObjectUtilities.getValue(candidatoEmpresaCurso.getNomeDaInstituicao()));
                            textViewCursoCV.setText(ObjectUtilities.getValue(candidatoEmpresaCurso.getNivelDoCurso()));
                        }
                    }
                }
            }
        }, null);
    }

    class ExperienciaFormacaoViewModel
    {
        public List<CandidatoEmpresaExperiencia> Experiencias;
        public List<CandidatoEmpresaCurso> Cursos;
    }
}
