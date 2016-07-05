package br.com.zelar.zellarempresas.Custom;

import android.view.View;

/**
 * Created by Usuário on 05/07/2016.
 */
public class ExpandableItem
{
    private String title;
    private View v;

    public ExpandableItem(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public View getV() {
        return v;
    }

    public void setV(View v) {
        this.v = v;
    }
}
