package br.com.zelar.zellarempresas.Custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.com.zelar.zellarempresas.Empresas.GestaoEmpresaTreeViewModel;
import br.com.zelar.zellarempresas.R;
import br.com.zelar.zellarempresas.Utilities.ObjectUtilities;

/**
 * Created by enzo on 13/07/2016.
 */
public class GroupItemView extends LinearLayout
{
    private final String EMPRESA = "Empresa";
    private final String GRUPO = "Grupo";
    private final String LOCAL = "Local";

    private Context context;
    private View v;

    private GestaoEmpresaTreeViewModel gestaoEmpresaTreeViewModel;

    private ImageView imageViewTipo;
    private TextView textViewNumeroGrupo;
    private TextView textViewNomeGrupo;
    private TextView textViewLocais;
    private TextView textViewPessoas;
    private TextView textViewVagas;

    public GroupItemView(Context context)
    {
        super(context);

        this.context = context;

        initialize();
    }

    public GroupItemView(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        this.context = context;

        initialize();
    }

    public void setGestaoEmpresaTreeViewModel(GestaoEmpresaTreeViewModel gestaoEmpresaTreeViewModel)
    {
        this.gestaoEmpresaTreeViewModel = gestaoEmpresaTreeViewModel;

        setup();
    }

    private void initialize()
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        v = inflater.inflate(R.layout.gestao_empresa_item, this);

        imageViewTipo = (ImageView) v.findViewById(R.id.imageViewTipo);
        textViewNumeroGrupo = (TextView) v.findViewById(R.id.textViewNumeroGrupo);
        textViewNomeGrupo = (TextView) v.findViewById(R.id.textViewNomeGrupo);
        textViewLocais = (TextView) v.findViewById(R.id.textViewLocais);
        textViewPessoas = (TextView) v.findViewById(R.id.textViewPessoas);
        textViewVagas = (TextView) v.findViewById(R.id.textViewVagas);
    }

    private void setup()
    {
        setupIconType();

        textViewNomeGrupo.setText(ObjectUtilities.getValue(gestaoEmpresaTreeViewModel.getNome()));
        textViewLocais.setText(ObjectUtilities.getValue(gestaoEmpresaTreeViewModel.getQtdeLocal()) );
        textViewPessoas.setText(ObjectUtilities.getValue(gestaoEmpresaTreeViewModel.getQtdePessoas()));
        textViewVagas.setText(ObjectUtilities.getValue(gestaoEmpresaTreeViewModel.getQtdeVagas()));
    }

    private void setupIconType()
    {
        switch (gestaoEmpresaTreeViewModel.getTipo())
        {
            case LOCAL:
                imageViewTipo.setImageResource(R.drawable.localizacao_top);
                break;
            case GRUPO:
                imageViewTipo.setVisibility(GONE);
                textViewNumeroGrupo.setVisibility(VISIBLE);
                textViewNumeroGrupo.setText("G" + ObjectUtilities.getValue(gestaoEmpresaTreeViewModel.getNumero()));
                break;
        }
    }
}
