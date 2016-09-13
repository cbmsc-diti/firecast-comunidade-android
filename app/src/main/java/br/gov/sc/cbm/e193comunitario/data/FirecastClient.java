package br.gov.sc.cbm.e193comunitario.data;

import java.util.List;

import br.gov.sc.cbm.e193comunitario.domain.Occurence;
import br.gov.sc.cbm.e193comunitario.domain.OccurenceRepository;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by bonet on 9/13/16.
 */

public class FirecastClient implements OccurenceRepository {

    private FirecastApi api;

    public FirecastClient() {
        api = buildApi();
    }

    @Override
    public Observable<List<Occurence>> getOccurrences() {
        return api.getOccurrences();
    }

    private FirecastApi buildApi() {
        return new Retrofit.Builder()
                .baseUrl("http://aplicativosweb.cbm.sc.gov.br/api/defesacivil/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(FirecastApi.class);
    }

}
