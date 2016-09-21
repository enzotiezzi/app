package br.com.zelar.zellarempresas.Custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.zelar.zellarempresas.Infrastructure.IBasic;
import br.com.zelar.zellarempresas.R;

/**
 * Created by enzo on 21/09/2016.
 */
public class GestaoVagaQuickActionsView extends LinearLayout implements IBasic
{
    private View v;

    private ImageView imageViewReprovar;
    private ImageView imageViewAprovar;
    private ImageView imageViewFavoritar;

    private List<String> candidatos;

    public GestaoVagaQuickActionsView(Context context)
    {
        super(context);

        initialize();
    }

    public GestaoVagaQuickActionsView(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        initialize();
    }

    public GestaoVagaQuickActionsView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);

        initialize();
    }

    @Override
    public void initialize()
    {
        candidatos = new ArrayList<String>();

        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        v = layoutInflater.inflate(R.layout.component_gestao_vaga_quickactions, this);

        imageViewReprovar = (ImageView) v.findViewById(R.id.imageViewReprovar);
        imageViewAprovar = (ImageView) v.findViewById(R.id.imageViewAprovar);
        imageViewFavoritar = (ImageView) v.findViewById(R.id.imageViewFavoritar);

        imageViewReprovar.setOnClickListener(imageViewReprovar_click);
        imageViewAprovar.setOnClickListener(imageViewAprovar_click);
        imageViewFavoritar.setOnClickListener(imageViewFavoritar_click);
    }

    public void adicionarCandidato(String guid)
    {
        candidatos.add(guid);
    }

    public void removerCandidato(String guid)
    {
        candidatos.remove(guid);
    }

    private void limparLista()
    {
        candidatos = new ArrayList<>();
    }

    OnClickListener imageViewReprovar_click = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            // TODO: reprovar candidatos
        }
    };

    OnClickListener imageViewAprovar_click = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            // TODO: aprovar candidatos
        }
    };

    OnClickListener imageViewFavoritar_click = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            // TODO: favoritar candidatos
        }
    };
}
