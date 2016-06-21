package br.com.zelar.zellarempresas.Views;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import Infrastructure.IBasic;
import br.com.zelar.zellarempresas.R;

public class VagasPendentesActivity extends AppCompatActivity implements IBasic
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vagas_pendentes);

        initialize();
    }

    @Override
    public void initialize()
    {

    }
}
