package br.gov.sc.cbm.e193comunitario.presentation.screens.occurences.filter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import br.gov.sc.cbm.e193comunitario.R;
import br.gov.sc.cbm.e193comunitario.presentation.screens.occurences.OccurrenceFilter;
import br.gov.sc.cbm.e193comunitario.presentation.screens.occurences.occurrencelist.OccurrenceListContract;

/**
 * Created by bonet on 9/27/16.
 */

public class FilterView extends LinearLayout {

    private OnUpdatedFilterListener updateFilterListener = OnUpdatedFilterListener.NOOP;

    private FilterPresenter presenter;
    public FilterView(Context context) {
        super(context);
        setup(context);
    }

    public FilterView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setup(context);
    }

    public FilterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setup(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public FilterView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        setup(context);
    }


    private void setup(Context context) {
        View v = LayoutInflater.from(context).inflate(R.layout.displayoccurences__filter, null);

        this.addView(v);

        v.findViewById(R.id.displayoccurrences__filter__update).setOnClickListener((e) -> updateFilterListener.onUpdateFilter(new OccurrenceFilter()));
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        presenter = new FilterPresenter();
        presenter.attach(this);
    }

    @Override
    protected void onDetachedFromWindow() {

        if(presenter!=null)
            presenter.dettach();

        super.onDetachedFromWindow();
    }

    public void setUpdateFilterListener(OnUpdatedFilterListener l) {
        this.updateFilterListener = l;
    }

    interface OnUpdatedFilterListener {
        void onUpdateFilter(OccurrenceFilter filter);

        OnUpdatedFilterListener NOOP = (filter -> {});
    }


}
