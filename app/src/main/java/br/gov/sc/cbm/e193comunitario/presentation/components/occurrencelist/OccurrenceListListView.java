package br.gov.sc.cbm.e193comunitario.presentation.components.occurrencelist;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.gov.sc.cbm.e193comunitario.R;
import br.gov.sc.cbm.e193comunitario.domain.Occurrence;

/**
 * Created by bonet on 9/13/16.
 */

public class OccurrenceListListView extends RecyclerView.Adapter<OccurenceItem> implements OccurrenceListContract.View {
    private static final String TAG = "OccurrenceListListView";

    List<Occurrence> occurrences;

    public OccurrenceListListView() {
        this(new ArrayList<>());
    }

    public OccurrenceListListView(List<Occurrence> occs) {
        occurrences = occs;
    }

    @Override
    public void updateOccurrences(List<Occurrence> occs) {
        this.occurrences = occs;
        this.notifyDataSetChanged();
    }

    @Override
    public void addOccurrence(Occurrence occ) {
        occurrences.add(occ);
        this.notifyItemInserted(occurrences.size()-1);
    }

    @Override
    public void removeOccurrence(int occurrenceId) {
        // TODO: implement later
    }

    @Override
    public void showError(String error) {
        Log.d(TAG, "showError() called with: error = [" + error + "]");
    }

    @Override
    public OccurenceItem onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.occurrencelist_cardoccurrenceitem, null, false);

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
