package br.gov.sc.cbm.e193comunitario.presentation.components.occurrencelist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.gov.sc.cbm.e193comunitario.R;
import br.gov.sc.cbm.e193comunitario.domain.Occurrence;
import br.gov.sc.cbm.e193comunitario.presentation.components.occurenceitem.CardOccurenceItem;
import br.gov.sc.cbm.e193comunitario.presentation.components.occurenceitem.OccurenceItem;

/**
 * Created by bonet on 9/13/16.
 */

public class OccurrenceListAdapter extends RecyclerView.Adapter<OccurenceItem> {
    private static final String TAG = "OccurrenceListListView";

    List<Occurrence> occurrences;

    public OccurrenceListAdapter() {
        this(new ArrayList<>());
    }

    public OccurrenceListAdapter(List<Occurrence> occs) {

        this.occurrences = occs;

    }

    public void updateOccurrences(List<Occurrence> occs) {
        this.occurrences = occs;
        this.notifyDataSetChanged();
    }

    public void addOccurrence(Occurrence occ) {
        occurrences.add(occ);
        this.notifyItemInserted(occurrences.size()-1);
    }

    @Override
    public OccurenceItem onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.occurrencelist__carditem, null, false);

        return new CardOccurenceItem(v);
    }


    @Override
    public void onBindViewHolder(OccurenceItem holder, int position) {
        holder.setOccurrence(occurrences.get(position));
    }

    @Override
    public int getItemCount() {
        return occurrences.size();
    }

}
