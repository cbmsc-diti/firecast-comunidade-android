package br.gov.sc.cbm.e193comunitario.presentation.screens.occurences.occurenceitem;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;

import br.gov.sc.cbm.e193comunitario.R;
import br.gov.sc.cbm.e193comunitario.domain.Occurrence;

/**
 * Created by bonet on 9/21/16.
 */


public class CardOccurenceItem extends OccurenceItem {

    private static final String TAG = "CardOccurenceItem";

    Occurrence occ;

    TextView type, hour, distance, location, reference, city, description, cars;

    View v;

    public CardOccurenceItem(View itemView) {
        super(itemView);

        v = itemView;

        type = (TextView) itemView.findViewById(R.id.cardoccurrenceitem__type);
        hour = (TextView) itemView.findViewById(R.id.cardoccurrenceitem__hour);
        distance = (TextView) itemView.findViewById(R.id.cardoccurrenceitem__distance);
        location = (TextView) itemView.findViewById(R.id.cardoccurrenceitem__location);
        reference = (TextView) itemView.findViewById(R.id.cardoccurrenceitem__reference);
        city = (TextView) itemView.findViewById(R.id.cardoccurrenceitem__city);
        description = (TextView) itemView.findViewById(R.id.cardoccurrenceitem__description);
        cars = (TextView) itemView.findViewById(R.id.cardoccurrenceitem__cars);
    }

    public void setOccurrence(Occurrence occ) {
        this.occ = occ;

        Resources res = v.getContext().getResources();
        type.setText(occ.type.name);

        // Seta a cor a partir do tipo de ocorrência
        type.setBackgroundColor(res.getIntArray(R.array.occurence_colors)[occ.type.id- ((occ.type.id>=6)?2:1)]);

        if(occ.date == null)
            hour.setVisibility(View.GONE);
        else {
            hour.setText(occ.date);
            hour.setVisibility(View.VISIBLE);
        }

        distance.setText("1.4km"); // TODO: Update with actual direction

        location.setText(buildLocationString(occ));

        if(occ.addressReferencePoint != null) {
            reference.setText(occ.addressReferencePoint);
            reference.setVisibility(View.VISIBLE);
        } else {
            reference.setVisibility(View.GONE);
        }

        city.setText(occ.city.name);

        description.setText(occ.description);

        cars.setText(res.getQuantityString(R.plurals.cars_dispatched, occ.dispatchedCars.size(), occ.dispatchedCars.size()));

    }

    private String buildLocationString(Occurrence occ) {
        return occ.adressStreet+ ", "+occ.addressNeighborhood;
    }

}
