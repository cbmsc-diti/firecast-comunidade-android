package br.gov.sc.cbm.fccomunidade.injection;

import br.gov.sc.cbm.fccomunidade.domain.OccurrenceRepository;

/**
 * Created by bonet on 9/13/16.
 */

public interface Provider {

    OccurrenceRepository provideOccurrenceRepo();

}
