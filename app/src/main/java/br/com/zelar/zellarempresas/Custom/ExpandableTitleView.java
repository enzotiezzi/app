package br.com.zelar.zellarempresas.Custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.com.zelar.zellarempresas.Infrastructure.IBasic;
import br.com.zelar.zellarempresas.R;

/**
 * Created by enzo on 20/09/2016.
 */
public class ExpandableTitleView extends LinearLayout implements IBasic
{
    private View view;

    private TextView textViewGestaoVagaTitulo;

    public ExpandableTitleView(Context context)
    {
        super(context);

        initialize();
    }

    public ExpandableTitleView(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        initialize();
    }

    public ExpandableTitleView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);

        initialize();
    }

    @Override
    public void initialize()
    {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.component_expandable_title, this);

        textViewGestaoVagaTitulo = (TextView) view.findViewById(R.id.textViewGestaoVagaTitulo);
    }

    public void setTitulo(String titulo)
    {
        textViewGestaoVagaTitulo.setText(titulo);
    }
}
