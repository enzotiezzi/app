package br.com.zelar.zellarempresas.Custom;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.internal.bind.ObjectTypeAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.zelar.zellarempresas.Empresas.GestaoEmpresaTreeViewModel;
import br.com.zelar.zellarempresas.Http.HttpClientHelper;
import br.com.zelar.zellarempresas.Http.ICallback;
import br.com.zelar.zellarempresas.R;
import br.com.zelar.zellarempresas.Session.SessionManager;
import br.com.zelar.zellarempresas.Utilities.ObjectUtilities;
import br.com.zelar.zellarempresas.Utilities.Utils;

/**
 * Created by enzo on 13/07/2016.
 */
public class GroupItemView extends LinearLayout
{
    private final String EMPRESA = "Empresa";
    private final String GRUPO = "Grupo";
    private final String LOCAL = "Local";

    private Context context;
    private View v;
    private LinearLayout linearLayoutItem;

    private int nivel;
    private GestaoEmpresaTreeViewModel gestaoEmpresaTreeViewModel;
    private List<GestaoEmpresaTreeViewModel> gestaoEmpresaTreeViewModels;

    private ImageView imageViewTipo;
    private ImageView imageViewOpen;
    private TextView textViewNumeroGrupo;
    private TextView textViewNomeGrupo;
    private TextView textViewLocais;
    private TextView textViewPrevisto;
    private TextView textViewPessoas;
    private TextView textViewVagas;

    private ViewGroup appendGroup;

    public GroupItemView(Context context)
    {
        super(context);

        this.context = context;

        initialize();
    }

    public GroupItemView(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        this.context = context;

        initialize();
    }

    public void setGestaoEmpresaTreeViewModel(GestaoEmpresaTreeViewModel gestaoEmpresaTreeViewModel)
    {
        this.gestaoEmpresaTreeViewModel = gestaoEmpresaTreeViewModel;

        setup();
    }

    public void setNivel(int nivel)
    {
        this.nivel = nivel;

        int margin_left = nivel * 24;

        LinearLayout.LayoutParams layoutParams = (LayoutParams) imageViewOpen.getLayoutParams();
        layoutParams.setMargins(margin_left, 0, 0, 0);

        imageViewOpen.setLayoutParams(layoutParams);
    }

    private void initialize()
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        v = inflater.inflate(R.layout.gestao_empresa_item, this);

        gestaoEmpresaTreeViewModels = new ArrayList<>();
        nivel = 1;

        linearLayoutItem = (LinearLayout) v.findViewById(R.id.linearLayoutItem);

        imageViewTipo = (ImageView) v.findViewById(R.id.imageViewTipo);
        imageViewOpen = (ImageView) v.findViewById(R.id.imageViewOpen);
        textViewNumeroGrupo = (TextView) v.findViewById(R.id.textViewNumeroGrupo);
        textViewNomeGrupo = (TextView) v.findViewById(R.id.textViewNomeGrupo);
        textViewLocais = (TextView) v.findViewById(R.id.textViewLocais);
        textViewPrevisto = (TextView) v.findViewById(R.id.textViewPrevisto);
        textViewPessoas = (TextView) v.findViewById(R.id.textViewPessoas);
        textViewVagas = (TextView) v.findViewById(R.id.textViewVagas);

        appendGroup = (ViewGroup) v.findViewById(R.id.appendGroup);

        imageViewOpen.setOnClickListener(imageViewOpen_click);
        textViewNomeGrupo.setOnClickListener(imageViewOpen_click);
    }

    private void setup()
    {
        setupIconType();

        textViewNomeGrupo.setText(ObjectUtilities.getValue(gestaoEmpresaTreeViewModel.getNome()));
        textViewLocais.setText(ObjectUtilities.getValue(gestaoEmpresaTreeViewModel.getQtdeLocal()));
        textViewPrevisto.setText(ObjectUtilities.getValue(gestaoEmpresaTreeViewModel.getQtdePrevisto()));
        textViewPessoas.setText(ObjectUtilities.getValue(gestaoEmpresaTreeViewModel.getQtdePessoas()));
        textViewVagas.setText(ObjectUtilities.getValue(gestaoEmpresaTreeViewModel.getQtdeVagas()));
    }

    private void setupIconType()
    {
        switch (gestaoEmpresaTreeViewModel.getTipo())
        {
            case LOCAL:
                imageViewTipo.setImageResource(R.drawable.localizacao_top);
                imageViewOpen.setVisibility(INVISIBLE);
                textViewNomeGrupo.setOnClickListener(null);
                break;
            case GRUPO:
                imageViewTipo.setVisibility(GONE);
                textViewNumeroGrupo.setVisibility(VISIBLE);
                textViewNumeroGrupo.setText("G" + ObjectUtilities.getValue(gestaoEmpresaTreeViewModel.getNumero()));
                break;
        }
    }

    OnClickListener imageViewOpen_click = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            if(gestaoEmpresaTreeViewModels.size() == 0)
            {
                nivel++;

                String idNivel = gestaoEmpresaTreeViewModel.getId();
                String idUsuario = new SessionManager(context).getPreferences("idUsuario");

                String url = Utils.buildURL(context, "Mobile/BuscarNiveisAbaixo?idNivel="+idNivel+"&idUsuario="+idUsuario);

                HttpClientHelper.sendRequest(context, "get", url, new ICallback()
                {
                    @Override
                    public void onRequestEnd(int statusCode, Throwable t, String response)
                    {
                        if(statusCode == 200 && t == null)
                        {
                            GestaoEmpresaTreeViewModel[] empresas = new Gson().fromJson(response, GestaoEmpresaTreeViewModel[].class);

                            gestaoEmpresaTreeViewModels.addAll(Arrays.asList(empresas));

                            if(empresas.length > 0)
                            {
                                for(int i = 0; i < empresas.length; i++)
                                {
                                    GroupItemView groupItemView = new GroupItemView(context);
                                    groupItemView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                                    groupItemView.setGestaoEmpresaTreeViewModel(empresas[i]);
                                    if(i % 2 == (nivel % 2)) groupItemView.setZebra();
                                    groupItemView.setNivel(nivel);

                                    appendGroup.addView(groupItemView, i);
                                }
                            }
                        }
                    }
                }, null);
            }

            toggleContents();
        }
    };

    private void toggleContents()
    {
        if(appendGroup.isShown())
        {
            slideUp(appendGroup);
            appendGroup.setVisibility(View.GONE);
        }
        else{
            slideDown(appendGroup);
            appendGroup.setVisibility(View.VISIBLE);
        }
    }

    private void slideDown(View v)
    {
        Animation a = AnimationUtils.loadAnimation(context, R.anim.slide_down);
        if(a != null)
        {
            a.reset();
            if(v != null)
            {
                v.clearAnimation();
                v.startAnimation(a);
            }
        }
    }

    private void slideUp(View v)
    {
        Animation a = AnimationUtils.loadAnimation(context, R.anim.slide_up);
        if(a != null)
        {
            a.reset();
            if(v != null)
            {
                v.clearAnimation();
                v.startAnimation(a);
            }
        }
    }

    private void setZebra()
    {
        linearLayoutItem.setBackgroundColor(Color.parseColor("#F3E5F5"));
    }
}
