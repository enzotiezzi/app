package Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import org.w3c.dom.Text;

import Infrastructure.IBasic;
import Models.Empresas.Local;
import Models.Empresas.Vaga;
import Utilities.ObjectUtilities;
import br.com.zelar.zellarempresas.R;

/**
 * Created by Usuário on 08/06/2016.
 */
public class DetalhesVagaDialog extends Dialog implements IBasic
{
    private Context context;
    private Vaga vaga;

    private TextView textViewDetalhesCEP;
    private TextView textViewDetalhesEndereco;
    private TextView textViewDetalhesNumero;
    private TextView textViewDetalhesComplemento;
    private TextView textViewDetalhesBairro;
    private TextView textViewDetalhesCidade;
    private TextView textViewDetalhesPais;

    private TextView textViewDetalhesGenero;
    private TextView textViewDetalhesEscolaridade;
    private TextView textViewDetalhesFaixaIdade;
    private TextView textViewDetalhesExpMinima;

    public void setVaga(Vaga vaga)
    {
        this.vaga = vaga;
    }

    public DetalhesVagaDialog(Context context)
    {
        super(context);

        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.detalhes_vaga);

        initialize();
        carregarDetalhes();
    }


    @Override
    public void initialize()
    {
        textViewDetalhesCEP = (TextView) findViewById(R.id.textViewDetalhesCEP);
        textViewDetalhesEndereco = (TextView) findViewById(R.id.textViewDetalhesEndereco);
        textViewDetalhesNumero = (TextView) findViewById(R.id.textViewDetalhesNumero);
        textViewDetalhesComplemento = (TextView) findViewById(R.id.textViewDetalhesComplemento);
        textViewDetalhesBairro = (TextView) findViewById(R.id.textViewDetalhesBairro);
        textViewDetalhesCidade = (TextView) findViewById(R.id.textViewDetalhesCidadeUF);
        textViewDetalhesPais = (TextView) findViewById(R.id.textViewDetalhesPais);

        textViewDetalhesGenero = (TextView) findViewById(R.id.textViewDetalhesGenero);
        textViewDetalhesEscolaridade = (TextView) findViewById(R.id.textViewDetalhesEscolaridade);
        textViewDetalhesFaixaIdade = (TextView) findViewById(R.id.textViewDetalhesFaixaIdade);
        textViewDetalhesExpMinima = (TextView) findViewById(R.id.textViewDetalhesExpMinima);
    }

    private void carregarDetalhes()
    {
        Local l = vaga.getLocalObjeto();

        textViewDetalhesCEP.setText(ObjectUtilities.getValue(l.getCEP()));
        textViewDetalhesEndereco.setText(ObjectUtilities.getValue(l.getRua()));
        textViewDetalhesNumero.setText(ObjectUtilities.getValue(l.getNumero()));
        textViewDetalhesComplemento.setText(ObjectUtilities.getValue(l.getComplemento()));
        textViewDetalhesBairro.setText(ObjectUtilities.getValue(l.getBairro()));
        textViewDetalhesCidade.setText(ObjectUtilities.getValue(l.getCidade()));
        textViewDetalhesPais.setText(ObjectUtilities.getValue(l.getPais()));

        textViewDetalhesGenero.setText(ObjectUtilities.getValue(vaga.getGenero()));
        textViewDetalhesEscolaridade.setText(ObjectUtilities.getValue(vaga.getEscolaridade()));
        textViewDetalhesFaixaIdade.setText(ObjectUtilities.getValue(vaga.getFaixaEtariaInicio() + " - " + vaga.getFaixaEtariaFim()));
        textViewDetalhesExpMinima.setText(ObjectUtilities.getValue(vaga.getTempoExperienciaNaArea()));
    }
}
