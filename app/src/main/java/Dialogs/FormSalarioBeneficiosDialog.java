package Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import Infrastructure.IBasic;
import Models.Empresas.Vaga;
import br.com.zelar.zellarempresas.R;

/**
 * Created by enzo on 02/06/2016.
 */
public class FormSalarioBeneficiosDialog extends Dialog implements IBasic
{
    private Context context;
    private Vaga vaga;

    private Spinner spinnerFaixaSalarial;
    private RadioGroup radioGroupConfidencial;
    private RadioButton radioButtonConfSalarioSim;

    private CheckBox checkBoxValeTransporte;
    private CheckBox checkBoxValeAlimentacao;
    private CheckBox checkBoxCestaBasica;
    private CheckBox checkBoxAjudaCusto;
    private CheckBox checkBoxAssistMedica;
    private CheckBox checkBoxSeguroVida;
    private CheckBox checkBoxAuxEdu;
    private CheckBox checkBoxAuxFarmacia;
    private CheckBox checkBoxAuxCombustivel;
    private CheckBox checkBoxEstacionamento;
    private CheckBox checkBoxBonusResultado;
    private CheckBox checkBoxOutros;

    private CheckBox checkBoxValeRefeicao;
    private CheckBox checkBoxVALocal;
    private CheckBox checkBoxPLR;
    private CheckBox checkBoxComissao;
    private CheckBox checkBoxAssistOdonto;
    private CheckBox checkBoxPrevPrivada;
    private CheckBox checkBoxAuxIdioma;
    private CheckBox checkBoxAuxCreche;
    private CheckBox checkBoxVeiculoEmpresa;
    private CheckBox checkBoxCelCorp;
    private CheckBox checkBoxHorarioFlexivel;

    private Button buttonFechar;
    private Button buttonGravar;

    public FormSalarioBeneficiosDialog(Context context)
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
        setContentView(R.layout.form_main_salario_beneficios);

        initialize();
    }

    public void initialize()
    {
        spinnerFaixaSalarial = (Spinner) findViewById(R.id.spinnerFaixaSalarial);
        radioGroupConfidencial = (RadioGroup) findViewById(R.id.radioGroupConfidencial);
        radioButtonConfSalarioSim = (RadioButton) findViewById(R.id.radioButtonConfSalarioSim);

        checkBoxValeTransporte = (CheckBox) findViewById(R.id.checkBoxValeTransporte);
        checkBoxValeAlimentacao = (CheckBox) findViewById(R.id.checkBoxValeAlimentacao);
        checkBoxCestaBasica = (CheckBox) findViewById(R.id.checkBoxCestaBasica);
        checkBoxAjudaCusto = (CheckBox) findViewById(R.id.checkBoxAjudaCusto);
        checkBoxAssistMedica = (CheckBox) findViewById(R.id.checkBoxAssistMedica);
        checkBoxSeguroVida = (CheckBox) findViewById(R.id.checkBoxSeguroVida);
        checkBoxAuxEdu = (CheckBox) findViewById(R.id.checkBoxAuxEdu);
        checkBoxAuxFarmacia = (CheckBox) findViewById(R.id.checkBoxAuxFarmacia);
        checkBoxAuxCombustivel = (CheckBox) findViewById(R.id.checkBoxAuxCombustivel);
        checkBoxEstacionamento = (CheckBox) findViewById(R.id.checkBoxEstacionamento);
        checkBoxBonusResultado = (CheckBox) findViewById(R.id.checkBoxBonusResultado);
        checkBoxOutros = (CheckBox) findViewById(R.id.checkBoxOutros);
        checkBoxValeRefeicao = (CheckBox) findViewById(R.id.checkBoxValeRefeicao);
        checkBoxVALocal = (CheckBox) findViewById(R.id.checkBoxVALocal);
        checkBoxPLR = (CheckBox) findViewById(R.id.checkBoxPLR);
        checkBoxComissao = (CheckBox) findViewById(R.id.checkBoxComissao);
        checkBoxAssistOdonto = (CheckBox) findViewById(R.id.checkBoxAssistOdonto);
        checkBoxPrevPrivada = (CheckBox) findViewById(R.id.checkBoxPrevPrivada);
        checkBoxAuxIdioma = (CheckBox) findViewById(R.id.checkBoxAuxIdioma);
        checkBoxAuxCreche = (CheckBox) findViewById(R.id.checkBoxAuxCreche);
        checkBoxVeiculoEmpresa = (CheckBox) findViewById(R.id.checkBoxVeiculoEmpresa);
        checkBoxCelCorp = (CheckBox) findViewById(R.id.checkBoxCelCorp);
        checkBoxHorarioFlexivel = (CheckBox) findViewById(R.id.checkBoxHorarioFlexivel);

        buttonFechar = (Button) findViewById(R.id.buttonFecharSalario);
        buttonGravar = (Button) findViewById(R.id.buttonGravarSalario);

        buttonFechar.setOnClickListener(buttonFechar_click);
        buttonGravar.setOnClickListener(buttonGravar_click);

        carregarSpinner();
    }

    private void carregarSpinner()
    {
        spinnerFaixaSalarial
                .setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, new String[]
                        {
                                "Salário Mínimo à R$ 1.000,00",
                                "R$ 1.001,00 à R$ 1.500,00",
                                "R$ 1.501,00 à R$ 2.000,00",
                                "R$ 2.001,00 à R$ 2.500,00",
                                "R$ 2.501,00 à R$ 3.000,00",
                                "R$ 3.001,00 à R$ 4.000,00",
                                "R$ 4.001,00 à R$ 5.000,00",
                                "R$ 5.001,00 à R$ 6.000,00",
                                "R$ 6.001,00 à R$ 7.000,00",
                                "R$ 7.001,00 à R$ 8.000,00",
                                "R$ 8.001,00 à R$ 9.000,00",
                                "R$ 9.001,00 à R$ 10.000,00",
                                "Maior que 10.000,00"
                        }));
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
            vaga.setSalarioVisivel(radioButtonConfSalarioSim.isChecked() ? "Sim" : "Não");
            vaga.setPretensao(spinnerFaixaSalarial.getSelectedItem().toString());
            vaga.setValeTransporte(checkBoxValeTransporte.isChecked());
            vaga.setValeRefeicao(checkBoxValeRefeicao.isChecked());
            vaga.setValeAlimentacao(checkBoxValeAlimentacao.isChecked());
            vaga.setValeAlimentacaoLocal(checkBoxVALocal.isChecked());

            dismiss();
        }
    };
}
