package br.gov.sc.cbm.e193comunitario.presentation.components.common;

import java.util.List;

import br.gov.sc.cbm.e193comunitario.domain.Occurrence;

/**
 * Created by bonet on 9/27/16.
 */

public class OccurrenceCollectionFilter {


    public List<Occurrence> filterMany(List<Occurrence> occ) {
        return occ;
    }

    public boolean filter(Occurrence occ) {
        return true;
    }


}
