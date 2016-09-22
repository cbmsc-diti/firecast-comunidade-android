package br.gov.sc.cbm.e193comunitario.presentation.components.occurrencelist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.gov.sc.cbm.e193comunitario.R;
import br.gov.sc.cbm.e193comunitario.domain.Occurrence;

/**
 * Created by bonet on 9/21/16.
 */


class CardOccurenceItem extends OccurenceItem {

    Occurrence occ;

    TextView type, hour, distance, location, reference, city;

    View v;

    public CardOccurenceItem(View itemView) {
        super(itemView);

        type = (TextView) itemView.findViewById(R.id.simpleoccurrenceitem__type);
        hour = (TextView) itemView.findViewById(R.id.simpleoccurrenceitem__hour);
        distance = (TextView) itemView.findViewById(R.id.simpleoccurrenceitem__distance);
        location = (TextView) itemView.findViewById(R.id.simpleoccurrenceitem__location);
        reference = (TextView) itemView.findViewById(R.id.simpleoccurrenceitem__reference);
        city = (TextView) itemView.findViewById(R.id.simpleoccurrenceitem__city);


    }

    public void setOccurrence(Occurrence occ) {
        this.occ = occ;
        type.setText(occ.type);
        hour.setText(occ.arrivalTime);
        distance.setText("1.4km");
        location.setText(buildLocationString(occ));
        reference.setText(occ.referencePoint);
        city.setText(occ.city);
    }

    private String buildLocationString(Occurrence occ) {
        return occ.adressStreet+ ", "+occ.neighborhood;
    }





}
