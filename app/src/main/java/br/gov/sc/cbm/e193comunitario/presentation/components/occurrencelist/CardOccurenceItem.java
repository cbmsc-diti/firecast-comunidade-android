package br.gov.sc.cbm.e193comunitario.presentation.components.occurrencelist;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import br.gov.sc.cbm.e193comunitario.R;
import br.gov.sc.cbm.e193comunitario.domain.Occurrence;

/**
 * Created by bonet on 9/21/16.
 */


class CardOccurenceItem extends OccurenceItem {

    private static final String TAG = "CardOccurenceItem";

    Occurrence occ;

    TextView type, hour, distance, location, reference, city, description, cars;

    View v;
    private final SparseArray<Integer> colorMap = new SparseArray<Integer>() {
        {
            put(8,  R.color.occurrences_0);
            put(5,  R.color.occurrences_1);
            put(2,  R.color.occurrences_2);
            put(10, R.color.occurrences_3);
            put(11, R.color.occurrences_4);
            put(9,  R.color.occurrences_5);
            put(7,  R.color.occurrences_6);
            put(1,  R.color.occurrences_7);
            put(6,  R.color.occurrences_8);
            put(3,  R.color.occurrences_9);
            put(4,  R.color.occurrences_9);
        }
    };

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
        type.setText(occ.type.name);
        type.setBackgroundColor(v.getContext().getResources().getColor(colorMap.get(occ.type.id)));

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

        if(occ.dispatchedCars.size() == 1) {
            cars.setText("1 viatura a caminho.");
        } else if (occ.dispatchedCars.size() > 1) {
            cars.setText(occ.dispatchedCars.size()+ " viaturas a caminho.");
        } else {
            cars.setText("Nenhuma viatura a caminho.");
        }
    }

    private String buildLocationString(Occurrence occ) {
        return occ.adressStreet+ ", "+occ.addressNeighborhood;
    }

}
