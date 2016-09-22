package br.gov.sc.cbm.e193comunitario.presentation.components.occurenceitem;

import android.view.View;
import android.widget.TextView;

import br.gov.sc.cbm.e193comunitario.R;
import br.gov.sc.cbm.e193comunitario.domain.Occurrence;

/**
 * Created by bonet on 9/21/16.
 */
public class SimpleOccurrenceItem extends OccurenceItem {

    Occurrence occ;

    TextView typeView;
    TextView idView;
    TextView descriptionView;

    View v;

    public SimpleOccurrenceItem(View itemView) {
        super(itemView);

        typeView = (TextView) itemView.findViewById(R.id.simpleoccurrenceitem__type);
        idView = (TextView) itemView.findViewById(R.id.simpleoccurrenceitem__id);
        descriptionView = (TextView) itemView.findViewById(R.id.simpleoccurrenceitem__description);

    }

    public void setOccurrence(Occurrence occ) {
        this.occ = occ;

        typeView.setText(occ.type.name);
        idView.setText("" + occ.id);
        descriptionView.setText(occ.description);
    }

}
