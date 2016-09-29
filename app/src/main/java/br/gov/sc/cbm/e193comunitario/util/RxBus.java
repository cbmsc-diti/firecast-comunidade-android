package br.gov.sc.cbm.e193comunitario.util;

import rx.Observable;
import rx.internal.util.ObjectPool;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by bonet on 9/27/16.
 */

public class RxBus {

    private static final Subject<Object, Object> _bus = new SerializedSubject<>(PublishSubject.create());

    public static void emmit(Object o) {
        _bus.onNext(o);
    }

    public static  Observable<Object> listen() {
        return _bus;
    }

    public static boolean hasObservers() {
        return _bus.hasObservers();
    }


}
