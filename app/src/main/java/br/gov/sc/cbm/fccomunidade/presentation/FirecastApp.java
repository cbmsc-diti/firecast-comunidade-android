package br.gov.sc.cbm.fccomunidade.presentation;

import android.app.Application;

import br.gov.sc.cbm.fccomunidade.data.FirecastClient;
import br.gov.sc.cbm.fccomunidade.domain.OccurrenceRepository;
import br.gov.sc.cbm.fccomunidade.injection.AppProvider;
import br.gov.sc.cbm.fccomunidade.injection.Injector;
import br.gov.sc.cbm.fccomunidade.injection.Provider;

/**
 * Created by bonet on 9/12/16.
 */

public class FirecastApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Injector.init(new AppProvider(this));



    }


}
