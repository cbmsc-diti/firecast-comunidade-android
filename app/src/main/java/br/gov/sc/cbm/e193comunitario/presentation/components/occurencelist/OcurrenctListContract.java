package br.gov.sc.cbm.e193comunitario.presentation.components.occurencelist;

import java.util.List;

import br.gov.sc.cbm.e193comunitario.domain.Occurence;

/**
 * Created by bonet on 9/13/16.
 */

public interface OcurrenctListContract {

    interface View {

        void updateOccurrences(List<Occurence> occ);

        void addOccurrence(Occurence occ);

        void removeOccurrence(int occurenceId);

        void showError(String error);

    }

    interface Presenter {

        void attach(View v);

        void dettach();

    }

}
