package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import Models.Empresas.AprovacaoComVaga;
import Models.Empresas.Vaga;
import Utilities.ObjectUtilities;
import br.com.zelar.zellarempresas.R;

/**
 * Created by Usuário on 21/06/2016.
 */
public class VagasPendentesAdapter extends BaseAdapter
{
    private Context context;
    private AprovacaoComVaga[] vagas;
    private LayoutInflater layoutInflater;

    public VagasPendentesAdapter(Context context, AprovacaoComVaga[] vagas)
    {
        this.context = context;
        this.vagas = vagas;

        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount()
    {
        return vagas.length;
    }

    @Override
    public Object getItem(int position)
    {
        return vagas[position];
    }

    @Override
    public long getItemId(int position)
    {
        return -1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        VagaPendentesHelper vagaPendentesHelper = new VagaPendentesHelper();

        if (convertView == null)
        {
            convertView = layoutInflater.inflate(R.layout.item_vaga_pendente, null);

            vagaPendentesHelper.textViewVagaPendenteNome = (TextView) convertView.findViewById(R.id.textViewVagaPendenteNome);

            vagaPendentesHelper.textViewVagaPendenteCargo = (TextView) convertView.findViewById(R.id.textViewVagaPendenteCargo);
            vagaPendentesHelper.textViewVagaPendenteLocal = (TextView) convertView.findViewById(R.id.textViewVagaPendenteLocal);
            vagaPendentesHelper.textViewVagaPendenteEscala = (TextView) convertView.findViewById(R.id.textViewVagaPendenteEscala);
            vagaPendentesHelper.textViewVagaPendenteHorario = (TextView) convertView.findViewById(R.id.textViewVagaPendenteHorario);
            vagaPendentesHelper.textViewVagaPendenteSalario = (TextView) convertView.findViewById(R.id.textViewVagaPendenteSalario);

            convertView.setTag(vagaPendentesHelper);
        }
        else
        {
            vagaPendentesHelper = (VagaPendentesHelper) convertView.getTag();
        }

        Vaga v = vagas[position].getVaga();

        vagaPendentesHelper.textViewVagaPendenteNome.setText(ObjectUtilities.getValue(v.getTitulo()));

        vagaPendentesHelper.textViewVagaPendenteCargo.setText(ObjectUtilities.getValue(v.getFuncao()));
        vagaPendentesHelper.textViewVagaPendenteLocal.setText(ObjectUtilities.getValue(v.getLocalidade()));
        vagaPendentesHelper.textViewVagaPendenteEscala.setText(ObjectUtilities.getValue(v.getEscala()));
        vagaPendentesHelper.textViewVagaPendenteHorario.setText(ObjectUtilities.getValue(v.getHorarioEntradaHoras() + ":" + v.getHorarioEntradaMinutos() +" - " + v.getHorarioSaidaHoras() + ":" + v.getHorarioSaidaMinutos()));
        vagaPendentesHelper.textViewVagaPendenteSalario.setText(ObjectUtilities.getValue(v.getPretensao()));

        return convertView;
    }

    class VagaPendentesHelper
    {
        public TextView textViewVagaPendenteNome;

        public TextView textViewVagaPendenteCargo;
        public TextView textViewVagaPendenteLocal;
        public TextView textViewVagaPendenteEscala;
        public TextView textViewVagaPendenteHorario;

        public TextView textViewVagaPendenteSalario;
    }
}
