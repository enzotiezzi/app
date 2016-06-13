package br.com.zelar.zellarempresas.Views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import Dialogs.ShowMessage;
import Http.HttpClientHelper;
import Http.ICallback;
import Models.Empresas.Authentication;
import Session.SessionManager;
import br.com.zelar.zellarempresas.R;

public class LoginActivity extends AppCompatActivity
{
    private Context context = this;

    private EditText editTextLogin;
    private EditText editTextSenha;
    private Button buttonLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextLogin = (EditText) findViewById(R.id.editTextLogin);
        editTextSenha = (EditText) findViewById(R.id.editTextSenha);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(buttonLogin_click);
    }

    View.OnClickListener buttonLogin_click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            String login = editTextLogin.getText().toString();
            String senha = editTextSenha.getText().toString();

            Authentication a = new Authentication();
            a.setLogin(login);
            a.setSenha(senha);

            String url = "http://10.0.2.2/Zellar/Home/LoginMobile";

            HttpClientHelper.sendRequest(context, "post", url, new ICallback()
            {
                @Override
                public void onRequestEnd(int statusCode, Throwable t, String response)
                {
                    if (t == null && statusCode == 200)
                    {
                        Authentication authentication = new Gson().fromJson(response, Authentication.class);

                        if (authentication.isResponse())
                        {
                            SessionManager sessionManager = new SessionManager(context);
                            sessionManager.setPreferences("idEmpresa", authentication.getIdEmpresa());
                            sessionManager.setPreferences("nomeEmpresa", authentication.getNomeEmpresa());
                            sessionManager.setPreferences("idUsuario", authentication.getIdUsuario());

                            Intent i = new Intent(context, MainActivity.class);
                            context.startActivity(i);
                        }
                        else
                        {
                            ShowMessage.showDialog(context, "Aviso", "Usuário ou senha incorreto(s)", "OK", null);
                        }
                    }
                }
            }, a);
        }
    };
}