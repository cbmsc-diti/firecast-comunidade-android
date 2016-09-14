package br.gov.sc.cbm.e193comunitario.presentation.components.occurrencelist;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.gov.sc.cbm.e193comunitario.R;
import br.gov.sc.cbm.e193comunitario.domain.Occurrence;

/**
 * Created by bonet on 9/13/16.
 */

public class OccurrenceListListView extends RecyclerView.Adapter<OccurrenceListListView.OccurrenceItem> implements OccurrenceListContract.View {
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
    public OccurrenceItem onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.occurrencelist_simpleoccurrenceitem, null, false);

        return new OccurrenceItem(v);
    }

    @Override
    public void onBindViewHolder(OccurrenceItem holder, int position) {
        holder.setOccurrence(occurrences.get(position));
    }


    @Override
    public int getItemCount() {
        return occurrences.size();
    }


    class OccurrenceItem extends RecyclerView.ViewHolder {

        Occurrence occ;

        TextView typeView;
        TextView idView;
        TextView descriptionView;

        View v;

        public OccurrenceItem(View itemView) {
            super(itemView);

            typeView = (TextView) itemView.findViewById(R.id.simpleoccurrenceitem__type);
            idView = (TextView) itemView.findViewById(R.id.simpleoccurrenceitem__id);
            descriptionView = (TextView) itemView.findViewById(R.id.simpleoccurrenceitem__description);

        }

        public void setOccurrence(Occurrence occ) {
            this.occ = occ;

            typeView.setText(occ.type);
            idView.setText(""+occ.id);
            descriptionView.setText(occ.history);
        }

    }

}
