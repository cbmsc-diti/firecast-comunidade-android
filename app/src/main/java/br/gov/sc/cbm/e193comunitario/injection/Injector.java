package br.gov.sc.cbm.e193comunitario.injection;

import br.gov.sc.cbm.e193comunitario.domain.OccurenceRepository;

/**
 * Created by bonet on 9/13/16.
 */
public class Injector implements Provider{
    private static Injector instance = null;

    public static Injector init(Provider provider) {
        return instance = new Injector(provider);
    }

    public static Injector get() {

        if(instance == null)
            throw new IllegalStateException("Injector not initialized");

        return instance;
    }

    private Injector(Provider provider) {
        this.provider = provider;
    }

    private Provider provider;

    @Override
    public OccurenceRepository provideOccurenceRepo() {
        return provider.provideOccurenceRepo();
    }
}
