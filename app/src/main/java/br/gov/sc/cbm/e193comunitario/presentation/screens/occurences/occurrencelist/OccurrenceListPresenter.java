package br.gov.sc.cbm.e193comunitario.presentation.screens.occurences.occurrencelist;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import br.gov.sc.cbm.e193comunitario.data.events.OccurrencesFailedLoading;
import br.gov.sc.cbm.e193comunitario.data.events.OcurrencesFinishedLoading;
import br.gov.sc.cbm.e193comunitario.domain.Occurrence;
import br.gov.sc.cbm.e193comunitario.domain.OccurrenceRepository;
import br.gov.sc.cbm.e193comunitario.presentation.screens.occurences.OccurenceColletionView;
import br.gov.sc.cbm.e193comunitario.presentation.screens.occurences.OccurrenceFilter;
import br.gov.sc.cbm.e193comunitario.presentation.screens.occurences.events.FilterUpdatedEvent;

/**
 * Created by bonet on 9/13/16.
 */

public class OccurrenceListPresenter implements OccurrenceListContract.Presenter {

    private OccurenceColletionView view;

    private OccurrenceRepository repo;

    private List<Occurrence> data;

    private OccurrenceFilter filter;

    public OccurrenceListPresenter(OccurrenceRepository repo, OccurrenceFilter filter) {
        this.repo = repo;
        this.filter = filter;
    }


    public OccurrenceListPresenter(OccurrenceRepository repo) {
        this(repo, new OccurrenceFilter());
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

    private void loadData(boolean refresh, OccurrenceFilter filter, List<Occurrence> dt) {

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
    public void respondTo(FilterUpdatedEvent event) {

        view.showMessage("Filter was updated");
//        this.filter = filter;
//        loadData(false, this.filter, this.data);

    }





}
