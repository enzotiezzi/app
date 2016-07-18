package br.com.zelar.zellarempresas.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.zelar.zellarempresas.Http.HttpClientHelper;
import br.com.zelar.zellarempresas.Http.ICallback;
import br.com.zelar.zellarempresas.Infrastructure.IBasic;
import br.com.zelar.zellarempresas.Empresas.FuncaoEmpresa;
import br.com.zelar.zellarempresas.Empresas.Local;
import br.com.zelar.zellarempresas.Empresas.Vaga;
import br.com.zelar.zellarempresas.Session.SessionManager;
import br.com.zelar.zellarempresas.Utilities.ObjectUtilities;
import br.com.zelar.zellarempresas.Utilities.Utils;
import br.com.zelar.zellarempresas.R;
import br.com.zelar.zellarempresas.Validators.VagaValidator;

/**
 * Created by enzo on 02/06/2016.
 */
public class FormDadosEssenciaisDialog extends Dialog implements IBasic
{
    private Context context;
    private Vaga vaga;

    private Spinner spinnerNomeEmpresa;
    private RadioGroup radioGroupEmpresaConfidencial;
    private AutoCompleteTextView autoCompleteTextViewCargo;
    private Spinner spinnerConfCargo;
    private Spinner spinnerLocalTrabalho;
    private EditText editTextTituloVaga;
    private Spinner spinnerDiasTrabalho;
    private Spinner spinnerEscalaTrabalho;
    private EditText editTextHorarioEntrada;
    private EditText editTextHorarioSaida;
    private RadioButton radioButtonConfSim;

    private Button buttonFechar;
    private Button buttonGravar;

    private boolean saved;
    private boolean loadedLocais;
    private boolean loadedCargos;

    public FormDadosEssenciaisDialog(Context context)
    {
        super(context);

        this.context = context;
        this.saved = false;
        this.loadedLocais = false;
        this.loadedCargos = false;
    }

    public void setVaga(Vaga vaga)
    {
        this.vaga = vaga;
    }

    public void unsave()
    {
        this.saved = false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.form_main_dados_essenciais);

        initialize();
    }

    public void initialize()
    {
        spinnerNomeEmpresa = (Spinner) findViewById(R.id.spinnerFormEmpresa);
        radioGroupEmpresaConfidencial = (RadioGroup) findViewById(R.id.radioGroupConfidencial);
        radioButtonConfSim = (RadioButton) findViewById(R.id.radioButtonConfSim);
        //autoCompleteTextViewCargo = (AutoCompleteTextView) findViewById(R.id.textViewAutoCompleteCargo);
        spinnerConfCargo = (Spinner) findViewById(R.id.spinnerConfCargo);
        spinnerLocalTrabalho = (Spinner) findViewById(R.id.spinnerConfLocal);
        editTextTituloVaga = (EditText) findViewById(R.id.editTextTituloVaga);
        spinnerDiasTrabalho = (Spinner) findViewById(R.id.spinnerDiasTrabalho);
        spinnerEscalaTrabalho = (Spinner) findViewById(R.id.spinnerEscalaTrabalho);
        editTextHorarioEntrada = (EditText) findViewById(R.id.editTextHorarioEntrada);
        editTextHorarioSaida = (EditText) findViewById(R.id.editTextHorarioSaida);

        buttonFechar = (Button) findViewById(R.id.buttonFechar);
        buttonGravar = (Button) findViewById(R.id.buttonGravar);

        buttonFechar.setOnClickListener(buttonFechar_click);
        buttonGravar.setOnClickListener(buttonGravar_click);

        spinnerLocalTrabalho.setOnItemSelectedListener(spinnerLocalTrabalho_itemSelected);

        spinnerNomeEmpresa
                .setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item,
                        new String[]{new SessionManager(context).getPreferences("nomeEmpresa")}));
        spinnerDiasTrabalho
                .setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item,
                        new String[]{ "Todos os dias", "Seg-Sex", "Seg-Sab", "Ter-Dom", "1 vez por semana", "1 vez por quinzena", "1 vez por mês", "Outros" }));
        spinnerEscalaTrabalho
                .setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item,
                        new String[]{ "5x2", "Seg-Sex", "6x2", "6x1", "12x36", "5x1"}));
        spinnerConfCargo.setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item,
                new String[]{ "Carregando..." }));
        spinnerLocalTrabalho.setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item,
                new String[]{ "Carregando..." }));

        carregarLocais();
        carregarCargos();
    }

    private void carregarCampos()
    {
        if(vaga.getUniqueId() != null || saved)
        {
            radioButtonConfSim.setChecked(ObjectUtilities.getValue(vaga.getConfidencial()).toUpperCase() == "SIM");
            editTextTituloVaga.setText(ObjectUtilities.getValue(vaga.getTitulo()));
            editTextHorarioEntrada.setText(ObjectUtilities.getValue(vaga.getHorarioEntradaHoras() + ":" + vaga.getHorarioSaidaHoras()));
            editTextHorarioSaida.setText(ObjectUtilities.getValue(vaga.getHorarioSaidaHoras() + ":" + vaga.getHorarioSaidaMinutos()));

            int positionCargo = ObjectUtilities.getPositionByValue(vaga.getFuncao(), spinnerConfCargo.getAdapter());
            int positionLocalTrabalho = ObjectUtilities.getPositionByValue(vaga.getLocal(), spinnerLocalTrabalho.getAdapter());
            int positionDiaTrabalho = ObjectUtilities.getPositionByValue(vaga.getDiasSemana(), spinnerDiasTrabalho.getAdapter());
            int positionEscalaTrabalho = ObjectUtilities.getPositionByValue(vaga.getEscala(), spinnerEscalaTrabalho.getAdapter());

            spinnerConfCargo.setSelection(positionCargo);
            spinnerLocalTrabalho.setSelection(positionLocalTrabalho);
            spinnerDiasTrabalho.setSelection(positionDiaTrabalho);
            spinnerEscalaTrabalho.setSelection(positionEscalaTrabalho);
        }
    }

    private void carregarLocais()
    {
        String idEmpresa = new SessionManager(context).getPreferences("idEmpresa");
        String url = Utils.buildURL(context, "Mobile/ListarLocaisEmpresa?idEmpresa="+idEmpresa);

        HttpClientHelper.sendRequest(context, "get", url, new ICallback()
        {
            @Override
            public void onRequestEnd(int statusCode, Throwable t, String response)
            {
               if (statusCode == 200 && t == null)
               {
                   Local[] locais = new Gson().fromJson(response, Local[].class);

                   spinnerLocalTrabalho
                           .setAdapter(new ArrayAdapter<Local>(context, android.R.layout.simple_spinner_dropdown_item, locais));

                    loadedLocais = true;
               }

                // carregando spinners

            }
        }, null);
    }

    private void carregarCargos()
    {
        String idEmpresa = new SessionManager(context).getPreferences("idEmpresa");
        String url = Utils.buildURL(context, "Mobile/ListarFuncoesEmpresa?idEmpresa="+idEmpresa);

        HttpClientHelper.sendRequest(context, "get", url, new ICallback()
        {
            @Override
            public void onRequestEnd(int statusCode, Throwable t, String response)
            {
                if (statusCode == 200 && t == null)
                {
                    FuncaoEmpresa[] funcoes = new Gson().fromJson(response, FuncaoEmpresa[].class);

                    spinnerConfCargo
                            .setAdapter(new ArrayAdapter<FuncaoEmpresa>(context, android.R.layout.simple_spinner_dropdown_item, funcoes));

                    loadedCargos = true;
                }

                //
                carregarCampos();
            }
        }, null);
    }

    public boolean validar()
    {
        boolean valid = true;

        if(!loadedLocais)
        {
            valid = false;
            ShowMessage.showDialog(context, "Aviso", "A lista de locais precisa ser carregada antes", "Ok", null);
        }

        if(!loadedCargos)
        {
            valid = false;
            ShowMessage.showDialog(context, "Aviso", "A lista de cargos precisa ser carregada antes", "Ok", null);
        }

        if(editTextHorarioEntrada.length() == 0 || editTextHorarioSaida.length() == 0)
        {
            valid = false;
            ShowMessage.showDialog(context, "Aviso", "O campo horário é obrigatório", "Ok", null);
        }

        String TIME24HOURS_PATTERN = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
        Pattern pattern = Pattern.compile(TIME24HOURS_PATTERN);

        Matcher matcherEntrada = pattern.matcher(editTextHorarioEntrada.getText().toString());
        Matcher matcherSaida = pattern.matcher(editTextHorarioSaida.getText().toString());

        if(editTextHorarioEntrada.length() > 0)
        {
            if(!matcherEntrada.matches())
                ShowMessage.showDialog(context, "Aviso", "O horário de entrada é inválido", "Ok", null);
        }

        if(editTextHorarioSaida.length() > 0)
        {
            if(!matcherSaida.matches())
                ShowMessage.showDialog(context, "Aviso", "O horário de saída é inválido", "Ok", null);
        }

        return valid;
    }

    View.OnClickListener buttonFechar_click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            dismiss();
        }
    };

    View.OnClickListener buttonGravar_click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            if(validar())
            {
                vaga.setConfidencial(radioButtonConfSim.isChecked() ? "Sim" : "Não");
                vaga.setIdLocal(((Local) spinnerLocalTrabalho.getSelectedItem()).getUniqueId());
                vaga.setTitulo(editTextTituloVaga.getText().toString());
                vaga.setDiasSemana(spinnerDiasTrabalho.getSelectedItem().toString());
                vaga.setEscala(spinnerEscalaTrabalho.getSelectedItem().toString());
                vaga.setHorarioEntrada(editTextHorarioEntrada.getText().toString());
                vaga.setHorarioSaida(editTextHorarioSaida.getText().toString());
                vaga.setHorarioEntradaHoras(editTextHorarioEntrada.getText().toString().split(":")[0]);
                vaga.setHorarioEntradaMinutos(editTextHorarioEntrada.getText().toString().split(":")[1]);
                vaga.setHorarioSaidaHoras(editTextHorarioSaida.getText().toString().split(":")[0]);
                vaga.setHorarioSaidaMinutos(editTextHorarioSaida.getText().toString().split(":")[1]);
                vaga.setIdFuncao(((FuncaoEmpresa) spinnerConfCargo.getSelectedItem()).getUniqueId());

                saved = true;
                dismiss();
            }
        }
    };


    AdapterView.OnItemSelectedListener spinnerLocalTrabalho_itemSelected = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
        {
            if(!parent.getAdapter().getItem(position).toString().equals("Carregando..."))
            {
                Local l = (Local)parent.getAdapter().getItem(position);

                editTextTituloVaga.setText(l.getNome()+" - ");
                vaga.setLocalObjeto(l);
                vaga.setIdLocal(l.getUniqueId());
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent)
        {
        }
    };
}
