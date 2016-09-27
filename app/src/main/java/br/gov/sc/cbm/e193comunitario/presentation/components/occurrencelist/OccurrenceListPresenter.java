package br.gov.sc.cbm.e193comunitario.presentation.components.occurrencelist;


import java.util.List;
import java.util.concurrent.TimeUnit;

import br.gov.sc.cbm.e193comunitario.domain.Occurrence;
import br.gov.sc.cbm.e193comunitario.domain.OccurrenceRepository;
import br.gov.sc.cbm.e193comunitario.presentation.components.common.OccurenceColletionView;
import br.gov.sc.cbm.e193comunitario.presentation.components.common.OccurrenceCollectionFilter;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by bonet on 9/13/16.
 */

public class OccurrenceListPresenter implements OccurrenceListContract.Presenter {

    private OccurenceColletionView view;

    private OccurrenceRepository repo;

    private CompositeSubscription subs;

    private List<Occurrence> data;

    private OccurrenceCollectionFilter filter;

    public OccurrenceListPresenter(OccurrenceRepository repo, OccurrenceCollectionFilter filter) {
        this.repo = repo;
        this.filter = filter;

        subs = new CompositeSubscription();

    }


    public OccurrenceListPresenter(OccurrenceRepository repo) {
        this(repo, new OccurrenceCollectionFilter());
    }

    @Override
    public void attach(OccurenceColletionView v) {

        view = v;
        loadData(false, this.filter, this.data);
    }

    @Override
    public void dettach() {
        view = null;

        if(subs.hasSubscriptions())
            subs.unsubscribe();
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
        subs.clear();

        Subscription s = ((refresh || data == null)? this.repo.getOccurrences():Observable.just(dt))
                .subscribeOn(Schedulers.computation()) // A partir daqui tudo ocorre na Thread de computação
                .doOnSubscribe(view::showLoading) // Mostra loading na view
                .doOnNext(occ -> this.data = occ) // Salva dados recebidos
                .flatMap(Observable::from) // Começa a operar sobre os elementos da lista
                .filter(filter::filter) // Filtra cada elemento
                .toList() // Volta a ser lista
                .observeOn(AndroidSchedulers.mainThread()) // A partir daqui tudo ocorre na mainthread
                .subscribe(
                        view::updateOccurrences,
                        err -> view.showError("Ocorreu um erro"),
                        view::hideLoading
                );

        subs.add(s);


    }


}
