package br.gov.sc.cbm.fccomunidade.injection;

import br.gov.sc.cbm.fccomunidade.data.FirecastClient;
import br.gov.sc.cbm.fccomunidade.domain.OccurrenceRepository;

/**
 * Created by bonet on 9/30/16.
 */

public class AppProvider implements Provider {

    private FirecastClient client;

    @Override
    public OccurrenceRepository provideOccurrenceRepo() {
        return client = (client==null)? new FirecastClient():client;
    }
}