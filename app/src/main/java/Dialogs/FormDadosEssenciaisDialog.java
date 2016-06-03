package Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import Models.Empresas.Vaga;
import br.com.zelar.zellarempresas.R;

/**
 * Created by enzo on 02/06/2016.
 */
public class FormDadosEssenciaisDialog extends Dialog
{
    private Context context;
    private Vaga vaga;

    private Spinner spinnerNomeEmpresa;
    private RadioGroup radioGroupEmpresaConfidencial;
    private AutoCompleteTextView autoCompleteTextViewCargo;
    private Spinner spinnerLocalTrabalho;
    private EditText editTextTituloVaga;
    private Spinner spinnerDiasTrabalho;
    private Spinner spinnerEscalaTrabalho;
    private EditText editTextHorarioEntrada;
    private EditText editTextHorarioSaida;

    private Button buttonFechar;
    private Button buttonGravar;


    public FormDadosEssenciaisDialog(Context context)
    {
        super(context);

        this.context = context;
    }

    public void setVaga(Vaga vaga)
    {
        this.vaga = vaga;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.form_main_dados_essenciais);

        spinnerNomeEmpresa = (Spinner) findViewById(R.id.spinnerFormEmpresa);
        radioGroupEmpresaConfidencial = (RadioGroup) findViewById(R.id.radioGroupConfidencial);
        autoCompleteTextViewCargo = (AutoCompleteTextView) findViewById(R.id.textViewAutoCompleteCargo);
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
            
        }
    };
}
