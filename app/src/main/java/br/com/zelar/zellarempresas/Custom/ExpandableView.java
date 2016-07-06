package br.com.zelar.zellarempresas.Custom;

import android.content.Context;
import android.util.AttributeSet;
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
public class ExpandableView extends View
{
    private Context context;
    private View rootView;

    private ExpandableItem[] expandableItems;

    public ExpandableView(Context context, ExpandableItem[] expandableItems)
    {
        super(context);
        this.context = context;
        this.expandableItems = expandableItems;

        draw();
    }

    public ExpandableView(Context context, AttributeSet attrs, ExpandableItem[] expandableItems)
    {
        super(context, attrs);
        this.context = context;
        this.expandableItems = expandableItems;

        draw();
    }

    public ExpandableView(Context context, AttributeSet attrs, int defStyleAttr, ExpandableItem[] expandableItems)
    {
        super(context, attrs, defStyleAttr);
        this.context = context;
        this.expandableItems = expandableItems;

        draw();
    }

    private void draw()
    {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        rootView = layoutInflater.inflate(R.layout.expandable_view, null, true);

        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(R.id.appendItemPoint);

        for (int j = 0; j < expandableItems.length; j++)
        {
            ExpandableItem i = expandableItems[j];

            View v = layoutInflater.inflate(R.layout.expandable_view_item, null);

            TextView textViewTitle = (TextView) v.findViewById(R.id.textViewTitle);
            View expandTitle = v.findViewById(R.id.expandTitle);
            final ViewGroup viewGroupItem = (ViewGroup) v.findViewById(R.id.appendPoint);

            textViewTitle.setText(i.getTitle());
            viewGroupItem.addView(i.getV(), 0);

            expandTitle.setOnClickListener(new OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    toggle_contents(viewGroupItem);
                }
            });

            viewGroup.addView(v, j);
        }
    }

    private void toggle_contents(View v)
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
}
