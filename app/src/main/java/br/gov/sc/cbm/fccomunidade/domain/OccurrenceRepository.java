package br.gov.sc.cbm.fccomunidade.domain;

import java.util.List;

import rx.Observable;

/**
 * Created by bonet on 9/13/16.
 */

public interface OccurrenceRepository {

    Observable<List<Occurrence>> getOccurrences();

}
