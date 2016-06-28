package br.com.zelar.zellarempresas.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.gson.Gson;

import br.com.zelar.zellarempresas.Http.HttpClientHelper;
import br.com.zelar.zellarempresas.Http.ICallback;
import br.com.zelar.zellarempresas.Infrastructure.IBasic;
import br.com.zelar.zellarempresas.Empresas.Local;
import br.com.zelar.zellarempresas.Empresas.Vaga;
import br.com.zelar.zellarempresas.Session.SessionManager;
import br.com.zelar.zellarempresas.Utilities.Utils;
import br.com.zelar.zellarempresas.Fragments.CriarVagaActivityFragment;
import br.com.zelar.zellarempresas.R;

/**
 * Created by Usuário on 14/06/2016.
 */
public class CopiarVagaDialog extends Dialog implements IBasic
{
    private Context context;
    private FragmentManager fragmentManager;

    private Spinner spinnerCopiarLocal;
    private Spinner spinnerCopiarVaga;
    private Button buttonCopiarSelecionar;

    public CopiarVagaDialog(Context context, FragmentManager fragmentManager)
    {
        super(context);

        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.form_escolher_vaga_dialog);

        initialize();
        carregarLocais();
    }

    @Override
    public void initialize()
    {
        spinnerCopiarLocal = (Spinner) findViewById(R.id.spinnerCopiarLocal);
        spinnerCopiarVaga = (Spinner) findViewById(R.id.spinnerCopiarVaga);
        buttonCopiarSelecionar = (Button) findViewById(R.id.buttonCopiarSelecionar);

        spinnerCopiarLocal.setOnItemSelectedListener(spinnerCopiarLocal_selectedItem);
        buttonCopiarSelecionar.setOnClickListener(buttonCopiarSelecionar_click);
    }

    private void carregarLocais()
    {
        String idEmpresa = new SessionManager(context).getPreferences("idEmpresa");
        String url = Utils.buildURL(context, "Mobile/ListarLocaisEmpresa?idEmpresa="+idEmpresa);

        HttpClientHelper.sendRequest(context, "get", url, new ICallback()
        {
            @Override
            public void onRequestEnd(int statusCode, Throwable t, String response)
            {
                if (statusCode == 200 && t == null)
                {
                    Local[] locais = new Gson().fromJson(response, Local[].class);

                    spinnerCopiarLocal
                            .setAdapter(new ArrayAdapter<Local>(context, android.R.layout.simple_spinner_dropdown_item, locais));
                }
            }
        }, null);
    }

    AdapterView.OnItemSelectedListener spinnerCopiarLocal_selectedItem = new AdapterView.OnItemSelectedListener()
    {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
        {
            Local l = (Local) parent.getSelectedItem();

            String url = Utils.buildURL(context, "Mobile/ListarVagasEmpresa?idLocal="+l.getUniqueId());

            HttpClientHelper.sendRequest(context, "get", url, new ICallback() {
                @Override
                public void onRequestEnd(int statusCode, Throwable t, String response)
                {
                    if(statusCode == 200 && t == null)
                    {
                        Vaga[] vagas = new Gson().fromJson(response, Vaga[].class);

                        spinnerCopiarVaga
                                .setAdapter(new ArrayAdapter<Vaga>(context, android.R.layout.simple_spinner_dropdown_item, vagas));
                    }
                }
            }, null);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent)
        {}
    };

    View.OnClickListener buttonCopiarSelecionar_click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            Vaga vaga = (Vaga) spinnerCopiarVaga.getSelectedItem();
            Local l = (Local) spinnerCopiarLocal.getSelectedItem();

            vaga.setLocalObjeto(l);

            Bundle b = new Bundle();
            b.putString("vaga", new Gson().toJson(vaga));

            Fragment f = new CriarVagaActivityFragment();
            f.setArguments(b);

            fragmentManager
                    .beginTransaction()
                    .replace(R.id.container, f)
                    .commit();

            dismiss();
        }
    };
}
