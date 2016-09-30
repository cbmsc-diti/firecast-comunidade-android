package br.gov.sc.cbm.fccomunidade.injection;

import android.content.Context;

import br.gov.sc.cbm.fccomunidade.data.FirecastClient;
import br.gov.sc.cbm.fccomunidade.data.FirecastMockClient;
import br.gov.sc.cbm.fccomunidade.domain.OccurrenceRepository;

/**
 * Created by bonet on 9/30/16.
 */

public class AppProvider implements Provider {

    private FirecastMockClient client;

    public  AppProvider(Context context) {
        this.client = new FirecastMockClient();
    }

    @Override
    public OccurrenceRepository provideOccurrenceRepo() {
        return client;
    }
}