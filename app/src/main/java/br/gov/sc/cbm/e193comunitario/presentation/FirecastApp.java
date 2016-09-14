package br.gov.sc.cbm.e193comunitario.presentation;

import android.app.Application;

import br.gov.sc.cbm.e193comunitario.data.FirecastClient;
import br.gov.sc.cbm.e193comunitario.domain.OccurrenceRepository;
import br.gov.sc.cbm.e193comunitario.injection.Injector;
import br.gov.sc.cbm.e193comunitario.injection.Provider;

/**
 * Created by bonet on 9/12/16.
 */

public class FirecastApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Injector.init(new AppProvider());

    }

    class AppProvider implements Provider {

        @Override
        public OccurrenceRepository provideOccurrenceRepo() {
            return new FirecastClient();
        }
    }
}
