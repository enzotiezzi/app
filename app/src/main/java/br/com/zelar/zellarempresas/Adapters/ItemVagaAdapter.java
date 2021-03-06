package br.com.zelar.zellarempresas.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.zelar.zellarempresas.Empresas.Vaga;
import br.com.zelar.zellarempresas.R;
import br.com.zelar.zellarempresas.Utilities.ObjectUtilities;

/**
 * Created by Usuário on 15/09/2016.
 */
public class ItemVagaAdapter extends BaseAdapter
{
    private Context mContext;
    private List<Vaga> mVagas;

    public ItemVagaAdapter(Context context, Vaga[] vagas)
    {
        mVagas = new ArrayList<>();
        mContext = context;

        mVagas.addAll(Arrays.asList(vagas));
    }

    @Override
    public int getCount()
    {
        return mVagas.size();
    }

    @Override
    public Object getItem(int position)
    {
        return mVagas.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return -1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ItemVagaHelper itemVagaHelper = new ItemVagaHelper();

        if(convertView == null)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.item_lista_vaga, null);

            itemVagaHelper.textViewTituloVaga = (TextView) convertView.findViewById(R.id.textViewTituloVaga);
            itemVagaHelper.textViewCargoEscalaHorario = (TextView) convertView.findViewById(R.id.textViewCargoEscalaHorario);
            itemVagaHelper.textViewEtapasCandidatosStatusTempo = (TextView) convertView.findViewById(R.id.textViewEtapasCandidatosStatusTempo);

            convertView.setTag(itemVagaHelper);
        }
        else
        {
            itemVagaHelper = (ItemVagaHelper) convertView.getTag();
        }

        Vaga vaga = mVagas.get(position);

        String tituloVaga = ObjectUtilities.getValue(vaga.getTitulo()) + ", " + ObjectUtilities.getValue(vaga.getCodigo());
        String horarioEntrada = ObjectUtilities.getValue(vaga.getHorarioEntradaHoras()) + ":" + ObjectUtilities.getValue(vaga.getHorarioEntradaMinutos());
        String horarioSaida = ObjectUtilities.getValue(vaga.getHorarioSaidaHoras()) + ":" + ObjectUtilities.getValue(vaga.getHorarioSaidaMinutos());
        String cargoEscalaHorario = ObjectUtilities.getValue(vaga.getFuncao()) + ", " + ObjectUtilities.getValue(vaga.getEscala()) + ", ";


        String qtdCandidaturas = ObjectUtilities.getValue(vaga.getQtdCandidatura()) + "cand.";

        itemVagaHelper.textViewTituloVaga.setText(tituloVaga);
        itemVagaHelper.textViewCargoEscalaHorario.setText(vaga.getFuncao() + ", " + vaga.getEscala() + ", " + horarioEntrada + " - " + horarioSaida);
        itemVagaHelper.textViewEtapasCandidatosStatusTempo.setText("Cod: "+ vaga.getCodigoEmpresa() + ", " + vaga.getEtapaAtual() + ", " + qtdCandidaturas + ", aberta há " + vaga.getTempoAberta() + " dias");


        return convertView;
    }

    public void addVagas(Vaga[] vagas)
    {
        mVagas.addAll(Arrays.asList(vagas));

        notifyDataSetChanged();
    }

    class ItemVagaHelper
    {
        public TextView textViewTituloVaga;
        public TextView textViewCargoEscalaHorario;
        public TextView textViewEtapasCandidatosStatusTempo;
    }
}
