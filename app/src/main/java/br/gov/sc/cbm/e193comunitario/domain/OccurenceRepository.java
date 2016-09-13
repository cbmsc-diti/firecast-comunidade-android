package br.gov.sc.cbm.e193comunitario.domain;

import java.util.List;

import rx.Observable;

/**
 * Created by bonet on 9/13/16.
 */

public interface OccurenceRepository {

    Observable<List<Occurence>> getOccurrences();

}
