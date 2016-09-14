package br.gov.sc.cbm.e193comunitario.injection;

import br.gov.sc.cbm.e193comunitario.domain.OccurrenceRepository;

/**
 * Created by bonet on 9/13/16.
 */

public interface Provider {

    OccurrenceRepository provideOccurrenceRepo();

}
