package br.gov.sc.cbm.fccomunidade.presentation.components.occurencesmap;

import br.gov.sc.cbm.fccomunidade.presentation.components.common.OccurrenceColletionView;

/**
 * Created by bonet on 9/27/16.
 */

public interface Contract {

    interface OccurenceMapPresenter {

        void attach(OccurrenceColletionView v);

        void dettach();

        void refreshData();

        void updateFilter();

    }
}
