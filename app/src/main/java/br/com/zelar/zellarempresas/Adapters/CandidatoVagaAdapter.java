package br.com.zelar.zellarempresas.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.zelar.zellarempresas.Empresas.CandidatoEmpresa;
import br.com.zelar.zellarempresas.R;
import br.com.zelar.zellarempresas.Utilities.ObjectUtilities;
import br.com.zelar.zellarempresas.Views.CurriculoCandidatoActivity;

/**
 * Created by Usuário on 26/09/2016.
 */
public class CandidatoVagaAdapter extends BaseAdapter
{
    private Context context;

    private List<CandidatoEmpresa> candidatos;

    private OnItemCheckedListener onItemCheckedListener;

    private String idVaga;
    private String idEtapa;

    public CandidatoVagaAdapter(Context context, CandidatoEmpresa[] candidatos)
    {
        this.candidatos = new ArrayList<>();
        this.context = context;

        this.candidatos.addAll(Arrays.asList(candidatos));
    }

    @Override
    public int getCount()
    {
        return candidatos.size();
    }

    @Override
    public Object getItem(int position)
    {
        return candidatos.get(position);
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
            candidatoVagaEtapaHelper.candidatoDetalhe = convertView.findViewById(R.id.candidatoDetalhe);

            convertView.setTag(candidatoVagaEtapaHelper);
        }
        else
        {
            candidatoVagaEtapaHelper = (CandidatoVagaEtapaHelper) convertView.getTag();
        }

        CandidatoEmpresa c = candidatos.get(position);

        String idadeSexoCivilFilhoEnsino = ObjectUtilities.getValue(c.getGenero()) + ", "
                + ObjectUtilities.getValue(c.getEstadoCivil()) + ", "
                + ObjectUtilities.getValue(c.getQtdFilhos())+ " filhos, ";
        String origem = "inscrição feita por " + ObjectUtilities.getValue(c.getOrigem());

        candidatoVagaEtapaHelper.checkBoxChecar.setTag(c.getUniqueId());
        candidatoVagaEtapaHelper.textViewNomeCandidato.setText(ObjectUtilities.getValue(c.getNome()));
        candidatoVagaEtapaHelper.textViewIdadeSexoCivilFilhoEnsino.setText(idadeSexoCivilFilhoEnsino);
        candidatoVagaEtapaHelper.textViewOrigem.setText(origem);

        candidatoVagaEtapaHelper.candidatoDetalhe.setTag(c);

        candidatoVagaEtapaHelper.checkBoxChecar.setOnCheckedChangeListener(onCheckedChangeListener);
        candidatoVagaEtapaHelper.candidatoDetalhe.setOnClickListener(candidatoDetalhe_click);

        return convertView;
    }

    public void setOnItemCheckedListener(OnItemCheckedListener onItemCheckedListener)
    {
        this.onItemCheckedListener = onItemCheckedListener;
    }

    public void setIdVaga(String idVaga)
    {
        this.idVaga = idVaga;
    }

    public void setIdEtapa(String idEtapa)
    {
        this.idEtapa = idEtapa;
    }

    View.OnClickListener candidatoDetalhe_click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            CandidatoEmpresa candidatoEmpresa = (CandidatoEmpresa) v.getTag();

            Intent i = new Intent(context, CurriculoCandidatoActivity.class);
            i.putExtra("candidato", new Gson().toJson(candidatoEmpresa));
            i.putExtra("idVaga", idVaga);
            i.putExtra("idEtapa", idEtapa);

            context.startActivity(i);
        }
    };

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

    public void addCandidatos(CandidatoEmpresa[] candididatos)
    {
        this.candidatos.addAll(Arrays.asList(candididatos));
        notifyDataSetChanged();
    }

    class CandidatoVagaEtapaHelper
    {
        CheckBox checkBoxChecar;

        TextView textViewNomeCandidato;
        TextView textViewIdadeSexoCivilFilhoEnsino;
        TextView textViewOrigem;

        View candidatoDetalhe;
    }
}
