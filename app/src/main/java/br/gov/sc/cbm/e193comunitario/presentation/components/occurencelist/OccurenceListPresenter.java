package br.gov.sc.cbm.e193comunitario.presentation.components.occurencelist;


import br.gov.sc.cbm.e193comunitario.domain.OccurenceRepository;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by bonet on 9/13/16.
 */

public class OccurenceListPresenter implements OcurrenctListContract.Presenter {

    private OcurrenctListContract.View view;

    private OccurenceRepository repo;

    private CompositeSubscription subs;

    public OccurenceListPresenter(OccurenceRepository repo) {
        this.repo = repo;
        subs = new CompositeSubscription();

    }

    @Override
    public void attach(OcurrenctListContract.View v) {

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
