package br.gov.sc.cbm.e193comunitario.presentation.components.occurrencelist;

import java.util.List;

import br.gov.sc.cbm.e193comunitario.domain.Occurrence;
import br.gov.sc.cbm.e193comunitario.presentation.components.common.OccurenceColletionView;

/**
 * Created by bonet on 9/13/16.
 */

public interface OccurrenceListContract {

    interface Presenter {

        void attach(OccurenceColletionView v);

        void dettach();

        void refreshData();

        void updateFilter();

    }

}
