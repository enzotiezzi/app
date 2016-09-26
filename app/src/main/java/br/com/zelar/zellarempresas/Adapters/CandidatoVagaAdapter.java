package br.com.zelar.zellarempresas.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import br.com.zelar.zellarempresas.Empresas.CandidatoEmpresa;
import br.com.zelar.zellarempresas.R;

/**
 * Created by Usuário on 26/09/2016.
 */
public class CandidatoVagaAdapter extends BaseAdapter
{
    private Context context;

    private CandidatoEmpresa[] candidatos;

    private OnItemCheckListener onItemCheckListener;

    public CandidatoVagaAdapter(Context context, CandidatoEmpresa[] candidatos)
    {
        this.context = context;
        this.candidatos = candidatos;
    }

    @Override
    public int getCount()
    {
        return candidatos.length;
    }

    @Override
    public Object getItem(int position)
    {
        return candidatos[position];
    }

    @Override
    public long getItemId(int position)
    {
        return -1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        CandidatoVagaEtapaHelper candidatoVagaEtapaHelper = new CandidatoVagaEtapaHelper();

        LayoutInflater inflater = LayoutInflater.from(context);

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.item_candidato_gestao_vaga, null);

            candidatoVagaEtapaHelper.checkBoxChecar = (CheckBox) convertView.findViewById(R.id.checkBoxChecar);
            candidatoVagaEtapaHelper.textViewNomeCandidato = (TextView) convertView.findViewById(R.id.textViewNomeCandidato);
            candidatoVagaEtapaHelper.textViewIdadeSexoCivilFilhoEnsino = (TextView) convertView.findViewById(R.id.textViewIdadeSexoCivilFilhoEnsino);
            candidatoVagaEtapaHelper.textViewOrigem = (TextView) convertView.findViewById(R.id.textViewOrigem);

            convertView.setTag(candidatoVagaEtapaHelper);
        }
        else
        {
            candidatoVagaEtapaHelper = (CandidatoVagaEtapaHelper) convertView.getTag();
        }




        return convertView;
    }

    public void setOnItemCheckListener(OnItemCheckListener onItemCheckListener)
    {
        this.onItemCheckListener = onItemCheckListener;
    }



    class CandidatoVagaEtapaHelper
    {
        CheckBox checkBoxChecar;

        TextView textViewNomeCandidato;
        TextView textViewIdadeSexoCivilFilhoEnsino;
        TextView textViewOrigem;
    }
}
