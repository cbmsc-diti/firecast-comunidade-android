package br.gov.sc.cbm.e193comunitario.presentation.components.occurrencelist;


import br.gov.sc.cbm.e193comunitario.domain.OccurrenceRepository;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by bonet on 9/13/16.
 */

public class OccurrenceListPresenter implements OccurrenceListContract.Presenter {

    private OccurrenceListContract.View view;

    private OccurrenceRepository repo;

    private CompositeSubscription subs;

    public OccurrenceListPresenter(OccurrenceRepository repo) {
        this.repo = repo;
        subs = new CompositeSubscription();

    }

    @Override
    public void attach(OccurrenceListContract.View v) {

        view = v;

        Subscription s = this.repo.getOccurrences()
                .subscribeOn(Schedulers.computation()) // A partir daqui tudo ocorre na Thread de computação
                .observeOn(AndroidSchedulers.mainThread()) // A partir daqui tudo ocorre na mainthread
                .subscribe(
                        occ -> view.updateOccurrences(occ),
                        err -> view.showError("Ocorreu um erro"),
                        () -> {}
                );

        subs.add(s);
    }

    @Override
    public void dettach() {
        if(subs.hasSubscriptions())
            subs.unsubscribe();
    }
}
