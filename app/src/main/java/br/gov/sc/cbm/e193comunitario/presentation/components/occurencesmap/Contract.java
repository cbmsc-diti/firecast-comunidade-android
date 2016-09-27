package br.gov.sc.cbm.e193comunitario.presentation.components.occurencesmap;

import br.gov.sc.cbm.e193comunitario.presentation.components.common.OccurenceColletionView;
import br.gov.sc.cbm.e193comunitario.presentation.components.occurrencelist.OccurrenceListContract;

/**
 * Created by bonet on 9/27/16.
 */

public interface Contract {

    interface OccurenceMapPresenter {

        void attach(OccurenceColletionView v);

        void dettach();

        void refreshData();

        void updateFilter();

    }
}
