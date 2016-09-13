package br.gov.sc.cbm.e193comunitario.presentation.components.occurencelist;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.gov.sc.cbm.e193comunitario.R;
import br.gov.sc.cbm.e193comunitario.domain.Occurence;

/**
 * Created by bonet on 9/13/16.
 */

public class OccurenceListListView extends RecyclerView.Adapter<OccurenceListListView.OccurenceItem> implements OcurrenctListContract.View {
    private static final String TAG = "OccurenceListListView";

    List<Occurence> occurences;

    public OccurenceListListView() {
        this(new ArrayList<>());
    }

    public OccurenceListListView(List<Occurence> occs) {
        occurences = occs;
    }

    @Override
    public void updateOccurrences(List<Occurence> occs) {
        this.occurences = occs;
        this.notifyDataSetChanged();
    }

    @Override
    public void addOccurrence(Occurence occ) {
        occurences.add(occ);
        this.notifyItemInserted(occurences.size()-1);
    }

    @Override
    public void removeOccurrence(int occurenceId) {
        // TODO: implement later
    }

    @Override
    public void showError(String error) {
        Log.d(TAG, "showError() called with: error = [" + error + "]");
    }

    @Override
    public OccurenceItem onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.occurencelist_simpleoccurenceitem, null, false);

        return new OccurenceItem(v);
    }

    @Override
    public void onBindViewHolder(OccurenceItem holder, int position) {
        holder.setOccurence(occurences.get(position));
    }


    @Override
    public int getItemCount() {
        return occurences.size();
    }


    class OccurenceItem extends RecyclerView.ViewHolder {

        Occurence occ;

        TextView typeView;
        TextView idView;
        TextView descriptionView;

        View v;

        public OccurenceItem(View itemView) {
            super(itemView);

            typeView = (TextView) itemView.findViewById(R.id.simpleoccurenceitem__type);
            idView = (TextView) itemView.findViewById(R.id.simpleoccurenceitem__id);
            descriptionView = (TextView) itemView.findViewById(R.id.simpleoccurenceitem__description);

        }

        public void setOccurence(Occurence occ) {
            this.occ = occ;

            typeView.setText(occ.type);
            idView.setText(""+occ.id);
            descriptionView.setText(occ.history);
        }

    }

}
