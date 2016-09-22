package br.gov.sc.cbm.e193comunitario.presentation.components.occurrencelist;

import java.util.List;

import br.gov.sc.cbm.e193comunitario.domain.Occurrence;

/**
 * Created by bonet on 9/13/16.
 */

public interface OccurrenceListContract {

    interface View {

        void updateOccurrences(List<Occurrence> occ);

        void addOccurrence(Occurrence occ);

        void removeOccurrence(int occurrenceId);

        void showError(String error);

        void showLoading();

        void hideLoading();

    }

    interface Presenter {

        void attach(View v);

        void dettach();

    }

}
