package br.gov.sc.cbm.e193comunitario.presentation.screens.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import br.gov.sc.cbm.e193comunitario.R;
import br.gov.sc.cbm.e193comunitario.injection.Injector;
import br.gov.sc.cbm.e193comunitario.presentation.components.occurrencelist.OccurrenceListListView;
import br.gov.sc.cbm.e193comunitario.presentation.components.occurrencelist.OccurrenceListPresenter;
import br.gov.sc.cbm.e193comunitario.presentation.components.occurrencelist.OccurrenceListContract;

public class OccurrenceListActivity extends AppCompatActivity {

    private OccurrenceListListView adapter;

    private OccurrenceListContract.Presenter listPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.occurrencelist__activity);

        RecyclerView rv = (RecyclerView) findViewById(R.id.occurrencelist__list);


        rv.setLayoutManager(new LinearLayoutManager(rv.getContext()));

        adapter = new OccurrenceListListView();

        rv.setAdapter(adapter);

        listPresenter = new OccurrenceListPresenter(Injector.get().provideOccurrenceRepo());
        listPresenter.attach(adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        listPresenter.dettach();
        super.onStop();

    }
}
