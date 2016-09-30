package br.gov.sc.cbm.fccomunidade.presentation.components.common;

import java.util.List;

import br.gov.sc.cbm.fccomunidade.domain.Occurrence;

/**
 * Created by bonet on 9/27/16.
 */

public interface OccurrenceColletionView {

    void updateOccurrences(List<Occurrence> occ);

    void addOccurrence(Occurrence occ);

    void removeOccurrence(int occurrenceId);

    void showError(String error);

    void showLoading();

    void hideLoading();

}
