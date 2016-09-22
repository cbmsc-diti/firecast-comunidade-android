package br.gov.sc.cbm.e193comunitario.presentation.components.occurrencelist;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import br.gov.sc.cbm.e193comunitario.domain.Occurrence;

/**
 * Created by bonet on 9/21/16.
 */
abstract class OccurenceItem extends RecyclerView.ViewHolder {

    public OccurenceItem(View itemView) {
        super(itemView);
    }

    abstract void setOccurrence(Occurrence occ);
}
