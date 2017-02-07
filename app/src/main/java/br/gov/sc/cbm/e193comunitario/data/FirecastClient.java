package br.gov.sc.cbm.e193comunitario.data;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import br.gov.sc.cbm.e193comunitario.data.events.OccurrencesFailedLoading;
import br.gov.sc.cbm.e193comunitario.data.events.OcurrencesFinishedLoading;
import br.gov.sc.cbm.e193comunitario.domain.Occurrence;
import br.gov.sc.cbm.e193comunitario.domain.OccurrenceRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bonet on 9/13/16.
 */

public class FirecastClient implements OccurrenceRepository{

    private FirecastApi api;

    public FirecastClient() {
        api = buildApi();
    }

    public void getOccurrences() {
        api.getOccurrences().enqueue(new Callback<List<Occurrence>>() {
            @Override
            public void onResponse(Call<List<Occurrence>> call, Response<List<Occurrence>> response) {
                EventBus.getDefault().post(new OcurrencesFinishedLoading(response.body()));
            }

            @Override
            public void onFailure(Call<List<Occurrence>> call, Throwable t) {
                EventBus.getDefault().post(new OccurrencesFailedLoading());
            }
        });
    }

    private FirecastApi buildApi() {
        return new Retrofit.Builder()
                .baseUrl("http://aplicativosweb.cbm.sc.gov.br/e193comunitario/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(FirecastApi.class);
    }

}
