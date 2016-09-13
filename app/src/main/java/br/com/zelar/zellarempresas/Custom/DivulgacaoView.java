package br.com.zelar.zellarempresas.Custom;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.com.zelar.zellarempresas.R;

/**
 * Created by Usuário on 13/09/2016.
 */

interface OnSelectedOptionChange
{
    void changeOption(String value);
}

public class DivulgacaoView extends LinearLayout implements OnSelectedOptionChange
{
    private View v;

    private TextView textViewTituloDivulgacao;
    private TextView textViewDivulgar;
    private TextView textViewNaoDivulgar;

    private String selectedText;

    public DivulgacaoView(Context context)
    {
        super(context);
        init();
    }

    public DivulgacaoView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public DivulgacaoView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init()
    {
        selectedText = "não";

        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = layoutInflater.inflate(R.layout.component_divulgacao, this);

        textViewTituloDivulgacao = (TextView) v.findViewById(R.id.textViewTituloDivulgacao);
        textViewDivulgar = (TextView) v.findViewById(R.id.textViewDivulgar);
        textViewNaoDivulgar = (TextView) v.findViewById(R.id.textViewNaoDivulgar);

        textViewDivulgar.setOnClickListener(textViewDivulgar_click);
        textViewNaoDivulgar.setOnClickListener(textViewNaoDivulgar_click);
    }

    public void setTitulo(String titulo)
    {
        textViewTituloDivulgacao.setText(titulo);
    }

    public String getSelected()
    {
        return selectedText;
    }

    OnClickListener textViewDivulgar_click = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            TextView t = (TextView) v;
            changeOption(t.getText().toString());
            changeColors(true);
        }
    };

    OnClickListener textViewNaoDivulgar_click = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            TextView t = (TextView) v;
            changeOption(t.getText().toString());
            changeColors(false);
        }
    };

    private void changeColors(boolean divulgar)
    {
        String colorDisable = "#DCDCDC";

        if (divulgar)
        {
            textViewNaoDivulgar.setBackgroundColor(Color.parseColor(colorDisable));
            textViewDivulgar.setBackgroundColor(getContext().getResources().getColor(R.color.zellarGreen));
        }
        else
        {
            textViewDivulgar.setBackgroundColor(Color.parseColor(colorDisable));
            textViewNaoDivulgar.setBackgroundColor(getContext().getResources().getColor(R.color.zellarRed));
        }
    }

    @Override
    public void changeOption(String value)
    {
        selectedText = value;
    }
}
