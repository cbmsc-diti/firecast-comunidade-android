package br.gov.sc.cbm.fccomunidade.data;

import java.util.List;

import br.gov.sc.cbm.fccomunidade.domain.Occurrence;
import br.gov.sc.cbm.fccomunidade.domain.OccurrenceRepository;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by bonet on 9/13/16.
 */

public class FirecastClient implements OccurrenceRepository {

    private FirecastApi api;

    public FirecastClient() {
        api = buildApi();
    }

    @Override
    public Observable<List<Occurrence>> getOccurrences() {
        return api.getOccurrences();
    }

    private FirecastApi buildApi() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
// add your other interceptors …

// add logging as last interceptor
        httpClient.addInterceptor(chain -> {

         Response r = chain.proceed(chain.request());

            if(r.code() == 200 && r.body().string().isEmpty()) {
                return r.newBuilder().body(ResponseBody.create(r.body().contentType(), "")).build();
            }

            return r;
        });  // <-- this is the important line!

        return new Retrofit.Builder()
                .baseUrl("http://aplicativosweb.cbm.sc.gov.br/e193comunitario/")
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(FirecastApi.class);
    }


}
