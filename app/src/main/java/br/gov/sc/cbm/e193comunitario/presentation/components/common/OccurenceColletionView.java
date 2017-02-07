package br.gov.sc.cbm.e193comunitario.presentation.components.common;

import java.util.List;

import br.gov.sc.cbm.e193comunitario.domain.Occurrence;

/**
 * Created by bonet on 9/27/16.
 */

public interface OccurenceColletionView {

    void updateOccurrences(List<Occurrence> occ);

    void showError(String error);

    void showLoading();

    void hideLoading();

    void showMessage(String message);
}
