package br.gov.sc.cbm.e193comunitario.presentation.components.occurrencelist;

import br.gov.sc.cbm.e193comunitario.presentation.components.common.OccurrenceColletionView;
import br.gov.sc.cbm.e193comunitario.presentation.components.common.OccurrenceCollectionFilter;

/**
 * Created by bonet on 9/13/16.
 */

public interface OccurrenceListContract {

    interface Presenter {

        void attach(OccurrenceColletionView v);

        void dettach();

        void refreshData();

        void updateFilter(OccurrenceCollectionFilter filter);

    }

    interface Navigator {
        void openDetail(int occurenceID);
    }

    interface OpenOccurenceDetailListener {
        void onOpenOccurenceDetail(int occurenceID);
    }


}
