package br.gov.sc.cbm.e193comunitario.presentation.screens.occurences.occurrencelist;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import br.gov.sc.cbm.e193comunitario.data.events.OccurrencesFailedLoading;
import br.gov.sc.cbm.e193comunitario.data.events.OcurrencesFinishedLoading;
import br.gov.sc.cbm.e193comunitario.domain.Occurrence;
import br.gov.sc.cbm.e193comunitario.domain.OccurrenceRepository;
import br.gov.sc.cbm.e193comunitario.presentation.screens.occurences.OccurenceColletionView;
import br.gov.sc.cbm.e193comunitario.presentation.screens.occurences.OccurrenceCollectionFilter;
import br.gov.sc.cbm.e193comunitario.presentation.screens.occurences.events.FilterUpdated;

/**
 * Created by bonet on 9/13/16.
 */

public class OccurrenceListPresenter implements OccurrenceListContract.Presenter {

    private OccurenceColletionView view;

    private OccurrenceRepository repo;

    private List<Occurrence> data;

    private OccurrenceCollectionFilter filter;

    public OccurrenceListPresenter(OccurrenceRepository repo, OccurrenceCollectionFilter filter) {
        this.repo = repo;
        this.filter = filter;
    }


    public OccurrenceListPresenter(OccurrenceRepository repo) {
        this(repo, new OccurrenceCollectionFilter());
    }

    @Override
    public void attach(OccurenceColletionView v) {

        EventBus.getDefault().register(this);
        view = v;
        loadData(false, this.filter, this.data);
    }

    @Override
    public void dettach() {
        view = null;

        EventBus.getDefault().unregister(this);

    }

    @Override
    public void refreshData() {
        loadData(true, filter, null);
    }


    @Override
    public void updateFilter(OccurrenceCollectionFilter filter) {
        this.filter = filter;

        loadData(false, this.filter, this.data);
    }


    private void loadData(boolean refresh, OccurrenceCollectionFilter filter, List<Occurrence> dt) {

        if(refresh || dt == null) {
            repo.getOccurrences();
            view.showLoading();
        } else {
            view.updateOccurrences(dt);
        }

    }

    @Subscribe
    public void respondTo(OcurrencesFinishedLoading event) {
        this.data = event.occurrences;
        view.updateOccurrences(this.data);
        view.hideLoading();
    }

    @Subscribe
    public void respondTo(OccurrencesFailedLoading event) {
        view.showError("Ops, aconteceu um erro :(");
        view.hideLoading();
    }

    @Subscribe
    public void respondTo(FilterUpdated event) {

        // this.loadData .....
        view.showMessage("Filter was updated");
    }





}
