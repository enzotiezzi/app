package br.com.zelar.zellarempresas.Fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import org.w3c.dom.Text;

import Dialogs.FormDadosEssenciaisDialog;
import Dialogs.FormDescricaoVagaDialog;
import Dialogs.FormSalarioBeneficiosDialog;
import br.com.zelar.zellarempresas.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class CriarVagaActivityFragment extends Fragment
{
    // essa view em especifico
    private View thisView;

    private TextView textViewVerEssenciais;
    private TextView textViewDescricaoAtividades;
    private TextView textViewResumoVaga;
    private TextView textViewSalarioBeneficios;

    public CriarVagaActivityFragment()
    {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        thisView = inflater.inflate(R.layout.fragment_criar_vaga, container, false);

        textViewDescricaoAtividades = (TextView) thisView.findViewById(R.id.textViewDescricaoAtividades);
        textViewVerEssenciais = (TextView) thisView.findViewById(R.id.textViewVerEssenciais);
        textViewResumoVaga = (TextView) thisView.findViewById(R.id.textViewResumoVaga);
        textViewSalarioBeneficios = (TextView) thisView.findViewById(R.id.textViewSalarioBeneficios);

        textViewVerEssenciais.setOnClickListener(textViewVerEssenciais_click);
        textViewSalarioBeneficios.setOnClickListener(textViewSalarioBeneficios_click);
        textViewDescricaoAtividades.setOnClickListener(textViewDescricaoAtividades_click);

        return thisView;
    }

    View.OnClickListener textViewVerEssenciais_click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            FormDadosEssenciaisDialog formDadosEssenciaisDialog = new FormDadosEssenciaisDialog(getActivity());
            formDadosEssenciaisDialog.show();
            Window window = formDadosEssenciaisDialog.getWindow();
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    };

    View.OnClickListener textViewSalarioBeneficios_click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            FormSalarioBeneficiosDialog formSalarioBeneficiosDialog = new FormSalarioBeneficiosDialog(getActivity());
            formSalarioBeneficiosDialog.show();
            Window window = formSalarioBeneficiosDialog.getWindow();
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    };

    View.OnClickListener textViewDescricaoAtividades_click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            FormDescricaoVagaDialog formDescricaoVagaDialog = new FormDescricaoVagaDialog(getActivity());
            formDescricaoVagaDialog.show();
            Window window = formDescricaoVagaDialog.getWindow();
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    };
}
