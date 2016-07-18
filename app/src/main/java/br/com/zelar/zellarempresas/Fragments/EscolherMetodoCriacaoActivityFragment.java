package br.com.zelar.zellarempresas.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import br.com.zelar.zellarempresas.Dialogs.CopiarVagaDialog;
import br.com.zelar.zellarempresas.Dialogs.EditarNumeroCentralDialog;
import br.com.zelar.zellarempresas.R;
import br.com.zelar.zellarempresas.Session.SessionManager;

/**
 * A placeholder fragment containing a simple view.
 */
public class EscolherMetodoCriacaoActivityFragment extends Fragment
{
    private View view;
    private Context context;

    private View buttonCriarNovaVaga;
    private View buttonCopiarVaga;
    private View buttonLigarCentral;

    public EscolherMetodoCriacaoActivityFragment()
    {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view =  inflater.inflate(R.layout.fragment_escolher_metodo_criacao, container, false);
        context = getContext();

        buttonCriarNovaVaga = view.findViewById(R.id.buttonCriarNovaVaga);
        buttonCopiarVaga = view.findViewById(R.id.buttonCopiarVaga);
        buttonLigarCentral = view.findViewById(R.id.buttonLigarCentral);

        buttonCriarNovaVaga.setOnClickListener(buttonCriarNovaVaga_click);
        buttonCopiarVaga.setOnClickListener(buttonCopiarVaga_click);
        buttonLigarCentral.setOnClickListener(buttonLigarCentral_click);

        buttonLigarCentral.setLongClickable(true);
        buttonLigarCentral.setOnLongClickListener(buttonLigarCentral_longClick);

        return view;
    }

    View.OnClickListener buttonCriarNovaVaga_click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, new CriarVagaActivityFragment())
                    .commit();
        }
    };

    View.OnClickListener buttonCopiarVaga_click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            CopiarVagaDialog copiarVagaDialog = new CopiarVagaDialog(context, getFragmentManager());
            copiarVagaDialog.show();
            Window window = copiarVagaDialog.getWindow();
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    };

    View.OnClickListener buttonLigarCentral_click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            try
            {
                String numero = new SessionManager(context).getPreferences("telefoneCentral");

                if(numero != null)
                {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + numero));
                    startActivity(intent);
                }
                else
                {
                    EditarNumeroCentralDialog editarNumeroCentralDialog = new EditarNumeroCentralDialog(context);
                    editarNumeroCentralDialog.show();
                    Window window = editarNumeroCentralDialog.getWindow();
                    window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                }
            }
            catch(Exception e)
            {
                Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
            }

        }
    };

    View.OnLongClickListener buttonLigarCentral_longClick = new View.OnLongClickListener()
    {
        @Override
        public boolean onLongClick(View v)
        {
            EditarNumeroCentralDialog editarNumeroCentralDialog = new EditarNumeroCentralDialog(context);
            editarNumeroCentralDialog.show();
            Window window = editarNumeroCentralDialog.getWindow();
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            return false;
        }
    };
}
