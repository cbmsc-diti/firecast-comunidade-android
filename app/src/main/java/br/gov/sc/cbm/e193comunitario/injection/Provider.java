package br.gov.sc.cbm.e193comunitario.injection;

import br.gov.sc.cbm.e193comunitario.domain.OccurenceRepository;

/**
 * Created by bonet on 9/13/16.
 */

public interface Provider {

    OccurenceRepository provideOccurenceRepo();

}
