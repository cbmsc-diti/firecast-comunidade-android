package br.gov.sc.cbm.fccomunidade.presentation.components.occurenceitem;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import br.gov.sc.cbm.fccomunidade.domain.Occurrence;

/**
 * Created by bonet on 9/21/16.
 */
public abstract class OccurenceItem extends RecyclerView.ViewHolder {

    public OccurenceItem(View itemView) {
        super(itemView);
    }

    public abstract void setOccurrence(Occurrence occ);
}
