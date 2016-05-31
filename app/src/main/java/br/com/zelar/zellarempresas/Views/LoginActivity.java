package br.com.zelar.zellarempresas.Views;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import Http.HttpClientHelper;
import Http.ICallback;
import br.com.zelar.zellarempresas.R;

public class LoginActivity extends AppCompatActivity
{
    private Context context = this;
    private TextView textViewHello;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}