package br.gov.sc.cbm.e193comunitario.presentation.screens.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import br.gov.sc.cbm.e193comunitario.R;
import br.gov.sc.cbm.e193comunitario.injection.Injector;
import br.gov.sc.cbm.e193comunitario.presentation.components.occurencelist.OccurenceListListView;
import br.gov.sc.cbm.e193comunitario.presentation.components.occurencelist.OccurenceListPresenter;
import br.gov.sc.cbm.e193comunitario.presentation.components.occurencelist.OcurrenctListContract;

public class OccurenceListActivity extends AppCompatActivity {

    private OccurenceListListView adapter;

    private OcurrenctListContract.Presenter listPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.occurencelist__activity);

        RecyclerView rv = (RecyclerView) findViewById(R.id.occurencelist__list);


        rv.setLayoutManager(new LinearLayoutManager(rv.getContext()));

        adapter = new OccurenceListListView();

        rv.setAdapter(adapter);

        listPresenter = new OccurenceListPresenter(Injector.get().provideOccurenceRepo());
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
