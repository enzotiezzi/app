package br.com.zelar.zellarempresas.Custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.com.zelar.zellarempresas.Infrastructure.IBasic;
import br.com.zelar.zellarempresas.R;

/**
 * Created by Usuário on 05/07/2016.
 */
public class ExpandableLayout extends LinearLayout
{
    private Context context;
    private View rootView;

    private ExpandableItem[] expandableItems;

    public ExpandableLayout(Context context)
    {
        super(context);
        this.context = context;

        draw(context);
    }

    public void setExpandableItems(ExpandableItem[] expandableItems)
    {
        this.expandableItems = expandableItems;
    }

    private void draw(Context context)
    {
        rootView =  inflate(context, R.layout.expandable_view, this);

        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(R.id.appendItemPoint);

        for (ExpandableItem i : expandableItems)
        {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View v = layoutInflater.inflate(R.layout.expandable_view_item, null);

            TextView textViewTitle = (TextView) viewGroup.findViewById(R.id.textViewTitle);
            View expandTitle = v.findViewById(R.id.expandTitle);
            expandTitle.setOnClickListener(expandTitle_click);
            ViewGroup viewGroupItem = (ViewGroup) v.findViewById(R.id.appendPoint);

            textViewTitle.setText(i.getTitle());
            viewGroupItem.addView(i.getV());

            viewGroup.addView(v);
        }
    }

    public void toggle_contents(View v)
    {
        if(v.isShown())
        {
            slide_up(context, v);
            v.setVisibility(View.GONE);
        }
        else{
            v.setVisibility(View.VISIBLE);
            slide_down(context, v);
        }
    }

    private static void slide_down(Context ctx, View v)
    {
        Animation a = AnimationUtils.loadAnimation(ctx, R.anim.slide_down);
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

    private static void slide_up(Context ctx, View v)
    {
        Animation a = AnimationUtils.loadAnimation(ctx, R.anim.slide_down);
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

    OnClickListener expandTitle_click = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            toggle_contents(v);
        }
    };
}
