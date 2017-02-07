package br.gov.sc.cbm.e193comunitario.presentation.screens.occurences.occurrencelist;

import br.gov.sc.cbm.e193comunitario.presentation.screens.occurences.OccurenceColletionView;
import br.gov.sc.cbm.e193comunitario.presentation.screens.occurences.OccurrenceCollectionFilter;

/**
 * Created by bonet on 9/13/16.
 */

public interface OccurrenceListContract {

    interface Presenter {

        void attach(OccurenceColletionView v);

        void dettach();

        void refreshData();

        void updateFilter(OccurrenceCollectionFilter filter);

    }

}
