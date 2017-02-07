package br.gov.sc.cbm.e193comunitario.presentation.screens.occurences;

import java.util.List;

import br.gov.sc.cbm.e193comunitario.domain.Occurrence;

/**
 * Created by bonet on 9/27/16.
 */

public class OccurrenceFilter {

    final boolean option1;

    final boolean option2;

    public OccurrenceFilter(boolean option1, boolean option2) {
        this.option1 = option1;
        this.option2 = option2;
    }

    public OccurrenceFilter() {
        option1 = false;
        option2 = false;
    }
}
