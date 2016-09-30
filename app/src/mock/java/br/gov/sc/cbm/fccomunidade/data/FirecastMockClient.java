package br.gov.sc.cbm.fccomunidade.data;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import br.gov.sc.cbm.fccomunidade.domain.Occurrence;
import br.gov.sc.cbm.fccomunidade.domain.OccurrenceRepository;
import rx.Observable;

/**
 * Created by bonet on 9/30/16.
 */

public class FirecastMockClient implements OccurrenceRepository {


    private List<Occurrence> occurences;

    private Context ctx;

    public FirecastMockClient(Context ctx) {
        this.ctx = ctx;
        init();
    }

    private void init() {
        Gson g = new Gson();

        try {
            occurences = g.fromJson(new InputStreamReader(ctx.getAssets().open("sampleresponse.json")), new TypeToken<ArrayList<Occurrence>>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    @Override
    public Observable<List<Occurrence>> getOccurrences() {
        return Observable.just(occurences).delay(2, TimeUnit.SECONDS);
    }
}
