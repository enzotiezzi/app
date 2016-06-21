package br.com.zelar.zellarempresas.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.zelar.zellarempresas.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class VagasPendentesActivityFragment extends Fragment {

    public VagasPendentesActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_vagas_pendentes, container, false);
    }
}
