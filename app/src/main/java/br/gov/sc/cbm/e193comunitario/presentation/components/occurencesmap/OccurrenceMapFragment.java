package br.gov.sc.cbm.e193comunitario.presentation.components.occurencesmap;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.gov.sc.cbm.e193comunitario.R;
import br.gov.sc.cbm.e193comunitario.domain.Occurrence;
import br.gov.sc.cbm.e193comunitario.injection.Injector;
import br.gov.sc.cbm.e193comunitario.presentation.components.common.OccurrenceColletionView;
import br.gov.sc.cbm.e193comunitario.presentation.components.occurrencelist.OccurrenceListAdapter;
import br.gov.sc.cbm.e193comunitario.presentation.components.occurrencelist.OccurrenceListContract;
import br.gov.sc.cbm.e193comunitario.presentation.components.occurrencelist.OccurrenceListPresenter;

/**
 * Created by bonet on 9/22/16.
 */

public class OccurrenceMapFragment extends Fragment implements OccurrenceColletionView {

    private OccurrenceListAdapter adapter;

    private OccurrenceListContract.Presenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new OccurrenceListPresenter(Injector.get().provideOccurrenceRepo(), null);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.occurrencemap__fragment, container, false);

        return v;

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void updateOccurrences(List<Occurrence> occs) {
    }

    @Override
    public void addOccurrence(Occurrence occ) {
    }

    @Override
    public void removeOccurrence(int occurrenceId) {

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
