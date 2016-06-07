package Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import Infrastructure.IBasic;
import Models.Empresas.Vaga;
import br.com.zelar.zellarempresas.R;

/**
 * Created by enzo on 02/06/2016.
 */
public class FormDescricaoVagaDialog extends Dialog implements IBasic
{
    private Context context;
    private Vaga vaga;

    private EditText editTextDescricaoAtividadesVaga;
    private EditText editTextDescricaoPerfilVaga;
    private Spinner spinnerGenero;
    private Spinner spinnerEscolaridade;
    private Spinner spinnerIdadeMinima;
    private Spinner spinnerIdadeMaxima;
    private Spinner spinnerExpMinima;
    private Spinner spinnerIdiomaNecessario;

    private Button buttonFechar;
    private Button buttonGravar;

    public FormDescricaoVagaDialog(Context context)
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
        setContentView(R.layout.form_main_descricao);

        initialize();
    }

    public void initialize()
    {
        editTextDescricaoAtividadesVaga = (EditText) findViewById(R.id.editTextDescricaoAtividadesVaga);
        editTextDescricaoPerfilVaga = (EditText) findViewById(R.id.editTextDescricaoPerfilVaga);
        spinnerGenero = (Spinner) findViewById(R.id.spinnerGenero);
        spinnerEscolaridade = (Spinner) findViewById(R.id.spinnerEscolaridade);
        spinnerIdadeMinima = (Spinner) findViewById(R.id.spinnerIdadeMinima);
        spinnerIdadeMaxima = (Spinner) findViewById(R.id.spinnerIdadeMaxima);
        spinnerExpMinima = (Spinner) findViewById(R.id.spinnerExpMinima);
        spinnerIdiomaNecessario = (Spinner) findViewById(R.id.spinnerIdiomaNecessario);

        buttonFechar = (Button) findViewById(R.id.buttonFecharDescricaoPerfil);
        buttonGravar = (Button) findViewById(R.id.buttonGravarDescricaoPerfil);

        buttonFechar.setOnClickListener(buttonFechar_click);
        buttonGravar.setOnClickListener(buttonGravar_click);

        carregarSpinners();
    }

    public void carregarSpinners()
    {
        spinnerGenero
                .setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, new String[]{ "Masculino", "Feminino" }));
        spinnerEscolaridade
                .setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item,
                        new String[]
                                {
                                        "Analfabeto",
                                        "Sem estudo formal",
                                        "EF1 (1ª a 5ª série) Incompleto", "EF1 (1ª a 5ª série) Completo",
                                        "EF2 (5ª a 8ª série) Incompleto", "EF2 (5ª a 8ª série) Completo",
                                        "EM (Ensino médio) Incompleto", "EM (Ensino médio) Cursando", "EM (Ensino médio) Completo",
                                        "Técnico", "Graduação Incompleto", "Graduação Cursando", "Graduação Completo",
                                        "Pós-Graduação/Especialização", "Mestrado", "Doutorado", "Pós-Doutorado"
                                }));
        spinnerIdadeMinima
                .setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, new String[]{ "Masculino", "Feminino" }));
        spinnerExpMinima
                .setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, new String[]{ "0-3 meses", "4-6 meses", "7-12", "1-2 anos", "2-5 anos", "5+ anos"}));
        spinnerIdiomaNecessario
                .setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, new String[]{ "Inglês", "Espanhol", "Francês", "Italino", "Alemão", "Japonês", "Outros" }));
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
            vaga.setDescricaoDaAtividade(editTextDescricaoAtividadesVaga.getText().toString());
            vaga.setDescricaoDoPerfil(editTextDescricaoPerfilVaga.getText().toString());
            vaga.setGenero(spinnerGenero.getSelectedItem().toString());
            vaga.setEscolaridade(spinnerEscolaridade.getSelectedItem().toString());
            vaga.setTempoExperienciaNaArea(spinnerExpMinima.getSelectedItem().toString());
            vaga.setIdioma(spinnerIdiomaNecessario.getSelectedItem().toString());

            dismiss();
        }
    };
}
