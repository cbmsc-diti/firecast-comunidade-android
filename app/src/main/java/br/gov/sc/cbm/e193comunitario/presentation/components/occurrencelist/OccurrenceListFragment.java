package br.gov.sc.cbm.e193comunitario.presentation.components.occurrencelist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.gov.sc.cbm.e193comunitario.R;
import br.gov.sc.cbm.e193comunitario.domain.Occurrence;
import br.gov.sc.cbm.e193comunitario.injection.Injector;

/**
 * Created by bonet on 9/22/16.
 */

public class OccurrenceListFragment extends Fragment implements OccurrenceListContract.View{

    private OccurrenceListAdapter adapter;

    private OccurrenceListContract.Presenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new OccurrenceListPresenter(Injector.get().provideOccurrenceRepo());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.occurrencelist__fragment, container, false);
        RecyclerView rv = (RecyclerView) v.findViewById(R.id.occurencelist__list);

        rv.setLayoutManager(new LinearLayoutManager(rv.getContext()));

        adapter = new OccurrenceListAdapter();

        rv.setAdapter(adapter);

        return v;

    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.attach(this);
    }

    @Override
    public void onStop() {
        presenter.dettach();
        super.onStop();
    }

    @Override
    public void updateOccurrences(List<Occurrence> occs) {
        adapter.updateOccurrences(occs);
    }

    @Override
    public void addOccurrence(Occurrence occ) {
        adapter.addOccurrence(occ);
    }

    @Override
    public void removeOccurrence(int occurrenceId) {
        // TODO UPDATE THIS
    }

    @Override
    public void showError(String error) {
        adapter.showError(error);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
