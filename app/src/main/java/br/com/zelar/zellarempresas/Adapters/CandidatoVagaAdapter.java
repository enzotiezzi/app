package br.com.zelar.zellarempresas.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import br.com.zelar.zellarempresas.Empresas.CandidatoEmpresa;
import br.com.zelar.zellarempresas.R;
import br.com.zelar.zellarempresas.Utilities.ObjectUtilities;

/**
 * Created by Usuário on 26/09/2016.
 */
public class CandidatoVagaAdapter extends BaseAdapter
{
    private Context context;

    private CandidatoEmpresa[] candidatos;

    private OnItemCheckedListener onItemCheckedListener;

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

        CandidatoEmpresa c = candidatos[position];

        String idadeSexoCivilFilhoEnsino = ObjectUtilities.getValue(c.getGenero()) + ", "
                + ObjectUtilities.getValue(c.getEstadoCivil()) + ", "
                + ObjectUtilities.getValue(c.getQtdFilhos())+ " filhos, ";
        String origem = "inscrição feita por " + ObjectUtilities.getValue(c.getOrigem());

        candidatoVagaEtapaHelper.checkBoxChecar.setTag(c.getUniqueId());
        candidatoVagaEtapaHelper.textViewNomeCandidato.setText(ObjectUtilities.getValue(c.getNome()));
        candidatoVagaEtapaHelper.textViewIdadeSexoCivilFilhoEnsino.setText(idadeSexoCivilFilhoEnsino);
        candidatoVagaEtapaHelper.textViewOrigem.setText(origem);

        candidatoVagaEtapaHelper.checkBoxChecar.setOnCheckedChangeListener(onCheckedChangeListener);

        return convertView;
    }

    public void setOnItemCheckedListener(OnItemCheckedListener onItemCheckedListener)
    {
        this.onItemCheckedListener = onItemCheckedListener;
    }

    CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener()
    {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
        {
            String id = (String) buttonView.getTag();

            if (isChecked)
            {
                onItemCheckedListener.onItemCheck(id);
            }
            else
            {
                onItemCheckedListener.onItemDischeck(id);
            }
        }
    };


    class CandidatoVagaEtapaHelper
    {
        CheckBox checkBoxChecar;

        TextView textViewNomeCandidato;
        TextView textViewIdadeSexoCivilFilhoEnsino;
        TextView textViewOrigem;
    }
}
