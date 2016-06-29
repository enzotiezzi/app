package br.com.zelar.zellarempresas.Fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.zelar.zellarempresas.PushNotification.PushManager;
import br.com.zelar.zellarempresas.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class HomeActivityFragment extends Fragment
{
    private Context context;

    public HomeActivityFragment()
    {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        context = getContext();

        PushManager.initialize(context);

        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}
