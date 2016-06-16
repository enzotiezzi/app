package Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Infrastructure.IBasic;
import Models.Empresas.Vaga;
import Utilities.ObjectUtilities;
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

    private List<String> beneficios;

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
        carregarCampos();
    }

    private void carregarCampos()
    {

        if(vaga.getUniqueId() != null)
        {
            int positionSalario = ObjectUtilities.getPositionByValue(vaga.getPretensao(), spinnerFaixaSalarial.getAdapter());

            spinnerFaixaSalarial.setSelection(positionSalario);
            radioButtonConfSalarioSim.setChecked(vaga.getSalarioVisivel().toUpperCase() == "SIM");

            List<String> b = Arrays.asList(vaga.getBeneficios().split(","));

            checkBoxValeTransporte.setChecked(b.contains(checkBoxValeTransporte.getText()));
            checkBoxValeAlimentacao.setChecked(b.contains(checkBoxValeAlimentacao.getText()));
            checkBoxCestaBasica.setChecked(b.contains(checkBoxCestaBasica.getText()));
            checkBoxAjudaCusto.setChecked(b.contains(checkBoxAjudaCusto.getText()));
            checkBoxAssistMedica.setChecked(b.contains(checkBoxAssistMedica.getText()));
            checkBoxSeguroVida.setChecked(b.contains(checkBoxSeguroVida.getText()));
            checkBoxAuxEdu.setChecked(b.contains(checkBoxAuxEdu.getText()));
            checkBoxAuxFarmacia.setChecked(b.contains(checkBoxAuxFarmacia.getText()));
            checkBoxAuxCombustivel.setChecked(b.contains(checkBoxAuxCombustivel.getText()));
            checkBoxEstacionamento.setChecked(b.contains(checkBoxEstacionamento.getText()));
            checkBoxBonusResultado.setChecked(b.contains(checkBoxBonusResultado.getText()));
            checkBoxOutros.setChecked(b.contains(checkBoxOutros.getText()));
            checkBoxValeRefeicao.setChecked(b.contains(checkBoxValeRefeicao.getText()));
            checkBoxVALocal.setChecked(b.contains(checkBoxVALocal.getText()));
            checkBoxPLR.setChecked(b.contains(checkBoxPLR.getText()));
            checkBoxComissao.setChecked(b.contains(checkBoxComissao.getText()));
            checkBoxAssistOdonto.setChecked(b.contains(checkBoxAssistOdonto.getText()));
            checkBoxPrevPrivada.setChecked(b.contains(checkBoxPrevPrivada.getText()));
            checkBoxAuxIdioma.setChecked(b.contains(checkBoxAuxIdioma.getText()));
            checkBoxAuxCreche.setChecked(b.contains(checkBoxAuxCreche.getText()));
            checkBoxVeiculoEmpresa.setChecked(b.contains(checkBoxVeiculoEmpresa.getText()));
            checkBoxCelCorp.setChecked(b.contains(checkBoxCelCorp.getText()));
            checkBoxHorarioFlexivel.setChecked(b.contains(checkBoxHorarioFlexivel.getText()));
        }
    }

    public void initialize()
    {
        beneficios = new ArrayList<String>();

        spinnerFaixaSalarial = (Spinner) findViewById(R.id.spinnerFaixaSalarial);
        radioGroupConfidencial = (RadioGroup) findViewById(R.id.radioGroupConfidencial);
        radioButtonConfSalarioSim = (RadioButton) findViewById(R.id.radioButtonConfSalarioSim);

        checkBoxValeTransporte              = (CheckBox) findViewById(R.id.checkBoxValeTransporte);
        checkBoxValeAlimentacao             = (CheckBox) findViewById(R.id.checkBoxValeAlimentacao);
        checkBoxCestaBasica                 = (CheckBox) findViewById(R.id.checkBoxCestaBasica);
        checkBoxAjudaCusto                  = (CheckBox) findViewById(R.id.checkBoxAjudaCusto);
        checkBoxAssistMedica                = (CheckBox) findViewById(R.id.checkBoxAssistMedica);
        checkBoxSeguroVida                  = (CheckBox) findViewById(R.id.checkBoxSeguroVida);
        checkBoxAuxEdu                      = (CheckBox) findViewById(R.id.checkBoxAuxEdu);
        checkBoxAuxFarmacia                 = (CheckBox) findViewById(R.id.checkBoxAuxFarmacia);
        checkBoxAuxCombustivel              = (CheckBox) findViewById(R.id.checkBoxAuxCombustivel);
        checkBoxEstacionamento              = (CheckBox) findViewById(R.id.checkBoxEstacionamento);
        checkBoxBonusResultado              = (CheckBox) findViewById(R.id.checkBoxBonusResultado);
        checkBoxOutros                      = (CheckBox) findViewById(R.id.checkBoxOutros);
        checkBoxValeRefeicao                = (CheckBox) findViewById(R.id.checkBoxValeRefeicao);
        checkBoxVALocal                     = (CheckBox) findViewById(R.id.checkBoxVALocal);
        checkBoxPLR                         = (CheckBox) findViewById(R.id.checkBoxPLR);
        checkBoxComissao                    = (CheckBox) findViewById(R.id.checkBoxComissao);
        checkBoxAssistOdonto                = (CheckBox) findViewById(R.id.checkBoxAssistOdonto);
        checkBoxPrevPrivada                 = (CheckBox) findViewById(R.id.checkBoxPrevPrivada);
        checkBoxAuxIdioma                   = (CheckBox) findViewById(R.id.checkBoxAuxIdioma);
        checkBoxAuxCreche                   = (CheckBox) findViewById(R.id.checkBoxAuxCreche);
        checkBoxVeiculoEmpresa              = (CheckBox) findViewById(R.id.checkBoxVeiculoEmpresa);
        checkBoxCelCorp                     = (CheckBox) findViewById(R.id.checkBoxCelCorp);
        checkBoxHorarioFlexivel             = (CheckBox) findViewById(R.id.checkBoxHorarioFlexivel);

        buttonFechar = (Button) findViewById(R.id.buttonFecharSalario);
        buttonGravar = (Button) findViewById(R.id.buttonGravarSalario);

        buttonFechar.setOnClickListener(buttonFechar_click);
        buttonGravar.setOnClickListener(buttonGravar_click);

        checkBoxValeTransporte.setOnCheckedChangeListener(checkBoxes_change);
        checkBoxValeAlimentacao.setOnCheckedChangeListener(checkBoxes_change);
        checkBoxCestaBasica.setOnCheckedChangeListener(checkBoxes_change);
        checkBoxAjudaCusto.setOnCheckedChangeListener(checkBoxes_change);
        checkBoxAssistMedica.setOnCheckedChangeListener(checkBoxes_change);
        checkBoxSeguroVida.setOnCheckedChangeListener(checkBoxes_change);
        checkBoxAuxEdu.setOnCheckedChangeListener(checkBoxes_change);
        checkBoxAuxFarmacia.setOnCheckedChangeListener(checkBoxes_change);
        checkBoxAuxCombustivel.setOnCheckedChangeListener(checkBoxes_change);
        checkBoxEstacionamento.setOnCheckedChangeListener(checkBoxes_change);
        checkBoxBonusResultado.setOnCheckedChangeListener(checkBoxes_change);
        checkBoxOutros.setOnCheckedChangeListener(checkBoxes_change);
        checkBoxValeRefeicao.setOnCheckedChangeListener(checkBoxes_change);
        checkBoxVALocal.setOnCheckedChangeListener(checkBoxes_change);
        checkBoxPLR.setOnCheckedChangeListener(checkBoxes_change);
        checkBoxComissao.setOnCheckedChangeListener(checkBoxes_change);
        checkBoxAssistOdonto.setOnCheckedChangeListener(checkBoxes_change);
        checkBoxPrevPrivada.setOnCheckedChangeListener(checkBoxes_change);
        checkBoxAuxIdioma.setOnCheckedChangeListener(checkBoxes_change);
        checkBoxAuxCreche.setOnCheckedChangeListener(checkBoxes_change);
        checkBoxVeiculoEmpresa.setOnCheckedChangeListener(checkBoxes_change);
        checkBoxCelCorp.setOnCheckedChangeListener(checkBoxes_change);
        checkBoxHorarioFlexivel.setOnCheckedChangeListener(checkBoxes_change);


        carregarSpinner();
    }

    private void carregarSpinner()
    {
        spinnerFaixaSalarial
                .setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, new String[]
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

    View.OnClickListener buttonGravar_click =
            new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            vaga.setSalarioVisivel(radioButtonConfSalarioSim.isChecked() ? "Sim" : "Não");
            vaga.setPretensao(spinnerFaixaSalarial.getSelectedItem().toString());
            vaga.setBeneficios(Join(beneficios));

            dismiss();
        }
    };

    CompoundButton.OnCheckedChangeListener checkBoxes_change = new CompoundButton.OnCheckedChangeListener()
    {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
        {
            CheckBox checkBox = (CheckBox) buttonView;

            if(isChecked)
                beneficios.add(checkBox.getText().toString());
            else
                beneficios.remove(checkBox.getText().toString());
        }
    };

    private String Join(List<String> lista)
    {
        String full = "";

        for (String a: lista)
            full += a + " ,";

        return full;
    }
}
