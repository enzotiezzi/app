package br.com.zelar.zellarempresas.Views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import br.com.zelar.zellarempresas.Fragments.CriarVagaActivityFragment;
import br.com.zelar.zellarempresas.Fragments.EscolherMetodoCriacaoActivityFragment;
import br.com.zelar.zellarempresas.Fragments.GestaoEmpresaActivityFragment;
import br.com.zelar.zellarempresas.Fragments.HomeActivityFragment;
import br.com.zelar.zellarempresas.Fragments.ListaVagasActivityFragment;
import br.com.zelar.zellarempresas.Fragments.VagasPendentesActivityFragment;
import br.com.zelar.zellarempresas.PushNotification.PushManager;
import br.com.zelar.zellarempresas.R;
import br.com.zelar.zellarempresas.Session.SessionManager;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Button b = (Button) findViewById(R.id.buttonTeste);

        Intent i = getIntent();

        boolean fromPush = i.getBooleanExtra("fromPush", false);

        if(!fromPush)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, new GestaoEmpresaActivityFragment())
                    .commit();
        }
        else
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, new VagasPendentesActivityFragment())
                    .commit();
        }

    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        } else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;

        switch (id)
        {
            case R.id.home:
                fragment = new GestaoEmpresaActivityFragment();
                break;

            case R.id.criar_vaga:
                fragment = new EscolherMetodoCriacaoActivityFragment();
                break;

            case R.id.vagas_pendentes:
                fragment = new VagasPendentesActivityFragment();
                break;

            case R.id.vagas_semana:
                fragment = new HomeActivityFragment();
                break;

            case R.id.lista_vagas:
                fragment = new ListaVagasActivityFragment();
                break;

            case R.id.logout:
                new SessionManager(context).cleanPreferences();
                finish();
                System.exit(0);
                break;
        }

        if(fragment != null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
